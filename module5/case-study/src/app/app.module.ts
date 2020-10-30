import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerCreateComponent } from './customer-create/customer-create.component';
import { NavbarComponent } from './navbar/navbar.component';
import {FormsModule} from "@angular/forms";
import { EmployeeCreateComponent } from './employee-create/employee-create.component';
import { ServiceCreateComponent } from './service-create/service-create.component';
import { ParentComponent } from './parent/parent.component';
import { ChildComponent } from './child/child.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomerCreateComponent,
    NavbarComponent,
    EmployeeCreateComponent,
    ServiceCreateComponent,
    ParentComponent,
    ChildComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
