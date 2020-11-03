import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-contract-detail-view-dialog',
  templateUrl: './contract-detail-view-dialog.component.html',
  styleUrls: ['./contract-detail-view-dialog.component.css']
})
export class ContractDetailViewDialogComponent implements OnInit {
  public ele;
  constructor(
    public dialogRef: MatDialogRef<ContractDetailViewDialogComponent>,
    @Inject(MAT_DIALOG_DATA)
    public data: any
  ) { }

  ngOnInit(): void {
    console.log(this.data.data1);
    this.ele = this.data.data1;
  }
}
