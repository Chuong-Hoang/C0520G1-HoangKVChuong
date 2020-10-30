import {Component, OnInit} from '@angular/core';
import {findIndex} from "rxjs/operators";

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {
  showCreateForm:boolean = false;
  showListForm:boolean = false;
  readonly:boolean = false;
  hidden:boolean = false;

  customer = {
    id: 0,
    name: '',
    birthday: '',
    idCard: '',
    phone: '',
    email: '',
    address: '',
    customerType: 'Gold'
  };

  constructor() {
  }

  ngOnInit(): void {
  }

  resetValues(){
    this.customer.id = 0;
    this.customer.name = '';
    this.customer.birthday = '';
    this.customer.idCard = '';
    this.customer.phone = '';
    this.customer.email = '';
    this.customer.address = '';
    this.customer.customerType = 'Gold';
  }

  displayCreateForm(){
    this.showCreateForm = true;
    this.showListForm = false;
    this.readonly = false;
    this.hidden = false;
  }

  displayListForm(){
    this.showCreateForm = false;
    this.showListForm = true;
    this.eList.sort((a, b) => ((a.id > b.id) ? 1: (a.id < b.id) ? -1 : 0));
    this.resetValues();
  }
  displayViewForm(id:number){
    this.updateOne(id);
    this.readonly = true;
    this.hidden = true;

  }

  eList = [
    {
      id: 1,
      name: 'Chuong',
      birthday: '1988-04-20',
      idCard: '123456789',
      phone: '0909090909',
      email: 'chuong@abc.com',
      address: 'QT',
      customerType: 'Silver'
    },
    {
      id: 2,
      name: 'Nhat',
      birthday: '1988-04-20',
      idCard: '123456789',
      phone: '0909090909',
      email: 'nhat@abc.com',
      address: 'SG',
      customerType: 'Diamond'
    },
    {
      id: 3,
      name: 'Nguyen',
      birthday: '1988-04-20',
      idCard: '123456789',
      phone: '0909090909',
      email: 'nguyen@abc.com',
      address: 'QN',
      customerType: 'Member'
    },
    {
      id: 4,
      name: 'Hoang',
      birthday: '1988-04-20',
      idCard: '123456789',
      phone: '0909090909',
      email: 'hoang@abc.com',
      address: 'DN',
      customerType: 'Gold'
    },
    {
      id: 5,
      name: 'Ngoc',
      birthday: '1988-04-20',
      idCard: '123456789',
      phone: '0909090909',
      email: 'ngoc@abc.com',
      address: 'HN',
      customerType: 'Platinum'
    }
  ];

  addNew() {
    let updateId = 0;
    let index = -1;
    if(this.customer.id === 0){
      updateId = Math.ceil(Math.random()*1000);
    } else {
      updateId = this.customer.id;
      index = this.eList.findIndex(el => el.id === updateId);
      this.eList.splice(index, 1);
    }
    this.eList.unshift({
      id: updateId,
      name: this.customer.name,
      birthday: this.customer.birthday,
      idCard: this.customer.idCard,
      phone: this.customer.phone,
      email: this.customer.email,
      address: this.customer.address,
      customerType: this.customer.customerType
    });

    this.displayListForm();

  }

  deleteOne(id:number){
    let confirm = prompt("Do you really want to delete?");
    if(confirm === 'y'){
      const index = this.eList.findIndex(el => el.id === id);
      this.eList.splice(index, 1);
    }
  }

  updateOne(id:number){
    const index = this.eList.findIndex(el => el.id === id);
    let ele = this.eList[index];

    this.customer.id = ele.id;
    this.customer.name = ele.name;
    this.customer.birthday = ele.birthday;
    this.customer.idCard = ele.idCard;
    this.customer.phone = ele.phone;
    this.customer.email = ele.email;
    this.customer.address = ele.address;
    this.customer.customerType = ele.customerType;

    this.displayCreateForm();
  }
}
