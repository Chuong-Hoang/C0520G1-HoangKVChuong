export class Customer{
  private _name: string;
  private _birthday: string;
  private _idCard: string;
  private _phone: string;
  private _email: string;
  private _address: string;
  private _customerType: string;

  constructor(name: string, birthday: string, idCard: string, phone: string, email: string, address: string, customerType: string){
    this._name = name;
    this._birthday = birthday;
    this._idCard = idCard;
    this._phone = phone;
    this._email = email;
    this._address = address;
    this._customerType = customerType;
  }


  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get birthday(): string {
    return this._birthday;
  }

  set birthday(value: string) {
    this._birthday = value;
  }

  get idCard(): string {
    return this._idCard;
  }

  set idCard(value: string) {
    this._idCard = value;
  }

  get phone(): string {
    return this._phone;
  }

  set phone(value: string) {
    this._phone = value;
  }

  get email(): string {
    return this._email;
  }

  set email(value: string) {
    this._email = value;
  }

  get address(): string {
    return this._address;
  }

  set address(value: string) {
    this._address = value;
  }

  get customerType(): string {
    return this._customerType;
  }

  set customerType(value: string) {
    this._customerType = value;
  }
}
