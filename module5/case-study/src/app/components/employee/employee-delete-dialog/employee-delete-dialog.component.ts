import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {Router} from "@angular/router";
import {EmployeeService} from "../../../services/employee.service";

@Component({
  selector: 'app-employee-delete-dialog',
  templateUrl: './employee-delete-dialog.component.html',
  styleUrls: ['./employee-delete-dialog.component.css']
})
export class EmployeeDeleteDialogComponent implements OnInit {
  public eleName: '';
  public eleId: '';

  constructor(
    public dialogRef: MatDialogRef<EmployeeDeleteDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    public employeeService: EmployeeService,
    private router: Router
  ) { }

  ngOnInit(): void {
    console.log(this.data.data1.name);
    this.eleName = this.data.data1.name;
    this.eleId = this.data.data1.id;
  }

  deleteOnClick() {
    this.employeeService.deleteById(this.eleId).subscribe(data => {
      this.router.navigate(['/employee-list'], {queryParams: {delete_msg: 'Delete successfully!', si: true}});
      this.dialogRef.close();
    });
  }
}
