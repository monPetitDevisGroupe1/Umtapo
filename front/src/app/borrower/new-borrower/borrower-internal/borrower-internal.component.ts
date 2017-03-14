import {Component, OnInit, ViewChild, ViewContainerRef, AfterViewInit} from '@angular/core';
import {NewBorrowerDataService} from '../../../../service/data-binding/new-borrower-data.service';
import {FormGroup, FormControl, FormBuilder, Validators} from '@angular/forms';
import {MdSnackBar} from '@angular/material';
import {ValidationService} from '../../../../validator/validationService';
import {Subscription} from '../../../../entity/subscription';
import {Library} from '../../../../entity/library';
import {LibraryService} from '../../../../service/library.service';
import {BorrowerService} from '../../../../service/borrower.service';
import {Borrower} from '../../../../entity/borrower';
import {NewBorrower} from '../new-borrower.interface';
import {SubscriptionService} from '../../../../service/subscription.service';
import {logger} from '../../../../environments/environment';
import {ModalDirective} from 'ng2-bootstrap';
import {Router} from '@angular/router';
import {ToastsManager} from 'ng2-toastr';

@Component({
  selector: 'umt-borrower-internal',
  templateUrl: './borrower-internal.component.html',
  styleUrls: ['./borrower-internal.component.scss'],
  providers: [BorrowerService, SubscriptionService]
})
export class BorrowerInternalComponent implements OnInit, NewBorrower {
  @ViewChild('confirmationModal') public confirmationModal: ModalDirective;
  form: FormGroup;
  library: Library;
  startSubscription: FormControl;
  endSubscription: Date;
  quota: FormControl;
  contribution: FormControl;
  comment: FormControl;
  emailOptin: FormControl;
  isRegistered: boolean;

  constructor(
    public dataService: NewBorrowerDataService,
    private formBuilder: FormBuilder,
    private snackBar: MdSnackBar,
    private libraryService: LibraryService,
    private borrowerService: BorrowerService,
    private subscriptionService: SubscriptionService,
    private router: Router,
    private toastr: ToastsManager,
    private vRef: ViewContainerRef
  ) {
    this.toastr.setRootViewContainerRef(vRef);
    this.isRegistered = false;
    let borrower: Borrower = this.dataService.borrower;
    let subscription: Subscription = this.dataService.subscription;

    this.startSubscription = new FormControl(
      subscription != null ? new Date(subscription.start).toJSON().split('T')[0] : new Date().toJSON().split('T')[0],
      [Validators.required, ValidationService.dateValidator]);
    this.contribution = new FormControl(
      subscription != null ? subscription.contribution : '',
      Validators.required);
    this.quota = new FormControl(borrower != null ? borrower.quota : '', Validators.required);
    this.comment = new FormControl(borrower != null ? borrower.comment : '');
    this.emailOptin = new FormControl(borrower != null ? borrower.emailOptin : '');

    this.library = this.libraryService.findLocally();
    this.dataService.step = 2;
    this.setEndSubscriptionDate();
  }

  ngOnInit() {
    this.form = this.formBuilder.group({
      'startSubscription': this.startSubscription,
      'quota': this.quota,
      'contribution': this.contribution,
      'comment': this.comment,
      'emailOptin': this.emailOptin
    });
  }

  onSubmit(value: any): void {

    if (this.form.valid) {
      logger.info('valid form :', value);

      this.saveData();

      this.borrowerService
        .save(this.dataService.borrower)
        .then(borrower => {
          this.dataService.borrower = borrower;
          this.dataService.subscription.borrower = borrower;
          this.subscriptionService
            .save(this.dataService.subscription)
            .then(subscription => {
              this.isRegistered = true;
              this.dataService.subscription = subscription;
              this.confirmationModal.show();
            })
            .catch(response => {
              logger.error(response);
              this.toastr.error(`Problème durant l\'enregistrement de l\'utilisateur`, 'Problème', {toastLife: 2000});
            });
        })
        .catch(response => {
          this.toastr.error(`Problème durant l\'enregistrement de l\'abonnement`, 'Problème', {toastLife: 2000});
          logger.error(response);
        });
    } else {
      logger.info('Invalid form :', value);
      if (this.form.controls['startSubscription'].invalid) {
        this.snackBar.open(
          ValidationService.getValidatorErrorMessage('invalidDate', true) + ' StartSubscription',
          'OK');
      }
    }
  }

  /**
   * Define subscription end date based on start date and library default subscription duration.
   */
  setEndSubscriptionDate() {
    let date = new Date(this.startSubscription.value);
    date.setDate(date.getDate() + this.library.subscriptionDuration);

    this.endSubscription = date;
  }

  saveData(): void {
    let value = this.form.value;

    this.dataService.borrower.quota = value.quota;
    this.dataService.borrower.emailOptin = value.emailOptin;
    this.dataService.borrower.comment = value.comment;

    let subscription: Subscription = new Subscription();
    subscription.start = new Date(value.startSubscription);
    subscription.contribution = value.contribution;
    subscription.library = this.library;

    this.dataService.subscription = subscription;
  }

  flushForm(): void {
    this.dataService.flush();
    this.router.navigate(['borrowers/new']);
  }
}
