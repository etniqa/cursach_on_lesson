import { Component, OnInit } from '@angular/core';
import {Department} from "../../../shared/services/interfaces";
import {DepartmentService} from "../../../shared/services/department.service";

@Component({
  selector: 'app-department-and-amount-of-workers-page',
  templateUrl: './department-and-amount-of-workers-page.component.html',
  styleUrls: ['./department-and-amount-of-workers-page.component.scss']
})
export class DepartmentAndAmountOfWorkersPageComponent implements OnInit {
  isLoaded = false;
  depAndAmountList: {first: Department, second: number}[];
  constructor(private departmentService: DepartmentService) { }

  ngOnInit(): void {
    this.isLoaded = false;
    this.departmentService.getDepAndAmountOfWorkers().subscribe(respDepAndAmount => {
      this.depAndAmountList = respDepAndAmount;
      console.log(this.depAndAmountList);
      console.log(respDepAndAmount.length);
      this.isLoaded = true;
    });
  }

}
