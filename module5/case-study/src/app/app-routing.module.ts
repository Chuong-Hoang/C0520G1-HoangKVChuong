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
import { ServiceListComponent } from './components/service/service-list/service-list.component';
import { ServiceEditComponent } from './components/service/service-edit/service-edit.component';
import { ServiceViewDialogComponent } from './components/service/service-view-dialog/service-view-dialog.component';
import { ServiceDeleteDialogComponent } from './components/service/service-delete-dialog/service-delete-dialog.component';
import {ServiceCreateComponent} from "./components/service/service-create/service-create.component";
import { ContractListComponent } from './components/contract/contract-list/contract-list.component';
import { ContractEditComponent } from './components/contract/contract-edit/contract-edit.component';
import { ContractDeleteDialogComponent } from './components/contract/contract-delete-dialog/contract-delete-dialog.component';
import { ContractViewDialogComponent } from './components/contract/contract-view-dialog/contract-view-dialog.component';
import { ContractCreateComponent } from './components/contract/contract-create/contract-create.component';
import { ContractDetailListComponent } from './components/contractDetail/contract-detail-list/contract-detail-list.component';
import { ContractDetailCreateComponent } from './components/contractDetail/contract-detail-create/contract-detail-create.component';
import { ContractDetailEditComponent } from './components/contractDetail/contract-detail-edit/contract-detail-edit.component';
import { ContractDetailViewDialogComponent } from './components/contractDetail/contract-detail-view-dialog/contract-detail-view-dialog.component';
import { ContractDetailDeleteDialogComponent } from './components/contractDetail/contract-detail-delete-dialog/contract-detail-delete-dialog.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'employee-list', component: EmployeeListComponent},
  {path: 'employee-create', component: EmployeeCreateComponent},
  {path: 'employee-edit/:id', component: EmployeeEditComponent},
  {path: 'customer-list', component: CustomerListComponent},
  {path: 'customer-create', component: CustomerCreateComponent},
  {path: 'customer-edit/:id', component: CustomerEditComponent},
  {path: 'service-list', component: ServiceListComponent},
  {path: 'service-create', component: ServiceCreateComponent},
  {path: 'service-edit/:id', component: ServiceEditComponent},
  {path: 'contract-list', component: ContractListComponent},
  {path: 'contract-create', component: ContractCreateComponent},
  {path: 'contract-edit/:id', component: ContractEditComponent},
  {path: 'contract-detail-list', component: ContractDetailListComponent},
  {path: 'contract-detail-create', component: ContractDetailCreateComponent},
  {path: 'contract-detail-edit/:id', component: ContractDetailEditComponent},


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
    EmployeeEditComponent,
    ServiceListComponent,
    ServiceEditComponent,
    ServiceViewDialogComponent,
    ServiceDeleteDialogComponent,
    ServiceCreateComponent,
    ServiceEditComponent,
    ContractListComponent,
    ContractEditComponent,
    ContractDeleteDialogComponent,
    ContractViewDialogComponent,
    ContractCreateComponent,
    ContractDetailListComponent,
    ContractDetailCreateComponent,
    ContractDetailEditComponent,
    ContractDetailViewDialogComponent,
    ContractDetailDeleteDialogComponent
  ]
})
export class AppRoutingModule { }
