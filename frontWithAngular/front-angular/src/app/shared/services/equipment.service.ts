import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Department, Equipment, Worker} from "./interfaces";

@Injectable({
  providedIn: 'root'
})
export class EquipmentService {
  hostUrl = 'http://localhost:8080/api';

  constructor(
    private http: HttpClient
  ) {
    this.hostUrl += '/equipment';
  }

  public getAll(): Observable<Equipment[]> {
    return this.http.get<Equipment[]>(this.hostUrl + '/get/list');
  }
  public getAllSortedByName(): Observable<Worker[]> {
    return this.http.get<Worker[]>(this.hostUrl + '/get/list/sorted_by_name');
  }
  public delete(equipment: Equipment): Observable<Equipment[]> {
    return this.http.delete<Equipment[]>(this.hostUrl + `/delete/${equipment.id}`);
  }
  public getById(equipmentId: string): Observable<Equipment> {
    return this.http.get<Equipment>(this.hostUrl + `/get/${equipmentId}`);
  }
  public edit(newEquip: Equipment): Observable<Equipment> {
    return this.http.post<Equipment>(this.hostUrl + `/edit`, newEquip);
  }
  public save(equip: Equipment): Observable<Equipment> {
    return this.http.post<Equipment>(this.hostUrl + `/add`, equip);
  }
}
