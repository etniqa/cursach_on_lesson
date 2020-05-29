import { Component, OnInit } from '@angular/core';
import {LogChiefOfAgreement, LogHeadOfDepartment, LogOfChangeOfEquipment} from "../../../shared/services/interfaces";
import {LogChiefOfAgreementService} from "../../../shared/services/log-chief-of-agreement.service";
import {LogHeadOfDepartmentService} from "../../../shared/services/log-head-of-department.service";

@Component({
  selector: 'app-log-head-of-department-list',
  templateUrl: './log-head-of-department-list.component.html',
  styleUrls: ['./log-head-of-department-list.component.scss']
})
export class LogHeadOfDepartmentListComponent implements OnInit {
  isLoaded = false;
  logHeadOfDepartments: LogHeadOfDepartment[];
  constructor(
    private logHeadOfDepartmentService: LogHeadOfDepartmentService,
  ) { }

  ngOnInit(): void {
    this.isLoaded = false;
    this.logHeadOfDepartmentService.getAll().subscribe(respLogs => {
      console.log(respLogs);
      this.logHeadOfDepartments = respLogs;
      this.isLoaded = true;
    });
  }

  delete(log: LogOfChangeOfEquipment) {
    this.isLoaded = false;
    this.logHeadOfDepartmentService.delete(log).subscribe(respLogs => {
      this.logHeadOfDepartments = respLogs;
      this.isLoaded = true;
    });
  }
  getAllSortedByCreationDate() {
    this.logHeadOfDepartmentService.getAllSortedByCreationDate().subscribe(respSorted => this.logHeadOfDepartments = respSorted);
  }

  getAllReverseSortedByCreationDate() {
    this.logHeadOfDepartmentService.getAllSortedByCreationDate().subscribe(respSorted => this.logHeadOfDepartments = respSorted.reverse());
  }
}
