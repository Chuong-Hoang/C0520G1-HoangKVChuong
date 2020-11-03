import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {EmployeeService} from "../../../services/employee.service";
import {Router} from "@angular/router";
import {ServiceFuService} from "../../../services/serviceFu.service";

@Component({
  selector: 'app-service-delete-dialog',
  templateUrl: './service-delete-dialog.component.html',
  styleUrls: ['./service-delete-dialog.component.css']
})
export class ServiceDeleteDialogComponent implements OnInit {
  public eleName: '';
  public eleId: '';

  constructor(
    public dialogRef: MatDialogRef<ServiceDeleteDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    public serviceFuService: ServiceFuService,
    private router: Router
  ) { }

  ngOnInit(): void {
    console.log(this.data.data1.name);
    this.eleName = this.data.data1.name;
    this.eleId = this.data.data1.id;
  }

  deleteOnClick() {
    this.serviceFuService.deleteById(this.eleId).subscribe(data => {
      this.router.navigate(['/service-list'], {queryParams: {delete_msg: 'Delete successfully!'}});
      this.dialogRef.close();
    });
  }
}
