import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ContractService {
  public API:string = 'http://localhost:3000/contracts';
  public API_Service:string = 'http://localhost:3000/serviceFus';
  public API_Customer:string = 'http://localhost:3000/customers';
  public API_Employee:string = 'http://localhost:3000/employees';

  constructor(public http:HttpClient) { }

  getAll(): Observable<any>{
    return this.http.get(this.API);
  }
  createNew(ele): Observable<any>{
    return this.http.post(this.API, ele);
  }

  getById(id): Observable<any>{
    return this.http.get(this.API + '/' + id);
  }

  deleteById(id): Observable<any>{
    return this.http.delete(this.API + '/' + id);
  }

  editElement(id, ele){
    return this.http.put(this.API + '/' + id, ele);
  }

  getServices():Observable<any>{
    return this.http.get(this.API_Service);
  }

  getCustomers():Observable<any>{
    return this.http.get(this.API_Customer);
  }

  getEmployees():Observable<any>{
    return this.http.get(this.API_Employee);
  }
}
