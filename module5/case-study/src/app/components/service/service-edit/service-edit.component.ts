import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ServiceFuService} from "../../../services/serviceFu.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-service-edit',
  templateUrl: './service-edit.component.html',
  styleUrls: ['./service-edit.component.css']
})
export class ServiceEditComponent implements OnInit {
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

  formEdit: FormGroup;
  serviceTypeList: any;
  rentTypeList: any;
  private eleId: any;

  constructor(
    private formBuilder: FormBuilder,
    private serviceFuService: ServiceFuService,
    private router:Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.formEdit = this.formBuilder.group({
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

    // only for Edit
    this.route.params.subscribe(data =>{
      this.eleId = data.id;
      this.serviceFuService.getById(this.eleId).subscribe(dataFromServer =>{
        this.formEdit.patchValue(dataFromServer);
      })
    });

    this.serviceFuService.getServiceType()
      .subscribe(data => this.serviceTypeList = data, error => this.serviceTypeList = []);
    this.serviceFuService.getRentType()
      .subscribe(data => this.rentTypeList = data, error => this.rentTypeList = []);
  }

  clickToEdit() {
    console.log(this.formEdit.value);
    this.serviceFuService.editElement(this.eleId, this.formEdit.value).subscribe(data => {
      console.log(data);
      this.router.navigate(['/service-list'], {queryParams: {edit_msg: 'Update successfully!'}});
      // this.router.navigateByUrl('service-list');
    })
  }
}
