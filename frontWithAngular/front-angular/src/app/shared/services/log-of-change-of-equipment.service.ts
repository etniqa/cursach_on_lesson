import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Department, LogOfChangeOfEquipment, Worker} from "./interfaces";

@Injectable({
  providedIn: 'root'
})
export class LogOfChangeOfEquipmentService {
  hostUrl = 'http://localhost:8080/api';

  constructor(
    private http: HttpClient
  ) {
    this.hostUrl += '/log_of_changes_of_equipment';
  }

  public getAll(): Observable<LogOfChangeOfEquipment[]> {
    return this.http.get<LogOfChangeOfEquipment[]>(this.hostUrl + '/get/list');
  }
  public getAllSortedByCreationDate(): Observable<LogOfChangeOfEquipment[]> {
    return this.http.get<LogOfChangeOfEquipment[]>(this.hostUrl + '/get/list/sorted_by_creation_date');
  }
  public delete(logOfChangeOfEquipment: LogOfChangeOfEquipment): Observable<LogOfChangeOfEquipment[]> {
    return this.http.delete<LogOfChangeOfEquipment[]>(this.hostUrl + `/delete/${logOfChangeOfEquipment.id}`);
  }
  public getById(logOfChangeOfEquipmentId: string): Observable<LogOfChangeOfEquipment> {
    return this.http.get<LogOfChangeOfEquipment>(this.hostUrl + `/get/${logOfChangeOfEquipmentId}`);
  }
  public edit(editLogOfChangeOfEquipment: LogOfChangeOfEquipment): Observable<LogOfChangeOfEquipment> {
    return this.http.post<LogOfChangeOfEquipment>(this.hostUrl + `/edit`, editLogOfChangeOfEquipment);
  }
  public save(logOfChangeOfEquipment: LogOfChangeOfEquipment): Observable<LogOfChangeOfEquipment> {
    return this.http.post<LogOfChangeOfEquipment>(this.hostUrl + `/add`, logOfChangeOfEquipment);
  }

  public getLastLogForPredictionByEquipId(equipId: string): Observable<LogOfChangeOfEquipment> {
    return this.http.get<LogOfChangeOfEquipment>(this.hostUrl + `/get/last_log_for_prediction_by_equip_id/${equipId}`);
  }

  getInPeriod(dateFrom: string, dateTo: string): Observable<LogOfChangeOfEquipment[]> {
    return this.http.get<LogOfChangeOfEquipment[]>(this.hostUrl + `/get/in_period/${dateFrom}/${dateTo}`);
  }
}
