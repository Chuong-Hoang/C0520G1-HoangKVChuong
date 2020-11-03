import { Component, OnInit } from '@angular/core';
import { EmployeeService } from "../../../services/employee.service";
import { Observable } from "rxjs";
import { ActivatedRoute, Router } from "@angular/router";
import {EmployeeDeleteDialogComponent} from "../employee-delete-dialog/employee-delete-dialog.component";
import {MatDialog} from "@angular/material/dialog";
import {EmployeeViewDialogComponent} from "../employee-view-dialog/employee-view-dialog.component";

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  public eList;
  public p: number;
  public term: any;
  public delete_msg: string = '';
  public create_msg: string = '';
  public edit_msg: string = '';

  constructor(
    private employeeService: EmployeeService,
    public dialog: MatDialog,
    private route:ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.employeeService.getAll().subscribe(data =>{
      this.eList = data;
      this.sendMessage();
    });
  }
  sendMessage(){
    console.log(this.route.snapshot.queryParamMap.get('create_msg'));
    this.create_msg = this.route.snapshot.queryParamMap.get('create_msg');
    this.delete_msg = this.route.snapshot.queryParamMap.get('delete_msg');
    this.edit_msg = this.route.snapshot.queryParamMap.get('edit_msg');
  }

  openDeleteDialog(id: number) {
    this.employeeService.getById(id).subscribe(dataFromServer =>{
      const dialogRef = this.dialog.open(EmployeeDeleteDialogComponent, {
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
    this.employeeService.getById(id).subscribe(dataFromServer =>{
      const dialogRef = this.dialog.open(EmployeeViewDialogComponent, {
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
