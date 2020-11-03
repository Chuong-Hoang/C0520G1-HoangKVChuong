import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {CustomerService} from "../../../services/customer.service";
import {EmployeeService} from "../../../services/employee.service";

@Component({
  selector: 'app-employee-view-dialog',
  templateUrl: './employee-view-dialog.component.html',
  styleUrls: ['./employee-view-dialog.component.css']
})
export class EmployeeViewDialogComponent implements OnInit {
  public ele;
  constructor(
    public dialogRef: MatDialogRef<EmployeeViewDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) { }

  ngOnInit(): void {
    console.log(this.data.data1);
    this.ele = this.data.data1;
  }

}
