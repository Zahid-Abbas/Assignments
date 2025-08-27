import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../types';

@Injectable({
  providedIn: 'root'
})
export class Customerservice {
  
   private apiUrl:string = "http://localhost:2222/api/customers";

   constructor(private http:HttpClient){}

   
  addCustomer(customer:any) : Observable<any> {
    return this.http.post(`${this.apiUrl}`, customer);
  }

  getCustomers(): Observable<Customer[]> {
  return this.http.get<Customer[]>(this.apiUrl);
  }
  deleteCustomer(id:number|undefined):Observable<any>{
    return this.http.delete(`${this.apiUrl}/${id}`);
  }
  getCustomerById(id:number):Observable<any>{
    return this.http.get(`${this.apiUrl}/${id}`);
  }
  updateCustomer(id:number,customer:Customer):Observable<any>{
    return this.http.put(`${this.apiUrl}/${id}`,customer);
  }

}