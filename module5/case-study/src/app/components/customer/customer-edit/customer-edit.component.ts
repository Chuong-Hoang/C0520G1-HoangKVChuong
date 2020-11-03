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
  public customerTypeList;

  constructor(
    private formBuilder: FormBuilder,
    private customerService: CustomerService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.formEdit = this.formBuilder.group({
      id: '',
      name: ['', Validators.required],
      birthday: ['', Validators.required],
      idCard: ['', [Validators.required, Validators.pattern('^[0-9]{9}$')]],
      phone: ['', [Validators.required, Validators.pattern('^((090|091|([\(][\+]84[\)])90|([\(][\+]84[\)])91)[0-9]{7})$')]],
      email: ['', [Validators.required, Validators.email]],
      address: ['', Validators.required],
      customerType: ['', Validators.required]
    });

    // only for Edit
    this.route.params.subscribe(data =>{
      this.eleId = data.id;
      this.customerService.getById(this.eleId).subscribe(dataFromServer =>{
        this.formEdit.patchValue(dataFromServer);
      })
    });

    this.customerService.getCustomerType()
      .subscribe(data => this.customerTypeList = data, error => this.customerTypeList = []);
  }

  clickToEdit(){
    console.log(this.formEdit.value);
    this.customerService.editElement(this.eleId, this.formEdit.value).subscribe(data => {
      console.log(data);
      this.router.navigate(['/customer-list'], {queryParams: {edit_msg: 'Update successfully!', si: true}});
      // this.router.navigateByUrl('customer-list');
    })
  }

  emailValidators(formControl: FormControl){
    if(formControl.value.includes('@')){
      return null
    }
    return { email: true}

  }

}
