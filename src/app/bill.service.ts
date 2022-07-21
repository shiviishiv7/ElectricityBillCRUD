import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Bill } from './models/bill';

@Injectable({
  providedIn: 'root'
})
export class BillService {
  BASEURL: string = "http://localhost:8080/bill/"
  constructor(private http: HttpClient) { }

  public getAllBill(): Observable<Bill[]> {
    return this.http.get<Bill[]>(this.BASEURL)
  }

  public getBillById(id: number): Observable<Bill> {
    return this.http.get<Bill>(this.BASEURL + id);
  }

  public addBill(bill: Bill): Observable<Bill> {
    return this.http.post<Bill>(this.BASEURL, bill)
  }

  public update(bill: Bill): Observable<Bill> {
    return this.http.put<Bill>(this.BASEURL, bill)
  }

  public delete(id: number): Observable<string> {
    return this.http.delete(this.BASEURL + id, { responseType: 'text' })
  }







}
