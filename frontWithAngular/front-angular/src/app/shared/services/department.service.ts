import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {Department, Worker} from "./interfaces";
import {HttpClient} from "@angular/common/http";

@Injectable({providedIn: 'root'})
export class DepartmentService {
  hostUrl = 'http://localhost:8080/api';

  constructor(
    private http: HttpClient
  ) {
    this.hostUrl += '/department';
  }

  public getAll(): Observable<Department[]> {
    return this.http.get<Department[]>(this.hostUrl + '/get/list');
  }
  public getAllSortedByName(): Observable<Worker[]> {
    return this.http.get<Worker[]>(this.hostUrl + '/get/list/sorted_by_name');
  }
  public delete(department: Department): Observable<Department[]> {
    return this.http.delete<Department[]>(this.hostUrl + `/delete/${department.id}`);
  }
  public getById(departmentId: string): Observable<Department> {
    return this.http.get<Department>(this.hostUrl + `/get/${departmentId}`);
  }
  public edit(editedDep: Department): Observable<Department> {
    return this.http.post<Department>(this.hostUrl + `/edit`, editedDep);
  }
  public save(dep: Department): Observable<Department> {
    return this.http.post<Department>(this.hostUrl + `/add`, dep);
  }

  public getDepAndAmountOfWorkers(): Observable<{ first: Department, second: number }[]> {
    return this.http.get<{ first: Department, second: number }[]>(this.hostUrl + '/get/department_and_amount_of_workers');
  }
}
