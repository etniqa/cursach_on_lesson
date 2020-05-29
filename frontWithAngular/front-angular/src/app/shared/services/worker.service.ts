import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CanLead, Organization, TechnicianHasEquipment, Worker} from "./interfaces";

@Injectable({
  providedIn: 'root'
})
export class WorkerService {
  hostUrl = 'http://localhost:8080/api';

  constructor(
    private http: HttpClient
  ) {
    this.hostUrl += '/worker';
  }

  public getAll(): Observable<Worker[]> {
    return this.http.get<Worker[]>(this.hostUrl + '/get/list');
  }
  public getAllSortedByName(): Observable<Worker[]> {
    return this.http.get<Worker[]>(this.hostUrl + '/get/list/sorted_by_name');
  }

  public delete(worker: Worker): Observable<Worker[]> {
    return this.http.delete<Worker[]>(this.hostUrl + `/delete/${worker.id}`);
  }

  public getById(workerId: string): Observable<Worker> {
    return this.http.get<Worker>(this.hostUrl + `/get/${workerId}`);
  }

  public edit(worker: Worker): Observable<Worker> {
    return this.http.post<Worker>(this.hostUrl + `/edit`, worker);
  }
  public save(worker: Worker): Observable<Worker> {
    return this.http.post<Worker>(this.hostUrl + `/add`, worker);
  }

  public getMapWithCanleadAndAmount(): Observable<{ first: CanLead; second: number }[]> {
    return this.http.get<{first: CanLead, second: number}[]>(this.hostUrl + '/get/map_with_canlead_and_amount');
  }

  public getCanLeads(): Observable<CanLead[]> {
    return this.http.get<CanLead[]>(this.hostUrl + '/get/canleads');
  }
}
