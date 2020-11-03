import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ContractDetailService {
  public API:string = 'http://localhost:3000/contractDetails';
  public API_Contract:string = 'http://localhost:3000/contracts';
  public API_AttachService:string = 'http://localhost:3000/attachService';

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

  getContracts():Observable<any>{
    return this.http.get(this.API_Contract);
  }

  getAttachServices():Observable<any>{
    return this.http.get(this.API_AttachService);
  }
}
