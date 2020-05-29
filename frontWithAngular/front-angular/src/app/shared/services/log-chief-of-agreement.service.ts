import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {LogChiefOfAgreement, LogOfChangeOfEquipment} from "./interfaces";

@Injectable({
  providedIn: 'root'
})
export class LogChiefOfAgreementService {
  hostUrl = 'http://localhost:8080/api';

  constructor(
    private http: HttpClient
  ) {
    this.hostUrl += '/log_chief_of_type_of_project';
  }

  public getAll(): Observable<LogChiefOfAgreement[]> {
    return this.http.get<LogChiefOfAgreement[]>(this.hostUrl + '/get/list');
  }
  public getAllSortedByCreationDate(): Observable<LogChiefOfAgreement[]> {
    return this.http.get<LogChiefOfAgreement[]>(this.hostUrl + '/get/list/sorted_by_creation_date');
  }
  public delete(logChiefOfAgreement: LogChiefOfAgreement): Observable<LogChiefOfAgreement[]> {
    return this.http.delete<LogChiefOfAgreement[]>(this.hostUrl + `/delete/${logChiefOfAgreement.id}`);
  }
  public getById(logChiefOfAgreementId: string): Observable<LogChiefOfAgreement> {
    return this.http.get<LogChiefOfAgreement>(this.hostUrl + `/get/${logChiefOfAgreementId}`);
  }
  public edit(editLogChiefOfAgreement: LogChiefOfAgreement): Observable<LogChiefOfAgreement> {
    return this.http.post<LogChiefOfAgreement>(this.hostUrl + `/edit`, editLogChiefOfAgreement);
  }
  public save(logChiefOfAgreement: LogChiefOfAgreement): Observable<LogChiefOfAgreement> {
    return this.http.post<LogChiefOfAgreement>(this.hostUrl + `/add`, logChiefOfAgreement);
  }

  getLastLogForAgreem(agreemId: string): Observable<LogChiefOfAgreement> {
    return this.http.get<LogChiefOfAgreement>(this.hostUrl + `/get/last_log_for_agreem/${agreemId}`);
  }
}
