import { Component } from '@angular/core';
import {Customer} from "./model/customer";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  private _customer:Customer;
  private _eList:Customer[];

  createNew(ele:Customer) {
    this._customer = ele;
  }
}
