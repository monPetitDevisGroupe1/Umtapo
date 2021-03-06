package util;

import org.lenndi.umtapo.dto.AddressDto;
import org.lenndi.umtapo.dto.BorrowerDto;
import org.lenndi.umtapo.dto.ItemDto;
import org.lenndi.umtapo.dto.LibraryDto;
import org.lenndi.umtapo.dto.SimpleBorrowerDto;
import org.lenndi.umtapo.dto.SimpleLibraryDto;
import org.lenndi.umtapo.dto.SubscriptionDto;
import org.lenndi.umtapo.entity.Address;
import org.lenndi.umtapo.entity.Borrower;
import org.lenndi.umtapo.entity.Item;
import org.lenndi.umtapo.entity.Library;
import org.lenndi.umtapo.entity.ShelfMark;
import org.lenndi.umtapo.entity.Subscription;
import org.lenndi.umtapo.enumeration.Condition;
import org.lenndi.umtapo.enumeration.ItemType;
import org.lenndi.umtapo.solr.document.BorrowerDocument;
import org.lenndi.umtapo.solr.document.bean.record.Record;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UtilCreator {

    private ZonedDateTime birthday;
    private ZonedDateTime olderReturn;
    private ZonedDateTime subscriptionStart;
    private ZonedDateTime subscriptionEnd;
    private ZonedDateTime loanStart;
    private ZonedDateTime loanEnd;

    public UtilCreator() {
        birthday = java.time.ZonedDateTime.of(1984, 7, 14, 0, 0, 0, 0, ZoneId.systemDefault());
        olderReturn = java.time.ZonedDateTime.of(2017, 1, 14, 0, 0, 0, 0, ZoneId.systemDefault());
        subscriptionStart = java.time.ZonedDateTime.of(2016, 10, 1, 0, 0, 0, 0, ZoneId.systemDefault());
        subscriptionEnd = java.time.ZonedDateTime.of(2017, 10, 1, 0, 0, 0, 0, ZoneId.systemDefault());
        loanStart = java.time.ZonedDateTime.of(2017, 1, 1, 0, 0, 0, 0, ZoneId.systemDefault());
        loanEnd = java.time.ZonedDateTime.of(2017, 2, 1, 0, 0, 0, 0, ZoneId.systemDefault());
    }

    public BorrowerDocument createBorrowerDocument(String id, String name, String email) {
        Library library = this.createLibrary(1, false);
        BorrowerDocument borrowerDocument = new BorrowerDocument();
        borrowerDocument.setId(id);
        borrowerDocument.setName(name);
        borrowerDocument.setComment("Un bien bel usager.");
        borrowerDocument.setBirthday(Date.from(birthday.toInstant()));
        borrowerDocument.setQuota(5);
        borrowerDocument.setEmailOptin(true);
        borrowerDocument.setAddressId("3");
        borrowerDocument.setAddress1("3 rue des poules");
        borrowerDocument.setAddress2("Étage 5");
        borrowerDocument.setZip("35000");
        borrowerDocument.setCity("Rennes");
        borrowerDocument.setPhone("0299813994");
        borrowerDocument.setEmail(email);
        borrowerDocument.setNbLoans(3);
        borrowerDocument.setTooMuchLoans(false);
        borrowerDocument.setOlderReturn(Date.from(olderReturn.toInstant()));
        borrowerDocument.setSubscriptionStart(Date.from(subscriptionStart.toInstant()));
        borrowerDocument.setSubscriptionEnd(Date.from(subscriptionEnd.toInstant()));
        borrowerDocument.setLibraryId(1);
        borrowerDocument.setLibraryName(library.getName());

        return borrowerDocument;
    }

    public Borrower createBorrower(Integer id, String name, String email) {
        Address address = new Address();
        Borrower borrower = new Borrower();

        borrower.setId(id);
        borrower.setName(name);
        borrower.setComment("Un bien bel usager.");
        borrower.setBirthday(birthday);
        borrower.setQuota(5);
        borrower.setEmailOptin(true);
        address.setId(3);
        address.setAddress1("3 rue des poules");
        address.setAddress2("Étage 5");
        address.setZip("35000");
        address.setCity("Rennes");
        address.setPhone("0299813994");
        address.setEmail(email);
        borrower.setAddress(address);

        return borrower;
    }

    public Borrower createBorrower(Integer id) {
        Address address = new Address();
        Borrower borrower = new Borrower();

        borrower.setId(id);
        borrower.setName("Michel Test");
        borrower.setComment("Un bien bel usager.");
        borrower.setBirthday(birthday);
        borrower.setQuota(5);
        borrower.setEmailOptin(true);
        address.setId(3);
        address.setAddress1("3 rue des poules");
        address.setAddress2("Étage 5");
        address.setZip("35000");
        address.setCity("Rennes");
        address.setPhone("0299813994");
        address.setEmail("michel@test.com");
        borrower.setAddress(address);

        return borrower;
    }

    public BorrowerDto createBorrowerDto(Integer id) {
        AddressDto address = new AddressDto();
        BorrowerDto borrower = new BorrowerDto();

        borrower.setId(id);
        borrower.setName("Michel Test");
        borrower.setComment("Un bien bel usager.");
        borrower.setBirthday(birthday);
        borrower.setQuota(5);
        borrower.setEmailOptin(true);
        address.setId(3);
        address.setAddress1("3 rue des poules");
        address.setAddress2("Étage 5");
        address.setZip("35000");
        address.setCity("Rennes");
        address.setPhone("0299813994");
        address.setEmail("michel@test.com");
        borrower.setAddress(address);

        return borrower;
    }

    public SimpleBorrowerDto createSimpleBorrowerDto(Integer id) {
        AddressDto address = new AddressDto();
        SimpleBorrowerDto borrower = new SimpleBorrowerDto();

        borrower.setId(id);
        borrower.setName("Michel Test");
        borrower.setComment("Un bien bel usager.");
        borrower.setBirthday(birthday);
        borrower.setQuota(5);
        borrower.setEmailOptin(true);
        address.setId(3);
        address.setAddress1("3 rue des poules");
        address.setAddress2("Étage 5");
        address.setZip("35000");
        address.setCity("Rennes");
        address.setPhone("0299813994");
        address.setEmail("michel@test.com");
        borrower.setAddress(address);

        return borrower;
    }

    public BorrowerDto createBorrowerDto(Integer id, String name, String email) {
        AddressDto address = new AddressDto();
        BorrowerDto borrower = new BorrowerDto();

        borrower.setId(id);
        borrower.setName(name);
        borrower.setComment("Un bien bel usager.");
        borrower.setBirthday(birthday);
        borrower.setQuota(5);
        borrower.setEmailOptin(true);
        address.setId(3);
        address.setAddress1("3 rue des poules");
        address.setAddress2("Étage 5");
        address.setZip("35000");
        address.setCity("Rennes");
        address.setPhone("0299813994");
        address.setEmail(email);
        borrower.setAddress(address);

        return borrower;
    }

    public SimpleBorrowerDto createSimpleBorrowerDto(Integer id, String name, String email) {
        AddressDto address = new AddressDto();
        SimpleBorrowerDto borrower = new SimpleBorrowerDto();

        borrower.setId(id);
        borrower.setName(name);
        borrower.setComment("Un bien bel usager.");
        borrower.setBirthday(birthday);
        borrower.setQuota(5);
        borrower.setEmailOptin(true);
        address.setId(3);
        address.setAddress1("3 rue des poules");
        address.setAddress2("Étage 5");
        address.setZip("35000");
        address.setCity("Rennes");
        address.setPhone("0299813994");
        address.setEmail(email);
        borrower.setAddress(address);

        return borrower;
    }

    public Library createLibrary(Integer id, boolean external) {
        Library library = new Library();

        library.setId(id);
        library.setName("Test Library");
        library.setBorrowDuration(30);
        library.setSubscriptionDuration(365);
        library.setCurrency("€");
        library.setDefaultZ3950(1);
        library.setShelfMarkNb(3);
        library.setUseDeweyClassification(false);
        library.setFirstInternalId(1234);
        library.setExternal(external);

        return library;
    }

    public Library createLibrary(Integer id, String name, boolean external) {
        Library library = new Library();

        library.setId(id);
        library.setName(name);
        library.setBorrowDuration(30);
        library.setSubscriptionDuration(365);
        library.setCurrency("€");
        library.setDefaultZ3950(1);
        library.setShelfMarkNb(3);
        library.setUseDeweyClassification(false);
        library.setFirstInternalId(1234);
        library.setExternal(external);

        return library;
    }

    public LibraryDto createLibraryDto(Integer id) {
        LibraryDto library = new LibraryDto();

        library.setId(id);
        library.setName("Test Library");
        library.setBorrowDuration(30);
        library.setSubscriptionDuration(365);
        library.setCurrency("€");
        library.setDefaultZ3950(1);
        library.setShelfMarkNb(3);
        library.setUseDeweyClassification(false);
        library.setFirstInternalId(1234);

        return library;
    }

    public SimpleLibraryDto createSimpleLibraryDto(Integer id) {
        SimpleLibraryDto library = new SimpleLibraryDto();

        library.setId(id);
        library.setName("Test Library");
        library.setBorrowDuration(30);
        library.setSubscriptionDuration(365);
        library.setCurrency("€");
        library.setDefaultZ3950(1);
        library.setShelfMarkNb(3);
        library.setUseDeweyClassification(false);
        library.setFirstInternalId(1234);

        return library;
    }

    public LibraryDto createLibraryDto(Integer id, Boolean external) {
        LibraryDto library = new LibraryDto();

        library.setId(id);
        library.setName("Test Library");
        library.setBorrowDuration(30);
        library.setSubscriptionDuration(365);
        library.setCurrency("€");
        library.setDefaultZ3950(1);
        library.setShelfMarkNb(3);
        library.setUseDeweyClassification(false);
        library.setFirstInternalId(1234);
        library.setExternal(external);

        return library;
    }

    public SimpleLibraryDto createSimpleLibraryDto(Integer id, Boolean external) {
        SimpleLibraryDto library = new SimpleLibraryDto();

        library.setId(id);
        library.setName("Test Library");
        library.setBorrowDuration(30);
        library.setSubscriptionDuration(365);
        library.setCurrency("€");
        library.setDefaultZ3950(1);
        library.setShelfMarkNb(3);
        library.setUseDeweyClassification(false);
        library.setFirstInternalId(1234);
        library.setExternal(external);

        return library;
    }

    public Record createRecord(String title, String author, String date) {
        Record record = new Record();
        record.getTitle().setMainTitle(title);
        record.getCreator().setName(author);
        record.getDate().setPublicationDate(date);

        return record;
    }

    public List<Record> createRecordList() {
        List<Record> records = new ArrayList<>();
        records.add(createRecord("Test", "Michel Test", "2017"));
        records.add(createRecord("Yop", "Francis", "1987"));
        records.add(createRecord("Hop", "Gudule", "890"));

        return records;
    }

    public Item createItem(Integer id, Integer internalId) {
        Item item = new Item();
        Library library = new Library();
        library.setId(1);

        item.setId(id);
        item.setInternalId(internalId);
        item.setCurrency("€");
        item.setBorrowed(false);
        item.setCondition(Condition.NEW);
        item.setLibrary(library);
        item.setLoanable(true);
        item.setPurchasePrice(600);
        item.setType(ItemType.BOOK);
        item.setShelfmark(new ShelfMark("TES", "002", "URI"));

        return item;
    }

    public ItemDto createItemDto(Integer id, Integer internalId) {
        ItemDto item = new ItemDto();
        LibraryDto library = new LibraryDto();
        library.setId(1);

        item.setId(id);
        item.setInternalId(internalId);
        item.setCurrency("€");
        item.setBorrowed(false);
        item.setCondition(Condition.NEW);
        item.setLibrary(library);
        item.setLoanable(true);
        item.setPurchasePrice(6.0f);
        item.setType(ItemType.BOOK);
        item.setShelfmark(new ShelfMark("TES", "002", "URI"));

        return item;
    }

    public Subscription createSubscription(Integer id, Borrower borrower, Library library) {
        Subscription subscription = new Subscription();
        subscription.setId(id);
        subscription.setContribution(650);
        subscription.setStart(this.subscriptionStart);
        subscription.setEnd(this.subscriptionEnd);
        subscription.setBorrower(borrower);
        subscription.setLibrary(library);

        return subscription;
    }

    public SubscriptionDto createSubscriptionDto(Integer id, SimpleBorrowerDto borrowerDto, SimpleLibraryDto libraryDto) {
        SubscriptionDto subscription = new SubscriptionDto();
        subscription.setId(id);
        subscription.setContribution(6.5f);
        subscription.setStart(this.subscriptionStart);
        subscription.setEnd(this.subscriptionEnd);
        subscription.setBorrower(borrowerDto);
        subscription.setLibrary(libraryDto);

        return subscription;
    }

    public ZonedDateTime getBirthday() {
        return birthday;
    }

    public ZonedDateTime getOlderReturn() {
        return olderReturn;
    }

    public ZonedDateTime getSubscriptionStart() {
        return subscriptionStart;
    }

    public ZonedDateTime getSubscriptionEnd() {
        return subscriptionEnd;
    }

    public ZonedDateTime getLoanStart() {
        return loanStart;
    }

    public ZonedDateTime getLoanEnd() {
        return loanEnd;
    }
}
