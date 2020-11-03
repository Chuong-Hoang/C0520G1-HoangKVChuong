import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup, FormBuilder, Validators} from "@angular/forms";
import { CustomerService } from '../../../services/customer.service';
import {NavigationExtras, Router} from '@angular/router';

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
  public customerTypeList;

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
       idCard: ['', [Validators.required, Validators.pattern('^[0-9]{9}$')]],
       phone: ['', [Validators.required, Validators.pattern('^((090|091|([\(][\+]84[\)])90|([\(][\+]84[\)])91)[0-9]{7})$')]],
       email: ['', [Validators.required, Validators.email]],
       address: ['', Validators.required],
       customerType: ['', Validators.required]
     });
     this.customerService.getCustomerType()
       .subscribe(data => this.customerTypeList = data, error => this.customerTypeList = []);
  }
  onSubmit(){
     console.log(this.formCreate.value);
     this.customerService.createNew(this.formCreate.value).subscribe(data => {
       console.log(data);
       this.router.navigate(['/customer-list'], {queryParams: {create_msg: 'Create successfully!', si: true}});
       // this.router.navigateByUrl('customer-list');
     })
  }
}
