import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, FormBuilder, Validators} from "@angular/forms";
import { CustomerService } from '../../../services/customer.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {
  id_msg = 'id is required';
  name_msg = 'name is required';
  birthday_msg = 'birthday is required';
  idCard_msg = 'idCard is required';
  phone_msg = 'phone is required';
  email_msg = 'email is required';
  address_msg = 'address is required';
  customerType_msg = 'customerType is required';
  maxDate = new Date();
  minDate = new Date(1920,0,1);

  formEdit:FormGroup;
  eleId: number;

  constructor(
    private formBuilder: FormBuilder,
    private customerService: CustomerService,
    private router: Router,
    private activeRouter: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.formEdit = this.formBuilder.group({
      id: '',
      name: ['', Validators.required],
      birthday: ['', Validators.required],
      idCard: ['', Validators.required],
      phone: ['', Validators.required],
      email: ['', [Validators.required, this.emailValidators]],
      address: ['', Validators.required],
      customerType: 'Platinum'
    });
    this.activeRouter.params.subscribe(data =>{
      this.eleId = data.id;
      this.customerService.getById(this.eleId).subscribe(dataFromServer =>{
        this.formEdit.patchValue(dataFromServer);
      })
    })
  }

  clickToEdit(){
    console.log(this.formEdit.value);
    this.customerService.editElement(this.eleId, this.formEdit.value).subscribe(data => {
      console.log(data);
      this.router.navigateByUrl('customer-list');
    })
  }

  emailValidators(formControl: FormControl){
    if(formControl.value.includes('@')){
      return null
    }
    return { email: true}

  }

}
