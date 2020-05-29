import { Component, OnInit } from '@angular/core';
import {Organization, TechnicianHasEquipment} from "../../../shared/services/interfaces";
import {OrganizationService} from "../../../shared/services/organization.service";
import {TechnicianHasEquipmentService} from "../../../shared/services/technician-has-equipment.service";

@Component({
  selector: 'app-technician-has-equipment-list-page',
  templateUrl: './technician-has-equipment-list-page.component.html',
  styleUrls: ['./technician-has-equipment-list-page.component.scss']
})
export class TechnicianHasEquipmentListPageComponent implements OnInit {
  isLoaded = false;
  technHasEquips: TechnicianHasEquipment[];
  constructor(
    private technHasEquipService: TechnicianHasEquipmentService,
  ) {
  }

  ngOnInit(): void {
    this.isLoaded = false;
    this.technHasEquipService.getAll().subscribe(respTechnHasEquips => {
      this.technHasEquips = respTechnHasEquips;
      this.isLoaded = true;
    });
  }

  delete(technHasEquip: TechnicianHasEquipment) {
    this.isLoaded = false;
    this.technHasEquipService.delete(technHasEquip).subscribe(technHasEquips => {
      this.technHasEquips = technHasEquips;
      this.isLoaded = true;
    });
  }

  getAllSortedByCreationDate() {
    this.technHasEquipService.getAllSortedByCreationDate().subscribe(respSorted => this.technHasEquips = respSorted);
  }

  getAllReverseSortedByCreationDate() {
    this.technHasEquipService.getAllSortedByCreationDate().subscribe(respSorted => this.technHasEquips = respSorted.reverse());
  }
}
