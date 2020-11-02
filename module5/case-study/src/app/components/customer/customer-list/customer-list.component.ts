import {Component, Input, OnInit} from '@angular/core';
import { CustomerService } from '../../../services/customer.service';
import { MatDialog } from '@angular/material/dialog';
import { CustomerDeleteDialogComponent } from '../customer-delete-dialog/customer-delete-dialog.component';
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


  constructor(
    public customerService: CustomerService,
    public dialog: MatDialog
    ) {}

  ngOnInit(): void {
    this.customerService.getAll().subscribe(data => {
      this.eList = data;
    })
  }

  openDialog(id:number): void {
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
}
