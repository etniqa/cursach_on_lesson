import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Technician, Worker} from "./interfaces";

@Injectable({
  providedIn: 'root'
})
export class TechnicianService {
  hostUrl = 'http://localhost:8080/api';

  constructor(
    private http: HttpClient
  ) {
    this.hostUrl += '/worker';
  }

  public getAll(): Observable<Technician[]> {
    return this.http.get<Technician[]>(this.hostUrl + '/get/technician/list');
  }
}
