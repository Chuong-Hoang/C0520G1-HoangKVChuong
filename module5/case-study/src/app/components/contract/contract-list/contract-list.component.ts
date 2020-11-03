import { Component, OnInit } from '@angular/core';
import {ContractService} from "../../../services/contract.service";
import {ActivatedRoute} from "@angular/router";
import {MatDialog} from "@angular/material/dialog";
import {ContractDeleteDialogComponent} from "../contract-delete-dialog/contract-delete-dialog.component";
import {CustomerViewDialogComponent} from "../../customer/customer-view-dialog/customer-view-dialog.component";
import {ContractViewDialogComponent} from "../contract-view-dialog/contract-view-dialog.component";

@Component({
  selector: 'app-contract-list',
  templateUrl: './contract-list.component.html',
  styleUrls: ['./contract-list.component.css']
})
export class ContractListComponent implements OnInit {
  public eList;
  public p: number;
  public term: any;
  public delete_msg: string = '';
  public create_msg: string = '';
  public edit_msg: string = '';

  constructor(
    private contractService: ContractService,
    private route: ActivatedRoute,
    private dialog: MatDialog
  ) { }

  ngOnInit(): void {
    this.contractService.getAll().subscribe(data => {
      this.eList = data;
      this.sendMessage();
    })
  }
  sendMessage(){
    console.log(this.route.snapshot.queryParamMap.get('create_msg'));
    this.create_msg = this.route.snapshot.queryParamMap.get('create_msg');
    this.delete_msg = this.route.snapshot.queryParamMap.get('delete_msg');
    this.edit_msg = this.route.snapshot.queryParamMap.get('edit_msg');
  }

  openDeleteDialog(id: number) {
    this.contractService.getById(id).subscribe(dataFromServer =>{
      const dialogRef = this.dialog.open(ContractDeleteDialogComponent, {
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

  openViewDialog(id: number) {
    this.contractService.getById(id).subscribe(dataFromServer =>{
      const dialogRef = this.dialog.open(ContractViewDialogComponent, {
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
