export class RecordDate {
  publicationDate: string;
  manufactureDate: string;

  getPublicationDate(): string {
    return this.publicationDate;
  }

  setPublicationDate(value: string) {
    this.publicationDate = value;
  }

  getManufactureDate(): string {
    return this.manufactureDate;
  }

  setManufactureDate(value: string) {
    this.manufactureDate = value;
  }
}
