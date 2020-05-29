import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Contract, Project, Agreement, RespPairListAndInt, LogChiefOfAgreement, Worker} from './interfaces';

@Injectable({
  providedIn: 'root'
})
export class AgreementService {
  hostUrl = 'http://localhost:8080/api';

  constructor(
    private http: HttpClient
  ) {
    this.hostUrl += '/type_of_agreement';
  }

  public getAll(): Observable<Agreement[]> {
    return this.http.get<Agreement[]>(this.hostUrl + '/get/list');
  }
  public getAllSortedByName(): Observable<Worker[]> {
    return this.http.get<Worker[]>(this.hostUrl + '/get/list/sorted_by_name');
  }
  public delete(agreement: Agreement): Observable<Agreement[]> {
    return this.http.delete<Agreement[]>(this.hostUrl + `/delete/${agreement.id}`);
  }
  public getById(agreementId: string): Observable<Agreement> {
    return this.http.get<Agreement>(this.hostUrl + `/get/${agreementId}`);
  }
  public edit(agreement: Agreement): Observable<Agreement> {
    return this.http.post<Agreement>(this.hostUrl + `/edit`, agreement);
  }
  public save(agreement: Agreement, type: 'project' | 'contract' | 'type'): Observable<Agreement> {
    if (type === 'type') return this.http.post<Agreement>(this.hostUrl + `/add`, agreement);
    else return this.http.post<Agreement>(this.hostUrl + `/add/${type}`, agreement);
  }
  public getProjects(): Observable<Project[]> {
    return this.http.get<Project[]>(this.hostUrl + `/get/projects`);
  }
  public getContracts(): Observable<Contract[]> {
    return this.http.get<Contract[]>(this.hostUrl + `/get/contracts`);
  }

  public getInPeriod(from: string, to: string): Observable<Agreement[]> {
    return this.http.get<Agreement[]>(this.hostUrl + `/get/in_period/${from}/${to}`);
  }

  public getContractsForThisOrg(orgId: string): Observable<Contract[]> {
    return this.http.get<Contract[]>(this.hostUrl + `/get/contracts_for_org/${orgId}`);
  }

  public getProjectsForThisContract(contractId: string): Observable<Project[]> {
    return this.http.get<Contract[]>(this.hostUrl + `/get/projects_for_contract/${contractId}`);
  }

  public deleteAndGetProjectsForContract(projId: string, contractId: string): Observable<Project[]> {
    console.log(contractId);
    return this.http.delete<Project[]>(this.hostUrl + `/delete_ligature_contract_with_project_and_get_projects_for_contract/${contractId}/${projId}`);
  }

  calculateCost(dateFrom: string, dateTo: string): Observable<any> {
    return  this.http.get(this.hostUrl + `/get/calculate_cost/${dateFrom}/${dateTo}`);
  }

  getAgreemsForSuborg(suborgId: string): Observable<any> {
    return  this.http.get<any>(this.hostUrl + `/get/from_suborganizations_of/${suborgId}`);
  }
}
