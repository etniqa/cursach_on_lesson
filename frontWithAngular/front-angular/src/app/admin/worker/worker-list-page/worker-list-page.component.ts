import { Component, OnInit } from '@angular/core';
import {Department, Worker} from "../../../shared/services/interfaces";
import {DepartmentService} from "../../../shared/services/department.service";
import {WorkerService} from "../../../shared/services/worker.service";

@Component({
  selector: 'app-worker-list-page',
  templateUrl: './worker-list-page.component.html',
  styleUrls: ['./worker-list-page.component.scss']
})
export class WorkerListPageComponent implements OnInit {
  isLoaded = false;
  workers: Worker[];
  searchStr = '';
  constructor(
    private workerService: WorkerService,
  ) { }

  ngOnInit(): void {
    this.isLoaded = false;
    this.workerService.getAll().subscribe(respWorkers => {
      this.workers = respWorkers;
      console.log('all workers', respWorkers);
      this.isLoaded = true;
    });
  }

  delete(worker: Worker) {
    this.isLoaded = false;
    this.workerService.delete(worker).subscribe(respWorkers => {
      this.workers = respWorkers;
      this.isLoaded = true;
    });
  }

  getAllSortedByName() {
    this.workerService.getAllSortedByName().subscribe(respSorted => this.workers = respSorted);
  }

  getAllReverseSortedByName() {
    this.workerService.getAllSortedByName().subscribe(respSorted => this.workers = respSorted.reverse());
  }
}
