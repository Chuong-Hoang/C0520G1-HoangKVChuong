import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CustomerService} from "../../../services/customer.service";
import {Router} from "@angular/router";
import {ContractService} from "../../../services/contract.service";

@Component({
  selector: 'app-contract-create',
  templateUrl: './contract-create.component.html',
  styleUrls: ['./contract-create.component.css']
})
export class ContractCreateComponent implements OnInit {
  id_msg = 'id is required';
  startDate_msg = 'startDate is required';
  endDate_msg = 'endDate is required';
  totalMoney_msg = 'totalMoney is required';
  deposit_msg = 'deposit is required';
  service_msg = 'service is required';
  customer_msg = 'customer is required';
  employee_msg = 'employee is required';
  minDate = new Date();
  maxDate = new Date(2050,0,1);

  formCreate:FormGroup;
  serviceList: any;
  customerList: any;
  employeeList: any;

  constructor(
    private formBuilder: FormBuilder,
    private contractService: ContractService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.formCreate = this.formBuilder.group({
      id: '',
      startDate: ['', Validators.required],
      endDate: ['', Validators.required],
      totalMoney: ['', Validators.required],
      deposit: ['', Validators.required],
      service: ['', Validators.required],
      customer: ['', Validators.required],
      employee: ['', Validators.required]
    });

    this.contractService.getServices()
      .subscribe(data => this.serviceList = data, error => this.serviceList = []);
    this.contractService.getCustomers()
      .subscribe(data => this.customerList = data, error => this.customerList = []);
    this.contractService.getEmployees()
      .subscribe(data => this.employeeList = data, error => this.employeeList = []);
  }

  onSubmit() {
    console.log(this.formCreate.value);
    this.contractService.createNew(this.formCreate.value).subscribe(data => {
      console.log(data);
      this.router.navigate(['/contract-list'], {queryParams: {create_msg: 'Create successfully!', si: true}});
      // this.router.navigateByUrl('contract-list');
    })
  }
}
