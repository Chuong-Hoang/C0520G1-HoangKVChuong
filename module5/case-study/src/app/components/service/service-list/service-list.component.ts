import { Component, OnInit } from '@angular/core';
import {ServiceFuService} from "../../../services/serviceFu.service";
import {ActivatedRoute} from "@angular/router";
import {MatDialog} from "@angular/material/dialog";
import {ServiceDeleteDialogComponent} from "../service-delete-dialog/service-delete-dialog.component";
import {ServiceViewDialogComponent} from "../service-view-dialog/service-view-dialog.component";

@Component({
  selector: 'app-service-list',
  templateUrl: './service-list.component.html',
  styleUrls: ['./service-list.component.css']
})
export class ServiceListComponent implements OnInit {
  public eList;
  public p: any;
  public term: any;
  public delete_msg: string = '';
  public create_msg: string = '';
  public edit_msg: string = '';

  constructor(
    private serviceFuService: ServiceFuService,
    private route:ActivatedRoute,
    private dialog: MatDialog
  ) { }

  ngOnInit(): void {
    this.serviceFuService.getAll().subscribe(data => {
      this.eList = data;
      this.sendMessage();
    });
  }
  sendMessage(){
    this.create_msg = this.route.snapshot.queryParamMap.get('create_msg');
    this.delete_msg = this.route.snapshot.queryParamMap.get('delete_msg');
    this.edit_msg = this.route.snapshot.queryParamMap.get('edit_msg');
  }

  openDeleteDialog(id: number) {
    this.serviceFuService.getById(id).subscribe(dataFromServer =>{
      const dialogRef = this.dialog.open(ServiceDeleteDialogComponent, {
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
    this.serviceFuService.getById(id).subscribe(dataFromServer =>{
      const dialogRef = this.dialog.open(ServiceViewDialogComponent, {
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
