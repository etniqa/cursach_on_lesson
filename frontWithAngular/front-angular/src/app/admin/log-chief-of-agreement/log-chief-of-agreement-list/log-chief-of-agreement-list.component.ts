import { Component, OnInit } from '@angular/core';
import {LogChiefOfAgreement, LogOfChangeOfEquipment} from "../../../shared/services/interfaces";
import {LogOfChangeOfEquipmentService} from "../../../shared/services/log-of-change-of-equipment.service";
import {LogChiefOfAgreementService} from "../../../shared/services/log-chief-of-agreement.service";

@Component({
  selector: 'app-log-chief-of-agreement-list',
  templateUrl: './log-chief-of-agreement-list.component.html',
  styleUrls: ['./log-chief-of-agreement-list.component.scss']
})
export class LogChiefOfAgreementListComponent implements OnInit {
  isLoaded = false;
  logChiefOfAgreementList: LogChiefOfAgreement[];
  constructor(
    private logChiefOfAgreementService: LogChiefOfAgreementService,
  ) { }

  ngOnInit(): void {
    this.isLoaded = false;
    this.logChiefOfAgreementService.getAll().subscribe(respLogs => {
      console.log(respLogs);
      this.logChiefOfAgreementList = respLogs;
      this.isLoaded = true;
    });
  }

  delete(log: LogOfChangeOfEquipment) {
    this.isLoaded = false;
    this.logChiefOfAgreementService.delete(log).subscribe(respLogs => {
      this.logChiefOfAgreementList = respLogs;
      this.isLoaded = true;
    });
  }

  getAllSortedByCreationDate() {
    this.logChiefOfAgreementService.getAllSortedByCreationDate().subscribe(respSorted => this.logChiefOfAgreementList = respSorted);
  }

  getAllReverseSortedByCreationDate() {
    this.logChiefOfAgreementService.getAllSortedByCreationDate().subscribe(respSorted => this.logChiefOfAgreementList = respSorted.reverse());
  }
}
