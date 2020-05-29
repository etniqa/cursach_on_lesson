import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {LogChiefOfAgreement, LogHeadOfDepartment, LogOfChangeOfEquipment} from "./interfaces";

@Injectable({
  providedIn: 'root'
})
export class LogHeadOfDepartmentService {
  hostUrl = 'http://localhost:8080/api';

  constructor(
    private http: HttpClient
  ) {
    this.hostUrl += '/log_head_of_department';
  }

  public getAll(): Observable<LogHeadOfDepartment[]> {
    return this.http.get<LogHeadOfDepartment[]>(this.hostUrl + '/get/list');
  }
  public getAllSortedByCreationDate(): Observable<LogOfChangeOfEquipment[]> {
    return this.http.get<LogOfChangeOfEquipment[]>(this.hostUrl + '/get/list/sorted_by_creation_date');
  }
  public delete(logHeadOfDepartment: LogHeadOfDepartment): Observable<LogHeadOfDepartment[]> {
    return this.http.delete<LogHeadOfDepartment[]>(this.hostUrl + `/delete/${logHeadOfDepartment.id}`);
  }
  public getById(logHeadOfDepartmentId: string): Observable<LogHeadOfDepartment> {
    return this.http.get<LogHeadOfDepartment>(this.hostUrl + `/get/${logHeadOfDepartmentId}`);
  }
  public edit(editLogHeadOfDepartment: LogHeadOfDepartment): Observable<LogHeadOfDepartment> {
    return this.http.post<LogHeadOfDepartment>(this.hostUrl + `/edit`, editLogHeadOfDepartment);
  }
  public save(logHeadOfDepartment: LogHeadOfDepartment): Observable<LogHeadOfDepartment> {
    return this.http.post<LogHeadOfDepartment>(this.hostUrl + `/add`, logHeadOfDepartment);
  }

  getLastForThisDepartment(depId: string): Observable<LogHeadOfDepartment> {
    return this.http.get<LogHeadOfDepartment>(this.hostUrl + `/get/last_log_for_this_department/${depId}`);
  }
}
