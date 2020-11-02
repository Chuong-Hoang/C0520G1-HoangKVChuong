import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-service-create',
  templateUrl: './service-create.component.html',
  styleUrls: ['./service-create.component.css']
})
export class ServiceCreateComponent implements OnInit {

  showCreateForm:boolean = false;
  showListForm:boolean = false;
  readonly:boolean = false;
  hidden:boolean = false;

  service = {
    id: 0,
    name: '',
    area: '',
    cost: '',
    maxPeople: '',
    rentType: 'Month',
    serviceType: 'Villa',

    standardRoom: '',
    numberOfFloors: '',
    otherConvenience: '',
    poolArea: '',
    freeService: ''
  };

  constructor() {
  }

  ngOnInit(): void {
  }

  resetValues(){
    this.service.id = 0;
    this.service.name = '';
    this.service.area = '';
    this.service.cost = '';
    this.service.maxPeople = '';
    this.service.rentType = 'Month';
    this.service.serviceType = 'Villa';

    this.service.standardRoom = '';
    this.service.numberOfFloors = '';
    this.service.otherConvenience = '';
    this.service.poolArea = '';
    this.service.freeService = '';
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
      name: 'VL-0001',
      area: '123',
      cost: '1200',
      maxPeople: '4',
      rentType: 'Month',
      serviceType: 'Villa',
      standardRoom: 'Vip',
      numberOfFloors: '2',
      otherConvenience: 'Laundry',
      poolArea: '90',
      freeService: 'N/A'
    },
    {
      id: 2,
      name: 'VL-0002',
      area: '123',
      cost: '1200',
      maxPeople: '4',
      rentType: 'Month',
      serviceType: 'Villa',
      standardRoom: 'Vip',
      numberOfFloors: '2',
      otherConvenience: 'Laundry',
      poolArea: '90',
      freeService: 'N/A'
    },
    {
      id: 3,
      name: 'HO-0003',
      area: '123',
      cost: '1200',
      maxPeople: '4',
      rentType: 'Month',
      serviceType: 'House',
      standardRoom: 'Vip',
      numberOfFloors: '2',
      otherConvenience: 'Laundry',
      poolArea: 'N/A',
      freeService: 'N/A'
    },
    {
      id: 4,
      name: 'HO-0004',
      area: '123',
      cost: '1200',
      maxPeople: '4',
      rentType: 'Month',
      serviceType: 'Villa',
      standardRoom: 'Vip',
      numberOfFloors: '2',
      otherConvenience: 'Laundry',
      poolArea: 'N/A',
      freeService: 'N/A'
    },
    {
      id: 5,
      name: 'RO-0005',
      area: '123',
      cost: '1200',
      maxPeople: '4',
      rentType: 'Month',
      serviceType: 'Room',
      standardRoom: 'N/A',
      numberOfFloors: 'N/A',
      otherConvenience: 'N/A',
      poolArea: 'N/A',
      freeService: 'Golf'
    },
    {
      id: 6,
      name: 'RO-0006',
      area: '123',
      cost: '1200',
      maxPeople: '4',
      rentType: 'Month',
      serviceType: 'Room',
      standardRoom: 'N/A',
      numberOfFloors: 'N/A',
      otherConvenience: 'N/A',
      poolArea: 'N/A',
      freeService: 'Golf'
    },

  ];

  addNew() {
    let updateId = 0;
    let index = -1;
    if(this.service.id === 0){
      updateId = Math.ceil(Math.random()*1000);
    } else {
      updateId = this.service.id;
      index = this.eList.findIndex(el => el.id === updateId);
      this.eList.splice(index, 1);
    }
    if(this.service.serviceType === 'Villa'){
      this.service.freeService = 'N/A';
    } else if (this.service.serviceType === 'House'){
      this.service.poolArea = 'N/A';
      this.service.freeService = 'N/A';
    } else {
      this.service.standardRoom = 'N/A';
      this.service.numberOfFloors = 'N/A';
      this.service.otherConvenience = 'N/A';
      this.service.poolArea = 'N/A';
    }
    this.eList.unshift({
      id: updateId,
      name: this.service.name,
      area: this.service.area,
      cost: this.service.cost,
      maxPeople: this.service.maxPeople,
      rentType: this.service.rentType,
      serviceType: this.service.serviceType,
      standardRoom: this.service.standardRoom,
      numberOfFloors: this.service.numberOfFloors,
      otherConvenience: this.service.otherConvenience,
      poolArea: this.service.poolArea,
      freeService: this.service.freeService
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
    this.service.id = ele.id;
    this.service.name = ele.name;
    this.service.area = ele.area;
    this.service.cost = ele.cost;
    this.service.maxPeople = ele.maxPeople;
    this.service.rentType = ele.rentType;
    this.service.serviceType = ele.serviceType;
    this.service.standardRoom = ele.standardRoom;
    this.service.numberOfFloors = ele.numberOfFloors;
    this.service.otherConvenience = ele.otherConvenience;
    this.service.poolArea = ele.poolArea;
    this.service.freeService = ele.freeService;

    this.displayCreateForm();
  }

}
