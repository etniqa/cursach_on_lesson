import { Component, OnInit } from '@angular/core';
import {Department} from "../../../shared/services/interfaces";
import {DepartmentService} from "../../../shared/services/department.service";

@Component({
  selector: 'app-departments-list-page',
  templateUrl: './departments-list-page.component.html',
  styleUrls: ['./departments-list-page.component.scss']
})
export class DepartmentsListPageComponent implements OnInit {
  isLoaded = false;
  departments: Department[];
  searchStr = '';
  constructor(
    private departmentService: DepartmentService,
  ) { }

  ngOnInit(): void {
    this.isLoaded = false;
    this.departmentService.getAll().subscribe(responseDepartments => {
      this.departments = responseDepartments;
      this.isLoaded = true;
    });
  }

  delete(department: Department) {
    this.isLoaded = false;
    this.departmentService.delete(department).subscribe(responseDepartments => {
      console.log(responseDepartments);
      this.departments = responseDepartments;
      this.isLoaded = true;
    });
  }

  getAllSortedByName() {
    this.departmentService.getAllSortedByName().subscribe(respSorted => this.departments = respSorted);
  }

  getAllReverseSortedByName() {
    this.departmentService.getAllSortedByName().subscribe(respSorted => this.departments = respSorted.reverse());
  }
}
