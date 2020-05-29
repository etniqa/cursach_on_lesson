import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Agreement, AgreementHasAgreement} from "./interfaces";

@Injectable({
  providedIn: 'root'
})
export class AgreementHasAgreementService {
  hostUrl = 'http://localhost:8080/api';

  constructor(
    private http: HttpClient
  ) {
    this.hostUrl += '/agreement_has_agreement';
  }

  public getAll(): Observable<AgreementHasAgreement[]> {
    return this.http.get<AgreementHasAgreement[]>(this.hostUrl + '/get/list');
  }

  public delete(agreementHasAgreement: AgreementHasAgreement): Observable<AgreementHasAgreement[]> {
    return this.http.delete<AgreementHasAgreement[]>(this.hostUrl + `/delete/${agreementHasAgreement.id}`);
  }

  public getById(AgreementHasAgreementId: string): Observable<AgreementHasAgreement> {
    return this.http.get<Agreement>(this.hostUrl + `/get/${AgreementHasAgreementId}`);
  }

  public edit(agreement: Agreement): Observable<Agreement> {
    return this.http.post<Agreement>(this.hostUrl + `/edit`, agreement);
  }

  public save(agreementHasAgreement: AgreementHasAgreement): Observable<AgreementHasAgreement> {
    return this.http.post<AgreementHasAgreement>(this.hostUrl + `/add`, agreementHasAgreement);
  }
}
