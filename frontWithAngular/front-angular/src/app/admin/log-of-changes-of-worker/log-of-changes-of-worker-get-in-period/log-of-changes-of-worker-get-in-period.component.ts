import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {LogOfChangeOfEquipment, LogOfChangeOfWorker} from "../../../shared/services/interfaces";
import {LogOfChangeOfEquipmentService} from "../../../shared/services/log-of-change-of-equipment.service";
import {LogOfChangesOfWorkerService} from "../../../shared/services/log-of-changes-of-worker.service";

@Component({
  selector: 'app-log-of-changes-of-worker-get-in-period',
  templateUrl: './log-of-changes-of-worker-get-in-period.component.html',
  styleUrls: ['./log-of-changes-of-worker-get-in-period.component.scss']
})
export class LogOfChangesOfWorkerGetInPeriodComponent implements OnInit {
  form: FormGroup;
  logsOfChangeOfWorkerInPeriod: LogOfChangeOfWorker[];

  errorOrderOfDate = 'Date from have to be less than date to';
  errors = '';

  constructor(private logOfChangesOfWorkerService: LogOfChangesOfWorkerService) {
  }

  ngOnInit(): void {
    this.form = new FormGroup({
      dateFrom: new FormControl(null, Validators.required),
      dateTo: new FormControl(null, Validators.required)
    });
  }

  private performRequest() {
    this.logOfChangesOfWorkerService.getInPeriod(this.form.get('dateFrom').value, this.form.get('dateTo').value).subscribe(respLogsOnPeriod => {
      this.logsOfChangeOfWorkerInPeriod = respLogsOnPeriod;
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
    this.logOfChangesOfWorkerService.delete(log).subscribe(respLogs => {
      this.performRequest();
    });
  }
}
