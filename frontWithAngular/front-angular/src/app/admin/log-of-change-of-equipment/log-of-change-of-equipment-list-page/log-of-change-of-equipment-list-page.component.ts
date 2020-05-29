import { Component, OnInit } from '@angular/core';
import {LogOfChangeOfEquipment} from "../../../shared/services/interfaces";
import {DepartmentService} from "../../../shared/services/department.service";
import {LogOfChangeOfEquipmentService} from "../../../shared/services/log-of-change-of-equipment.service";

@Component({
  selector: 'app-log-of-change-of-equipment-list-page',
  templateUrl: './log-of-change-of-equipment-list-page.component.html',
  styleUrls: ['./log-of-change-of-equipment-list-page.component.scss']
})
export class LogOfChangeOfEquipmentListPageComponent implements OnInit {
  isLoaded = false;
  logOfChangeOfEquipments: LogOfChangeOfEquipment[];
  constructor(
    private logOfChangeOfEquipmentService: LogOfChangeOfEquipmentService,
  ) { }

  ngOnInit(): void {
    this.isLoaded = false;
    this.logOfChangeOfEquipmentService.getAll().subscribe(respLogs => {
      this.logOfChangeOfEquipments = respLogs;
      this.isLoaded = true;
    });
  }

  delete(log: LogOfChangeOfEquipment) {
    this.isLoaded = false;
    this.logOfChangeOfEquipmentService.delete(log).subscribe(respLogs => {
      this.logOfChangeOfEquipments = respLogs;
      this.isLoaded = true;
    });
  }

  getAllSortedByCreationDate() {
    this.logOfChangeOfEquipmentService.getAllSortedByCreationDate().subscribe(respSorted => this.logOfChangeOfEquipments = respSorted);
  }

  getAllReverseSortedByCreationDate() {
    this.logOfChangeOfEquipmentService.getAllSortedByCreationDate().subscribe(respSorted => this.logOfChangeOfEquipments = respSorted.reverse());
  }
}
