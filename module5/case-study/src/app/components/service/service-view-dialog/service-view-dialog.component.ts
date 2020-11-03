import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-service-view-dialog',
  templateUrl: './service-view-dialog.component.html',
  styleUrls: ['./service-view-dialog.component.css']
})
export class ServiceViewDialogComponent implements OnInit {
  ele: any;

  constructor(
    public dialogRef: MatDialogRef<ServiceViewDialogComponent>,
    @Inject(MAT_DIALOG_DATA)
    public data: any
  ) {}

  ngOnInit(): void {
    console.log(this.data.data1);
    this.ele = this.data.data1;
  }

}
