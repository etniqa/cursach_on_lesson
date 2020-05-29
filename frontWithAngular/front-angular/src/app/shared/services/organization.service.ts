import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Agreement, Department, Organization, Worker} from "./interfaces";

@Injectable({
  providedIn: 'root'
})
export class OrganizationService {
  hostUrl = 'http://localhost:8080/api';

  constructor(
    private http: HttpClient
  ) {
    this.hostUrl += '/organization';
  }

  public getAll(): Observable<Organization[]> {
    return this.http.get<Organization[]>(this.hostUrl + '/get/list');
  }
  public getAllSortedByName(): Observable<Worker[]> {
    return this.http.get<Worker[]>(this.hostUrl + '/get/list/sorted_by_name');
  }
  public delete(org: Organization): Observable<Organization[]> {
    return this.http.delete<Organization[]>(this.hostUrl + `/delete/${org.id}`);
  }

  public getById(organizationId: string): Observable<Organization> {
    return this.http.get<Organization>(this.hostUrl + `/get/${organizationId}`);
  }

  public edit(org: Organization): Observable<Organization> {
    return this.http.post<Organization>(this.hostUrl + `/edit`, org);
  }
  public save(agreement: Organization): Observable<Organization> {
    return this.http.post<Organization>(this.hostUrl + `/add`, agreement);
  }

  public getSuborgs(): Observable<Organization[]> {
    return this.http.get<Organization[]>(this.hostUrl + `/get/suborganizations`);
  }
}
