import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {CustomerService} from "../../../services/customer.service";
import {Router} from "@angular/router";
import {ContractService} from "../../../services/contract.service";

@Component({
  selector: 'app-contract-delete-dialog',
  templateUrl: './contract-delete-dialog.component.html',
  styleUrls: ['./contract-delete-dialog.component.css']
})
export class ContractDeleteDialogComponent implements OnInit {
  eleName: any;
  eleId: any;

  constructor(
    public dialogRef: MatDialogRef<ContractDeleteDialogComponent>,
    @Inject(MAT_DIALOG_DATA)
    public data: any,
    public contractService: ContractService,
    private router: Router
  ) { }

  ngOnInit(): void {
    console.log(this.data.data1.name);
    this.eleName = this.data.data1.name; // not available here
    this.eleId = this.data.data1.id;
  }

  deleteOnClick() {
    this.contractService.deleteById(this.eleId).subscribe(data => {
      this.router.navigate(['/contract-list'], {queryParams: {delete_msg: 'Delete successfully!'}});
      this.dialogRef.close();
    });
  }
}
