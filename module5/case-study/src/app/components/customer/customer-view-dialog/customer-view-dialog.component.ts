import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {CustomerService} from "../../../services/customer.service";

@Component({
  selector: 'app-customer-view-dialog',
  templateUrl: './customer-view-dialog.component.html',
  styleUrls: ['./customer-view-dialog.component.css']
})
export class CustomerViewDialogComponent implements OnInit {
  public ele;
  constructor(
    public dialogRef: MatDialogRef<CustomerViewDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) { }

  ngOnInit(): void {
    console.log(this.data.data1);
    this.ele = this.data.data1;
  }

}
