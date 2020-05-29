import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {AgreementService} from "../../../shared/services/agreement.service";
import {Agreement, Contract, RespPairListAndInt} from '../../../shared/services/interfaces';

@Component({
  selector: 'app-agreement-calculate-cost',
  templateUrl: './agreement-calculate-cost.component.html',
  styleUrls: ['./agreement-calculate-cost.component.scss']
})

export class AgreementCalculateCostComponent implements OnInit {
  form: FormGroup;
  error = '';
  errorWrongDates = 'date from have to be less than date to';
  listAgrsAndCost: RespPairListAndInt;
  isLoaded = null;

  constructor(private agreementService: AgreementService) {
  }

  ngOnInit(): void {
    this.form = new FormGroup({
      dateFrom: new FormControl(null, [Validators.required]),
      dateTo: new FormControl(null, [Validators.required])
    });
  }

  updateRespPair() {
    this.isLoaded = false;
    this.agreementService.calculateCost(this.form.get('dateFrom').value, this.form.get('dateTo').value).subscribe(respAgres => {
      this.listAgrsAndCost = {list: respAgres.first, totalCost: respAgres.second};
      this.isLoaded = true;
      console.log('list', this.listAgrsAndCost);
    });
  }

  submit() {
    this.updateRespPair();
  }

  clickCalculateOfCompleted() {
    this.form.get('dateFrom').setValue('null');
    this.form.get('dateTo').setValue('null');
  }

  checkIsNeedToAddInactiveClass(contract: Contract) {
    return contract.dateEnd ? Date.parse(contract.dateEnd as unknown as string) < Date.now() : false;
  }

  isDatesAreWrong() {
    if (Date.parse(this.form.get('dateFrom').value) > Date.parse(this.form.get('dateTo').value)) {
      this.error = this.errorWrongDates;
      return true;
    } else {
      this.error = '';
      return false;
    }
  }

  delete(agreem: Agreement) {
    this.agreementService.delete(agreem).subscribe(success => {
      this.updateRespPair();
    });
  }
}
