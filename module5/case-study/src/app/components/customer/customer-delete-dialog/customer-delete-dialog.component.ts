import {Component, Inject, OnInit} from '@angular/core';
import {MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import {CustomerService} from '../../../services/customer.service';
import {Router} from "@angular/router";

@Component({
  selector: 'app-customer-delete-dialog',
  templateUrl: './customer-delete-dialog.component.html',
  styleUrls: ['./customer-delete-dialog.component.css']
})
export class CustomerDeleteDialogComponent implements OnInit {
  public eleName;
  public eleId;

  constructor(
    public dialogRef: MatDialogRef<CustomerDeleteDialogComponent>,
    @Inject(MAT_DIALOG_DATA)
    public data: any,
    public customerService: CustomerService,
    private router: Router
  ) {}

  ngOnInit(): void {
    console.log(this.data.data1.name);
    this.eleName = this.data.data1.name;
    this.eleId = this.data.data1.id;
  }

  deleteOnClick() {
    this.customerService.deleteById(this.eleId).subscribe(data => {
      this.router.navigate(['/customer-list'], {queryParams: {delete_msg: 'Delete successfully!', si: true}});
      this.dialogRef.close();
    });
  }
}
