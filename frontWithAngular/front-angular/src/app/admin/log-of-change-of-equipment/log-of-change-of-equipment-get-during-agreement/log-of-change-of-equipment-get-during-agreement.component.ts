import {Component, OnInit} from '@angular/core';
import {Agreement, LogOfChangeOfEquipment} from "../../../shared/services/interfaces";
import {AgreementService} from "../../../shared/services/agreement.service";
import {LogOfChangeOfEquipmentService} from "../../../shared/services/log-of-change-of-equipment.service";

@Component({
  selector: 'app-log-of-change-of-equipment-get-during-agreement',
  templateUrl: './log-of-change-of-equipment-get-during-agreement.component.html',
  styleUrls: ['./log-of-change-of-equipment-get-during-agreement.component.scss']
})
export class LogOfChangeOfEquipmentGetDuringAgreementComponent implements OnInit {
  isLoaded = false;
  isGetResp = false;
  agreements: Agreement[];
  respLogsDuringAgreem: LogOfChangeOfEquipment[];
  chosenAgr: Agreement;

  constructor(
    private agreementService: AgreementService,
    private logOfChangeOfEquipmentService: LogOfChangeOfEquipmentService
  ) {
  }

  ngOnInit(): void {
    this.isLoaded = false;
    this.agreementService.getAll().subscribe(respAgreems => {
      this.agreements = respAgreems;
      this.isLoaded = true;
    });
  }

  private performRequest() {
    this.logOfChangeOfEquipmentService.getInPeriod(this.chosenAgr.dateBeg.toString(), this.chosenAgr.dateEnd.toString()).subscribe(respLogs => {
      this.respLogsDuringAgreem = respLogs;
      this.isGetResp = true;
      this.isLoaded = false;
    });
  }

  checkIsNeedToAddInactiveClass(agr: Agreement) {
    return agr.dateEnd ? Date.parse(agr.dateEnd as unknown as string) < Date.now() : false;
  }

  choose(agreement: Agreement) {
    this.chosenAgr = agreement;
    this.performRequest();
  }

  delete(log: LogOfChangeOfEquipment) {
    this.logOfChangeOfEquipmentService.delete(log).subscribe(respLogs => {
      this.performRequest();
    });
  }
}
