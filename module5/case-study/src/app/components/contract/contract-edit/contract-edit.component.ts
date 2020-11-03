import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ContractService} from "../../../services/contract.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-contract-edit',
  templateUrl: './contract-edit.component.html',
  styleUrls: ['./contract-edit.component.css']
})
export class ContractEditComponent implements OnInit {
  id_msg = 'id is required';
  startDate_msg = 'startDate is required';
  endDate_msg = 'endDate is required';
  totalMoney_msg = 'totalMoney is required';
  deposit_msg = 'deposit is required';
  customer_msg = 'customer is required';
  employee_msg = 'employee is required';
  minDate = new Date();
  maxDate = new Date(2050,0,1);

  serviceList: any;
  customerList: any;
  employeeList: any;
  formEdit: FormGroup;
  eleId: any;

  constructor(
    private formBuilder: FormBuilder,
    private contractService: ContractService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.formEdit = this.formBuilder.group({
      id: '',
      startDate: ['', Validators.required],
      endDate: ['', Validators.required],
      totalMoney: ['', Validators.required],
      deposit: ['', Validators.required],
      service: ['', Validators.required],
      customer: ['', Validators.required],
      employee: ['', Validators.required]
    });

    // only for Edit
    this.route.params.subscribe(data =>{
      this.eleId = data.id;
      this.contractService.getById(this.eleId).subscribe(dataFromServer =>{
        this.formEdit.patchValue(dataFromServer);
      })
    });

    this.contractService.getServices()
      .subscribe(data => this.serviceList = data, error => this.serviceList = []);
    this.contractService.getCustomers()
      .subscribe(data => this.customerList = data, error => this.customerList = []);
    this.contractService.getEmployees()
      .subscribe(data => this.employeeList = data, error => this.employeeList = []);
  }

  clickToEdit() {
    console.log(this.formEdit.value);
    this.contractService.editElement(this.eleId, this.formEdit.value).subscribe(data => {
      console.log(data);
      this.router.navigate(['/contract-list'], {queryParams: {edit_msg: 'Update successfully!'}});
      // this.router.navigateByUrl('contract-list');
    })
  }
}
