import { Component, OnInit } from '@angular/core';
import {Department, Equipment} from "../../../shared/services/interfaces";
import {EquipmentService} from "../../../shared/services/equipment.service";

@Component({
  selector: 'app-equipment-list',
  templateUrl: './equipment-list.component.html',
  styleUrls: ['./equipment-list.component.scss']
})
export class EquipmentListComponent implements OnInit {
  isLoaded = false;
  equipments: Equipment[];
  searchStr = '';
  constructor(
    private equipmentService: EquipmentService,
  ) {
    console.log('constructor');
  }

  ngOnInit(): void {
    this.isLoaded = false;
    this.equipmentService.getAll().subscribe(respEquips => {
      this.equipments = respEquips;
      this.isLoaded = true;
    });
  }

  delete(equipment: Equipment) {
    this.isLoaded = false;
    this.equipmentService.delete(equipment).subscribe(respEquips => {
      this.equipments = respEquips;
      this.isLoaded = true;
    });
  }
  getAllSortedByName() {
    this.equipmentService.getAllSortedByName().subscribe(respSorted => this.equipments = respSorted);
  }

  getAllReverseSortedByName() {
    this.equipmentService.getAllSortedByName().subscribe(respSorted => this.equipments = respSorted.reverse());
  }
}
