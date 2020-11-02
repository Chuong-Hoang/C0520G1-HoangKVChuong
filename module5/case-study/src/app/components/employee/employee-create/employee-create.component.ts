import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-employee-create',
  templateUrl: './employee-create.component.html',
  styleUrls: ['./employee-create.component.css']
})
export class EmployeeCreateComponent implements OnInit {

  showCreateForm:boolean = false;
  showListForm:boolean = false;
  readonly:boolean = false;
  hidden:boolean = false;

  employee = {
    id: 0,
    name: '',
    birthday: '',
    idCard: '',
    phone: '',
    email: '',
    address: '',
    salary: '',
    position: 'supervisor',
    division: 'service',
    education: 'university'
  };

  constructor() {
  }

  ngOnInit(): void {
  }

  resetValues(){
    this.employee.id = 0;
    this.employee.name = '';
    this.employee.birthday = '';
    this.employee.idCard = '';
    this.employee.phone = '';
    this.employee.email = '';
    this.employee.address = '';
    this.employee.salary = '';
    this.employee.position = 'supervisor';
    this.employee.division = 'administration';
    this.employee.education = 'university';
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
      salary: '1500',
      position: 'staff',
      division: 'administration',
      education: 'university'
    },
    {
      id: 2,
      name: 'Nhat',
      birthday: '1988-04-20',
      idCard: '123456789',
      phone: '0909090909',
      email: 'nhat@abc.com',
      address: 'SG',
      salary: '1500',
      position: 'waiter',
      division: 'service',
      education: 'college'
    },
    {
      id: 3,
      name: 'Nguyen',
      birthday: '1988-04-20',
      idCard: '123456789',
      phone: '0909090909',
      email: 'nguyen@abc.com',
      address: 'QN',
      salary: '1500',
      position: 'supervisor',
      division: 'administration',
      education: 'pre-college'
    },
    {
      id: 4,
      name: 'Hoang',
      birthday: '1988-04-20',
      idCard: '123456789',
      phone: '0909090909',
      email: 'hoang@abc.com',
      address: 'DN',
      salary: '1500',
      position: 'manager',
      division: 'management',
      education: 'after-university'
    },
    {
      id: 5,
      name: 'Ngoc',
      birthday: '1988-04-20',
      idCard: '123456789',
      phone: '0909090909',
      email: 'ngoc@abc.com',
      address: 'HN',
      salary: '1500',
      position: 'director',
      division: 'administration',
      education: 'university'
    }
  ];

  addNew() {
    let updateId = 0;
    let index = -1;
    if(this.employee.id === 0){
      updateId = Math.ceil(Math.random()*1000);
    } else {
      updateId = this.employee.id;
      index = this.eList.findIndex(el => el.id === updateId);
      this.eList.splice(index, 1);
    }
    this.eList.unshift({
      id: updateId,
      name: this.employee.name,
      birthday: this.employee.birthday,
      idCard: this.employee.idCard,
      phone: this.employee.phone,
      email: this.employee.email,
      address: this.employee.address,
      salary: this.employee.salary,
      position: this.employee.position,
      division: this.employee.division,
      education: this.employee.education
    });

    this.displayListForm();

  }

  deleteOne(id:number){
    const index = this.eList.findIndex(el => el.id === id);
    this.eList.splice(index, 1);
  }

  updateOne(id:number){
    const index = this.eList.findIndex(el => el.id === id);
    let ele = this.eList[index];
    // this.customerList.splice(index, 1);
    this.employee.id = ele.id;
    this.employee.name = ele.name;
    this.employee.birthday = ele.birthday;
    this.employee.idCard = ele.idCard;
    this.employee.phone = ele.phone;
    this.employee.email = ele.email;
    this.employee.address = ele.address;
    this.employee.salary = ele.salary;
    this.employee.position = ele.position;
    this.employee.division = ele.division;
    this.employee.education = ele.education;

    this.displayCreateForm();
  }

}
