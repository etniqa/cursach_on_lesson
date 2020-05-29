import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {LogOfChangeOfEquipment} from "../../../shared/services/interfaces";
import {LogOfChangeOfEquipmentService} from "../../../shared/services/log-of-change-of-equipment.service";

@Component({
  selector: 'app-log-of-change-of-equipment-get-in-period-page',
  templateUrl: './log-of-change-of-equipment-get-in-period-page.component.html',
  styleUrls: ['./log-of-change-of-equipment-get-in-period-page.component.scss']
})
export class LogOfChangeOfEquipmentGetInPeriodPageComponent implements OnInit {
  form: FormGroup;
  logsOfChangeOfEquipmentInPeriod: LogOfChangeOfEquipment[];

  errorOrderOfDate = 'Date from have to be less than date to';
  errors = '';

  constructor(private logOfChangeOfEquipmentService: LogOfChangeOfEquipmentService) {
  }

  ngOnInit(): void {
    this.form = new FormGroup({
      dateFrom: new FormControl(null, Validators.required),
      dateTo: new FormControl(null, Validators.required)
    });
  }

  private performRequest() {
    this.logOfChangeOfEquipmentService.getInPeriod(this.form.get('dateFrom').value, this.form.get('dateTo').value).subscribe(respLogsOnPeriod => {
      this.logsOfChangeOfEquipmentInPeriod = respLogsOnPeriod;
    });
  }

  submit() {
    this.performRequest();
  }

  isInOrderDatesInForm() {
    if (Date.parse(this.form.get('dateTo').value) >= Date.parse(this.form.get('dateFrom').value)) {
      this.errors = '';
      return true;
    } else {
      this.errors = this.errorOrderOfDate;
      return false;
    }
  }

  delete(log: LogOfChangeOfEquipment) {
    this.logOfChangeOfEquipmentService.delete(log).subscribe(respLogs => {
      this.performRequest();
    });
  }
}
