import { Component, OnInit } from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {ActivatedRoute} from "@angular/router";
import {ContractDetailService} from "../../../services/contract-detail.service";
import {ContractDetailDeleteDialogComponent} from "../contract-detail-delete-dialog/contract-detail-delete-dialog.component";
import {ContractDetailViewDialogComponent} from "../contract-detail-view-dialog/contract-detail-view-dialog.component";

@Component({
  selector: 'app-contract-detail-list',
  templateUrl: './contract-detail-list.component.html',
  styleUrls: ['./contract-detail-list.component.css']
})
export class ContractDetailListComponent implements OnInit {
  public eList;
  public p: number;
  public term: any;
  public delete_msg: string = '';
  public create_msg: string = '';
  public edit_msg: string = '';

  constructor(
    public contractDetailService: ContractDetailService,
    public dialog: MatDialog,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.contractDetailService.getAll().subscribe(data => {
      this.eList = data;
      this.sendMessage();
    });
  }
  sendMessage(){
    this.create_msg = this.route.snapshot.queryParamMap.get('create_msg');
    this.delete_msg = this.route.snapshot.queryParamMap.get('delete_msg');
    this.edit_msg = this.route.snapshot.queryParamMap.get('edit_msg');
  }

  openViewDialog(id: any) {
    this.contractDetailService.getById(id).subscribe(dataFromServer =>{
      const dialogRef = this.dialog.open(ContractDetailViewDialogComponent, {
        width: '500px',
        disableClose: true,
        data: {data1: dataFromServer}
      });

      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
        this.ngOnInit();
      });
    });
  }

  openDeleteDialog(id: any) {
    this.contractDetailService.getById(id).subscribe(dataFromServer =>{
      const dialogRef = this.dialog.open(ContractDetailDeleteDialogComponent, {
        width: '500px',
        disableClose: true,
        data: {data1: dataFromServer}
      });

      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
        this.ngOnInit();
      });
    });
  }
}
