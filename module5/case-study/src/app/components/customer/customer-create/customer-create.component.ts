import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup, FormBuilder, Validators} from "@angular/forms";
import { CustomerService } from '../../../services/customer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {
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

  formCreate:FormGroup;
  constructor(
    private formBuilder: FormBuilder,
    private customerService: CustomerService,
    private router: Router
  ) {}

  ngOnInit(): void {
     this.formCreate = this.formBuilder.group({
       id: '',
       name: ['', Validators.required],
       birthday: ['', Validators.required],
       idCard: ['', Validators.required],
       phone: ['', Validators.required],
       email: ['', [Validators.required, this.emailValidators]],
       address: ['', Validators.required],
       customerType: 'Platinum'
     });
  }
  onSubmit(){
     console.log(this.formCreate.value);
     this.customerService.createNew(this.formCreate.value).subscribe(data => {
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
