import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {LogOfChangeOfEquipment, Organization, TechnicianHasEquipment} from "./interfaces";

@Injectable({
  providedIn: 'root'
})
export class TechnicianHasEquipmentService {
  hostUrl = 'http://localhost:8080/api';

  constructor(
    private http: HttpClient
  ) {
    this.hostUrl += '/technician_has_equipment';
  }

  public getAll(): Observable<TechnicianHasEquipment[]> {
    return this.http.get<TechnicianHasEquipment[]>(this.hostUrl + '/get/list');
  }
  public getAllSortedByCreationDate(): Observable<LogOfChangeOfEquipment[]> {
    return this.http.get<LogOfChangeOfEquipment[]>(this.hostUrl + '/get/list/sorted_by_creation_date');
  }
  public delete(technHasEquip: TechnicianHasEquipment): Observable<TechnicianHasEquipment[]> {
    return this.http.delete<TechnicianHasEquipment[]>(this.hostUrl + `/delete/${technHasEquip.id}`);
  }

  public getById(technHasEquipId: string): Observable<TechnicianHasEquipment> {
    return this.http.get<TechnicianHasEquipment>(this.hostUrl + `/get/${technHasEquipId}`);
  }

  public edit(technHasEquip: TechnicianHasEquipment): Observable<TechnicianHasEquipment> {
    return this.http.post<Organization>(this.hostUrl + `/edit`, technHasEquip);
  }
  public save(technHasEquip: TechnicianHasEquipment): Observable<TechnicianHasEquipment> {
    return this.http.post<TechnicianHasEquipment>(this.hostUrl + `/add`, technHasEquip);
  }
}
