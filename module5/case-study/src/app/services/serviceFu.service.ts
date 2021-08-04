import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ServiceFuService {
  public API:string = 'http://localhost:3000/serviceFus';
  public API_ServiceType:string = 'http://localhost:3000/serviceType';
  public API_RentType:string = 'http://localhost:3000/rentType';

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

  getServiceType():Observable<any>{
    return this.http.get(this.API_ServiceType);
  }

  getRentType():Observable<any>{
    return this.http.get(this.API_RentType);
  }
}