import { Component, OnInit } from '@angular/core';
import {Equipment, Organization} from "../../../shared/services/interfaces";
import {EquipmentService} from "../../../shared/services/equipment.service";
import {OrganizationService} from "../../../shared/services/organization.service";

@Component({
  selector: 'app-organiation-list-page',
  templateUrl: './organization-list-page.component.html',
  styleUrls: ['./organization-list-page.component.scss']
})
export class OrganizationListPageComponent implements OnInit {
  isLoaded = false;
  organizations: Organization[];
  searchStr = '';
  constructor(
    private organizationService: OrganizationService,
  ) {
  }

  ngOnInit(): void {
    this.isLoaded = false;
    this.organizationService.getAll().subscribe(respOrgs => {
      this.organizations = respOrgs;
      this.isLoaded = true;
    });
  }

  delete(org: Organization) {
    this.isLoaded = false;
    this.organizationService.delete(org).subscribe(respOrgs => {
      this.organizations = respOrgs;
      this.isLoaded = true;
    });
  }

  getAllSortedByName() {
    this.organizationService.getAllSortedByName().subscribe(respSorted => this.organizations = respSorted);
  }

  getAllReverseSortedByName() {
    this.organizationService.getAllSortedByName().subscribe(respSorted => this.organizations = respSorted.reverse());
  }
}
