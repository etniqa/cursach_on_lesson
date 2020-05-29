import { Component, OnInit } from '@angular/core';
import {Department, Agreement} from "../../../shared/services/interfaces";
import {DepartmentService} from "../../../shared/services/department.service";
import {AgreementService} from "../../../shared/services/agreement.service";

@Component({
  selector: 'app-agreement-list-page',
  templateUrl: './agreement-list-page.component.html',
  styleUrls: ['./agreement-list-page.component.scss']
})
export class AgreementListPageComponent implements OnInit {
  isLoaded = false;
  agreements: Agreement[];
  searchStr = '';
  constructor(
    private agreementService: AgreementService,
  ) { }

  ngOnInit(): void {
    this.isLoaded = false;
    this.agreementService.getAll().subscribe(respAgreems => {
      this.agreements = respAgreems;
      this.isLoaded = true;
    });
  }

  delete(agreem: Agreement) {
    this.isLoaded = false;
    this.agreementService.delete(agreem).subscribe(respAgreements => {
      this.agreements = respAgreements;
      this.isLoaded = true;
    });
  }

  checkIsNeedToAddInactiveClass(agr: Agreement) {
    return agr.dateEnd ? Date.parse(agr.dateEnd as unknown as string) < Date.now() : false;
  }

  getAllSortedByName() {
    this.agreementService.getAllSortedByName().subscribe(respSorted => this.agreements = respSorted);
  }

  getAllReverseSortedByName() {
    this.agreementService.getAllSortedByName().subscribe(respSorted => this.agreements = respSorted.reverse());
  }
}
