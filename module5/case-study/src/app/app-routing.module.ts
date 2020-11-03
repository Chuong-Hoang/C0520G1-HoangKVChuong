import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { EmployeeListComponent } from './components/employee/employee-list/employee-list.component';
import { CustomerListComponent } from "./components/customer/customer-list/customer-list.component";
import { CustomerCreateComponent } from "./components/customer/customer-create/customer-create.component";
import { CustomerDeleteDialogComponent } from './components/customer/customer-delete-dialog/customer-delete-dialog.component';
import { CustomerEditComponent } from './components/customer/customer-edit/customer-edit.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { NgxPaginationModule } from 'ngx-pagination';
import { MaterialModule } from './material.module';
import { CustomerViewDialogComponent } from './components/customer/customer-view-dialog/customer-view-dialog.component';
import {EmployeeCreateComponent} from "./components/employee/employee-create/employee-create.component";
import { EmployeeDeleteDialogComponent } from './components/employee/employee-delete-dialog/employee-delete-dialog.component';
import { EmployeeViewDialogComponent } from './components/employee/employee-view-dialog/employee-view-dialog.component';
import { EmployeeEditComponent } from './components/employee/employee-edit/employee-edit.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'employee-list', component: EmployeeListComponent},
  {path: 'employee-create', component: EmployeeCreateComponent},
  {path: 'employee-edit/:id', component: EmployeeEditComponent},
  {path: 'customer-list', component: CustomerListComponent},
  {path: 'customer-create', component: CustomerCreateComponent},
  {path: 'customer-edit/:id', component: CustomerEditComponent},
  {path: 'service-list', component: CustomerListComponent},
  {path: 'contract-list', component: CustomerListComponent},
  {path: 'contract-detail-list', component: CustomerListComponent},


  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
    CommonModule,
    Ng2SearchPipeModule,
    NgxPaginationModule,
    FormsModule,
    ReactiveFormsModule,
    MaterialModule
  ],
  exports: [RouterModule],
  declarations: [
    HomeComponent,
    PageNotFoundComponent,
    EmployeeListComponent,
    EmployeeCreateComponent,
    CustomerListComponent,
    CustomerCreateComponent,
    CustomerDeleteDialogComponent,
    CustomerEditComponent,
    CustomerViewDialogComponent,
    EmployeeDeleteDialogComponent,
    EmployeeViewDialogComponent,
    EmployeeEditComponent
  ]
})
export class AppRoutingModule { }
