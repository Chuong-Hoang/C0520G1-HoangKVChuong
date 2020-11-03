import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {ContractDetailService} from "../../../services/contract-detail.service";

@Component({
  selector: 'app-contract-detail-create',
  templateUrl: './contract-detail-create.component.html',
  styleUrls: ['./contract-detail-create.component.css']
})
export class ContractDetailCreateComponent implements OnInit {
  id_msg = 'id is required';
  contract_msg = 'contract is required';
  attachService_msg = 'attachService is required';
  quantity_msg = 'quantity is required';

  formCreate: FormGroup;
  attachServiceList: any;
  contractList: any;


  constructor(
    private formBuilder: FormBuilder,
    private contractDetailService: ContractDetailService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.formCreate = this.formBuilder.group({
      id: '',
      contract: ['', Validators.required],
      attachService: ['', Validators.required],
      quantity: ['', Validators.required]
    });

    this.contractDetailService.getContracts()
      .subscribe(data => this.contractList = data, error => this.contractList = []);
    this.contractDetailService.getAttachServices()
      .subscribe(data => this.attachServiceList = data, error => this.attachServiceList = []);
  }

  onSubmit() {
    console.log(this.formCreate.value);
    this.contractDetailService.createNew(this.formCreate.value).subscribe(data => {
      console.log(data);
      this.router.navigate(['/contract-detail-list'], {queryParams: {create_msg: 'Create successfully!', si: true}});
      // this.router.navigateByUrl('contract-list');
    })
  }
}
