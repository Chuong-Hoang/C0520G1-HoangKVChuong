import {Component, Input, OnInit} from '@angular/core';
import { CustomerService } from '../../../services/customer.service';
import { MatDialog } from '@angular/material/dialog';
import { CustomerDeleteDialogComponent } from '../customer-delete-dialog/customer-delete-dialog.component';
import {CustomerViewDialogComponent} from "../customer-view-dialog/customer-view-dialog.component";
import {ActivatedRoute, Router} from "@angular/router";
@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  public eList;
  public p: number;
  public term: any;
  public delete_msg: string = '';
  public create_msg: string = '';
  public edit_msg: string = '';


  constructor(
    public customerService: CustomerService,
    public dialog: MatDialog,
    private route: ActivatedRoute
    ) {}

  ngOnInit(): void {
    this.customerService.getAll().subscribe(data => {
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

  openDeleteDialog(id:number): void {
    this.customerService.getById(id).subscribe(dataFromServer =>{
      const dialogRef = this.dialog.open(CustomerDeleteDialogComponent, {
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

  openViewDialog(id:number):void {
    this.customerService.getById(id).subscribe(dataFromServer =>{
      const dialogRef = this.dialog.open(CustomerViewDialogComponent, {
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
