import { Component, OnInit } from '@angular/core';
import {CanLead} from "../../../shared/services/interfaces";
import {WorkerService} from "../../../shared/services/worker.service";

@Component({
  selector: 'app-amount-of-departments-where-canlead-is-the-same',
  templateUrl: './amount-of-departments-where-canlead-is-the-same.component.html',
  styleUrls: ['./amount-of-departments-where-canlead-is-the-same.component.scss']
})
export class AmountOfDepartmentsWhereCanleadIsTheSameComponent implements OnInit {
  isLoaded = false;
  pairsCanleadAndAmount: { first: CanLead; second: number }[];
  constructor(private workerService: WorkerService) { }

  ngOnInit(): void {
    this.workerService.getMapWithCanleadAndAmount().subscribe(respMap => {
      this.pairsCanleadAndAmount = respMap;
      console.log(respMap);
      console.log(this.pairsCanleadAndAmount);
      this.isLoaded = true;
    });
  }

}
