import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {CustomerService} from "../../../services/customer.service";
import {Router} from "@angular/router";
import {ContractDetailService} from "../../../services/contract-detail.service";

@Component({
  selector: 'app-contract-detail-delete-dialog',
  templateUrl: './contract-detail-delete-dialog.component.html',
  styleUrls: ['./contract-detail-delete-dialog.component.css']
})
export class ContractDetailDeleteDialogComponent implements OnInit {
  public eleName;
  public eleId;

  constructor(
    public dialogRef: MatDialogRef<ContractDetailDeleteDialogComponent>,
    @Inject(MAT_DIALOG_DATA)
    public data: any,
    public contractDetailService: ContractDetailService,
    private router: Router
  ) { }

  ngOnInit(): void {
    console.log(this.data.data1.name);
    this.eleName = this.data.data1.name; // not available here (do not have 'name')
    this.eleId = this.data.data1.id;
  }

  deleteOnClick() {
    this.contractDetailService.deleteById(this.eleId).subscribe(data => {
      this.router.navigate(['/contract-detail-list'], {queryParams: {delete_msg: 'Delete successfully!', si: true}});
      this.dialogRef.close();
    });
  }
}
