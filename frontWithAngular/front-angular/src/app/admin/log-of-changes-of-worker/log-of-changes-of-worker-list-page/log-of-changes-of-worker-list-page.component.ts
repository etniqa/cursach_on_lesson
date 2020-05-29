import { Component, OnInit } from '@angular/core';
import {LogOfChangeOfEquipment, LogOfChangeOfWorker} from "../../../shared/services/interfaces";
import {LogOfChangeOfEquipmentService} from "../../../shared/services/log-of-change-of-equipment.service";
import {LogOfChangesOfWorkerService} from "../../../shared/services/log-of-changes-of-worker.service";

@Component({
  selector: 'app-log-of-changes-of-worker-list-page',
  templateUrl: './log-of-changes-of-worker-list-page.component.html',
  styleUrls: ['./log-of-changes-of-worker-list-page.component.scss']
})
export class LogOfChangesOfWorkerListPageComponent implements OnInit {
  isLoaded = false;
  logOfChangesOfWorker: LogOfChangeOfWorker[];
  constructor(
    private logOfChangesOfWorkerService: LogOfChangesOfWorkerService,
  ) { }

  ngOnInit(): void {
    this.isLoaded = false;
    this.logOfChangesOfWorkerService.getAll().subscribe(respLogs => {
      this.logOfChangesOfWorker = respLogs;
      this.isLoaded = true;
    });
  }

  delete(log: LogOfChangeOfEquipment) {
    this.isLoaded = false;
    this.logOfChangesOfWorkerService.delete(log).subscribe(respLogs => {
      this.logOfChangesOfWorker = respLogs;
      this.isLoaded = true;
    });
  }

  getAllSortedByCreationDate() {
    this.logOfChangesOfWorkerService.getAllSortedByCreationDate().subscribe(respSorted => this.logOfChangesOfWorker = respSorted);
  }

  getAllReverseSortedByCreationDate() {
    this.logOfChangesOfWorkerService.getAllSortedByCreationDate().subscribe(respSorted => this.logOfChangesOfWorker = respSorted.reverse());
  }
}
