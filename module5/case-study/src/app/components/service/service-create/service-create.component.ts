import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ServiceFuService} from "../../../services/serviceFu.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-service-create',
  templateUrl: './service-create.component.html',
  styleUrls: ['./service-create.component.css']
})
export class ServiceCreateComponent implements OnInit {
  id_msg = 'id is required';
  name_msg = 'name is required';
  area_msg = 'area is required';
  cost_msg = 'cost is required';
  maxPeople_msg = 'maxPeople is required';
  rentType_msg = 'rentType is required';
  serviceType_msg = 'serviceType is required';
  standardRoom_msg = 'standardRoom is required';
  numberOfFloors_msg = 'numberOfFloors is required';
  otherConvenience_msg = 'other-convenience is required';
  poolArea_msg = 'poolArea is required';
  freeService_msg = 'freeService is required';

  formCreate: FormGroup;
  serviceTypeList: any;
  rentTypeList: any;


  constructor(
    private formBuilder: FormBuilder,
    private serviceFuService: ServiceFuService,
    private router:Router
  ) {}

  ngOnInit(): void {
    this.formCreate = this.formBuilder.group({
      id: '',
      name: ['', Validators.required],
      area: ['', Validators.required],
      cost: ['', Validators.required],
      maxPeople: ['', Validators.required],
      rentType: ['', Validators.required],
      serviceType: ['', Validators.required],
      standardRoom: ['Vip', Validators.required],
      numberOfFloors: ['', Validators.required],
      otherConvenience: ['', Validators.required],
      poolArea: ['', Validators.required],
      freeService: ['', Validators.required],
    });
    this.serviceFuService.getServiceType()
      .subscribe(data => this.serviceTypeList = data, error => this.serviceTypeList = []);
    this.serviceFuService.getRentType()
      .subscribe(data => this.rentTypeList = data, error => this.rentTypeList = []);
  }

  onSubmit() {
    console.log(this.formCreate.value);
    this.serviceFuService.createNew(this.formCreate.value).subscribe(data => {
      console.log(data);
      this.router.navigate(['/service-list'], {queryParams: {create_msg: 'Create successfully!', si: true}});
      // this.router.navigateByUrl('service-list');
    })
  }
}
