import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-contract-view-dialog',
  templateUrl: './contract-view-dialog.component.html',
  styleUrls: ['./contract-view-dialog.component.css']
})
export class ContractViewDialogComponent implements OnInit {
  public ele;

  constructor(
    public dialogRef: MatDialogRef<ContractViewDialogComponent>,
    @Inject(MAT_DIALOG_DATA)
    public data: any
  ) { }

  ngOnInit(): void {
    console.log(this.data.data1);
    this.ele = this.data.data1;
  }

}