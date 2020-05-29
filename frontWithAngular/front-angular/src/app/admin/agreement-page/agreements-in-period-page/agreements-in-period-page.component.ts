import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {log} from "util";
import {Agreement} from "../../../shared/services/interfaces";
import {AgreementService} from "../../../shared/services/agreement.service";

@Component({
  selector: 'app-agreements-in-period-page',
  templateUrl: './agreements-in-period-page.component.html',
  styleUrls: ['./agreements-in-period-page.component.scss']
})
export class AgreementsInPeriodPageComponent implements OnInit {
  form: FormGroup;
  isLoaded = false;
  error = '';
  agreements: Agreement[];
  constructor(private agreementService: AgreementService) { }

  ngOnInit(): void {
    this.isLoaded = false;
    this.form = new FormGroup({
      dateFrom: new FormControl(null, [Validators.required]),
      dateTo: new FormControl(null, [Validators.required])
    });
  }

  check(): boolean {
    console.log(this.form.get('dateFrom').value);
    return (new Date(this.form.get('dateFrom').value)).getTime() <= (new Date(this.form.get('dateTo').value).getTime());
  }

  delete(agreem: Agreement) {
    this.isLoaded = false;
    this.agreementService.delete(agreem).subscribe(respAgreements => {
      this.agreements = respAgreements;
      this.isLoaded = true;
    });
  }

  submit() {
    if (this.check()) {
      this.isLoaded = false;
      this.error = '';
      this.agreementService.getInPeriod(this.form.get('dateFrom').value, this.form.get('dateTo').value).subscribe(respAgreems => {
        this.agreements = respAgreems;
        this.isLoaded = true;
      });
    } else {
      this.error = 'Date from have to be less or equal than date to';
      setTimeout(() => this.error = '', 5000);
    }
  }
}
