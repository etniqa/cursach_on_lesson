import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {LogOfChangeOfEquipment, LogOfChangeOfWorker} from "./interfaces";

@Injectable({
  providedIn: 'root'
})
export class LogOfChangesOfWorkerService {
  hostUrl = 'http://localhost:8080/api';

  constructor(
    private http: HttpClient
  ) {
    this.hostUrl += '/log_of_changes_of_worker';
  }

  public getAll(): Observable<LogOfChangeOfWorker[]> {
    return this.http.get<LogOfChangeOfWorker[]>(this.hostUrl + '/get/list');
  }
  public getAllSortedByCreationDate(): Observable<LogOfChangeOfEquipment[]> {
    return this.http.get<LogOfChangeOfEquipment[]>(this.hostUrl + '/get/list/sorted_by_creation_date');
  }
  public delete(logOfChangeOfWorker: LogOfChangeOfWorker): Observable<LogOfChangeOfWorker[]> {
    return this.http.delete<LogOfChangeOfWorker[]>(this.hostUrl + `/delete/${logOfChangeOfWorker.id}`);
  }
  public getById(logOfChangeOfWorkerId: string): Observable<LogOfChangeOfWorker> {
    return this.http.get<LogOfChangeOfEquipment>(this.hostUrl + `/get/${logOfChangeOfWorkerId}`);
  }
  public edit(editLogOfChangeOfWorker: LogOfChangeOfWorker): Observable<LogOfChangeOfWorker> {
    return this.http.post<LogOfChangeOfEquipment>(this.hostUrl + `/edit`, editLogOfChangeOfWorker);
  }
  public save(logOfChangeOfWorker: LogOfChangeOfWorker): Observable<LogOfChangeOfWorker> {
    return this.http.post<LogOfChangeOfWorker>(this.hostUrl + `/add`, logOfChangeOfWorker);
  }

  public getLastLogForPredictionByEquipId(workerId: string): Observable<LogOfChangeOfWorker> {
    return this.http.get<LogOfChangeOfWorker>(this.hostUrl + `/get/last_log_for_prediction_by_worker_id/${workerId}`);
  }

  getInPeriod(dateFrom: string, dateTo: string): Observable<LogOfChangeOfWorker[]> {
    return this.http.get<LogOfChangeOfWorker[]>(this.hostUrl + `/get/in_period/${dateFrom}/${dateTo}`);
  }
}
