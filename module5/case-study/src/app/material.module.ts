import { NgModule } from '@angular/core';
import { MatDatepickerModule} from '@angular/material/datepicker';
import { MatNativeDateModule} from '@angular/material/core';
import { MatFormFieldModule} from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatDialogModule } from '@angular/material/dialog'
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CustomerDeleteDialogComponent} from "./components/customer/customer-delete-dialog/customer-delete-dialog.component";
import {CustomerViewDialogComponent} from "./components/customer/customer-view-dialog/customer-view-dialog.component";
import {EmployeeDeleteDialogComponent} from "./components/employee/employee-delete-dialog/employee-delete-dialog.component";
import {EmployeeViewDialogComponent} from "./components/employee/employee-view-dialog/employee-view-dialog.component";

@NgModule({
  imports: [
    BrowserAnimationsModule
  ],
  exports: [
    MatDatepickerModule,
    MatFormFieldModule,
    MatNativeDateModule,
    MatInputModule,
    MatDialogModule,
    BrowserAnimationsModule
  ],
  providers: [ MatDatepickerModule ],
  entryComponents: [
    CustomerDeleteDialogComponent,
    CustomerViewDialogComponent,
    EmployeeDeleteDialogComponent,
    EmployeeViewDialogComponent
  ]
})

export class MaterialModule {}
