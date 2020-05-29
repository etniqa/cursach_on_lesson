import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {
  Equipment,
  Organization,
  Project,
  Technician,
  TechnicianHasEquipment
} from "../../../shared/services/interfaces";
import {OrganizationService} from "../../../shared/services/organization.service";
import {ActivatedRoute, Router} from "@angular/router";
import {WorkerService} from "../../../shared/services/worker.service";
import {TechnicianService} from "../../../shared/services/technician.service";
import {TechnicianHasEquipmentService} from "../../../shared/services/technician-has-equipment.service";
import {EquipmentService} from "../../../shared/services/equipment.service";

@Component({
  selector: 'app-technician-has-equipment-edit-page',
  templateUrl: './technician-has-equipment-edit-page.component.html',
  styleUrls: ['./technician-has-equipment-edit-page.component.scss']
})
export class TechnicianHasEquipmentEditPageComponent implements OnInit {
  isLoaded = false;
  form: FormGroup;

  id = '';
  pageMode: 'create' | 'edit';
  technHasEquip: TechnicianHasEquipment;
  technHasEquips: TechnicianHasEquipment[];
  technicians: Technician[];
  availableTechnsForThisEquip: Technician[];
  equipments: Equipment[];
  availableEquipsForThisTechn: Equipment[];

  constructor(private equipmentService: EquipmentService,
              private technicianHasEquipmentService: TechnicianHasEquipmentService,
              private technicianService: TechnicianService,
              private route: ActivatedRoute,
              private router: Router) {

  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      // tslint:disable-next-line:no-conditional-assignment
      if ((this.id = params.id) === 'create') {
        this.pageMode = 'create';
      } else {
        this.pageMode = 'edit';
      }
      this.technicianHasEquipmentService.getAll().subscribe(respTechnHasEquips => {
        this.technHasEquips = respTechnHasEquips.filter(elem => {
          if (elem.id === this.id) this.technHasEquip = elem;
          else return true;
        });
        this.technicianService.getAll().subscribe(respTechns => {
          this.technicians = this.availableTechnsForThisEquip = respTechns;
          this.equipmentService.getAll().subscribe(respEquips => {
            this.equipments = this.availableEquipsForThisTechn = respEquips;
            this.form = new FormGroup({
                description: new FormControl(this.pageMode === 'edit' ? this.technHasEquip.description : null, [Validators.required]),
                technician: new FormControl(this.pageMode === 'edit' ? this.technHasEquip.technician.id : null, [Validators.required]),
                equipment: new FormControl(this.pageMode === 'edit' ? this.technHasEquip.equipment.id : null, [Validators.required]),
              }
            );
            this.isLoaded = true;
          });
        });
      });
    });
  }

  submit() {
    let newTechHasEquip: TechnicianHasEquipment = {};
    if (this.pageMode === 'edit') {
      newTechHasEquip = {...this.technHasEquip};
    }
    newTechHasEquip.description = this.form.get('description').value;
    newTechHasEquip.technician = this.form.get('technician').value === 'none' ? null : this.technicians.find(tech => tech.id === this.form.get('technician').value);
    newTechHasEquip.equipment = this.form.get('equipment').value === 'none' ? null : this.equipments.find(equip => equip.id === this.form.get('equipment').value);
    console.log(newTechHasEquip);
    if (this.pageMode === 'create') {
      this.technicianHasEquipmentService.save(newTechHasEquip).subscribe(resp => this.router.navigate(['/admin', 'technician_has_equipment', 'list']));
    } else {
      this.technicianHasEquipmentService.edit(newTechHasEquip).subscribe(resp => this.router.navigate(['/admin', 'technician_has_equipment', 'list']));
    }
  }

  changeTechnician(chosenTechnId: string) {
    console.log(chosenTechnId);
    const technHasEuipWithChosenTechn: TechnicianHasEquipment[] = this.technHasEquips.filter(techHasEquip => {
      return techHasEquip.technician.id === chosenTechnId;
    });
    this.availableEquipsForThisTechn = this.equipments.filter(equip =>
      technHasEuipWithChosenTechn.find(elem => elem.equipment.id === equip.id) === undefined // need to add if there is not in relations
    );
    // console.log(this.availableEquipsForThisTechn);
  }

  changeEquipment(chosenEquipId: string) {
    const technHasEuipWithChosenEquip: TechnicianHasEquipment[] = this.technHasEquips.filter(techHasEquip => techHasEquip.equipment.id === chosenEquipId);
    this.availableTechnsForThisEquip = this.technicians.filter(tech =>
      technHasEuipWithChosenEquip.find(elem => elem.technician.id === tech.id) === undefined // need to add if there is not in relations
    );
  }
}
