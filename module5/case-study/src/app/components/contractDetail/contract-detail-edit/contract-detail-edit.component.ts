import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ContractDetailService} from "../../../services/contract-detail.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-contract-detail-edit',
  templateUrl: './contract-detail-edit.component.html',
  styleUrls: ['./contract-detail-edit.component.css']
})
export class ContractDetailEditComponent implements OnInit {
  id_msg = 'id is required';
  contract_msg = 'contract is required';
  attachService_msg = 'attachService is required';
  quantity_msg = 'quantity is required';

  attachServiceList: any;
  contractList: any;
  formEdit: FormGroup;
  eleId: any;

  constructor(
    private formBuilder: FormBuilder,
    private contractDetailService: ContractDetailService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.formEdit = this.formBuilder.group({
      id: '',
      contract: ['', Validators.required],
      attachService: ['', Validators.required],
      quantity: ['', Validators.required]
    });

    // only for Edit
    this.route.params.subscribe(data =>{
      this.eleId = data.id;
      this.contractDetailService.getById(this.eleId).subscribe(dataFromServer =>{
        this.formEdit.patchValue(dataFromServer);
      })
    });

    this.contractDetailService.getContracts()
      .subscribe(data => this.contractList = data, error => this.contractList = []);
    this.contractDetailService.getAttachServices()
      .subscribe(data => this.attachServiceList = data, error => this.attachServiceList = []);
  }

  clickToEdit() {
    console.log(this.formEdit.value);
    this.contractDetailService.editElement(this.eleId, this.formEdit.value).subscribe(data => {
      console.log(data);
      this.router.navigate(['/contract-detail-list'], {queryParams: {edit_msg: 'Update successfully!'}});
      // this.router.navigateByUrl('contract-list');
    })
  }
}
