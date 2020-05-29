import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Department, Equipment, LogOfChangeOfEquipment, Project} from '../../../shared/services/interfaces';
import {EquipmentService} from '../../../shared/services/equipment.service';
import {DepartmentService} from '../../../shared/services/department.service';
import {AgreementService} from '../../../shared/services/agreement.service';
import {ActivatedRoute, Router} from '@angular/router';
import {LogOfChangeOfEquipmentService} from '../../../shared/services/log-of-change-of-equipment.service';

@Component({
  selector: 'app-log-of-change-of-equipment-edit-page',
  templateUrl: './log-of-change-of-equipment-edit-page.component.html',
  styleUrls: ['./log-of-change-of-equipment-edit-page.component.scss']
})
export class LogOfChangeOfEquipmentEditPageComponent implements OnInit {
  isLoaded = false;
  form: FormGroup;
  logEdit: LogOfChangeOfEquipment;
  idLog = '';
  pageMode: 'create' | 'edit';
  equipments: Equipment[];
  departments: Department[];
  projects: Project[];
  lastLogOfEquip: LogOfChangeOfEquipment;
  errorOfNotTheSameAsLastLog = 'New log of equipment must be not the same as the last one.';
  error = '';

  constructor(private logOfChangeOfEquipmentService: LogOfChangeOfEquipmentService,
              private equipmenService: EquipmentService,
              private departmentService: DepartmentService,
              private agreementService: AgreementService,
              private route: ActivatedRoute,
              private router: Router) {

  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      if ((this.idLog = params.id) === 'create') {
        this.pageMode = 'create';
      } else {
        this.pageMode = 'edit';
      }
      this.logOfChangeOfEquipmentService.getById(this.idLog).subscribe(respLog => {
        this.logEdit = respLog;
        this.departmentService.getAll().subscribe(respDeps => {
          this.departments = respDeps;
          this.equipmenService.getAll().subscribe(respEquips => {
            this.equipments = respEquips;
            this.agreementService.getProjects().subscribe(respProjs => {
              this.projects = respProjs;
              this.form = new FormGroup({
                  description: new FormControl(this.pageMode === 'edit' ? this.logEdit.description : null),
                  equipment: new FormControl(this.pageMode === 'edit' ?
                    this.logEdit.equipWhichChangeField.id : null, [Validators.required]),
                  department: new FormControl(this.pageMode === 'edit' ?
                    (this.logEdit.possibleNewDepartment === null ? 'none' : this.logEdit.possibleNewDepartment.id) : null, [Validators.required]),
                  project: new FormControl(this.pageMode === 'edit' ?
                    (this.logEdit.possibleNewProject === null ? 'none' : this.logEdit.possibleNewProject.id) : null, [Validators.required]),
                }
              );
              if (this.pageMode === 'edit') {
                this.changeEquip(this.logEdit.equipWhichChangeField.id);
              }
              this.isLoaded = true;
            });
          });
        });
      });
    });
  }

  edit() {
    let newLogOfChangesOfEquipment: LogOfChangeOfEquipment = {};
    if (this.pageMode === 'edit') {
      newLogOfChangesOfEquipment = {...this.logEdit};
    }
    newLogOfChangesOfEquipment.description = this.form.get('description').value;
    newLogOfChangesOfEquipment.equipWhichChangeField = this.equipments.find(equip => equip.id === this.form.get('equipment').value);
    newLogOfChangesOfEquipment.possibleNewDepartment = this.departments.find(dep => dep.id === this.form.get('department').value);
    newLogOfChangesOfEquipment.possibleNewProject = this.projects.find(proj => proj.id === this.form.get('project').value);
    if (this.pageMode === 'create') {
      this.logOfChangeOfEquipmentService.save(newLogOfChangesOfEquipment).subscribe(resp => this.router.navigate(['/admin', 'log_of_changes_of_equipment', 'list']));
    } else {
      this.logOfChangeOfEquipmentService.edit(newLogOfChangesOfEquipment).subscribe(resp => this.router.navigate(['/admin', 'log_of_changes_of_equipment', 'list']));
    }
  }

  changeEquip(equipId: string) {
    this.logOfChangeOfEquipmentService.getLastLogForPredictionByEquipId(equipId).subscribe(respLastLog => {
      this.lastLogOfEquip = respLastLog;
      console.log(respLastLog);
      this.form.get('department').setValue(respLastLog.possibleNewDepartment?.id === undefined ? 'none' : respLastLog.possibleNewDepartment?.id);
      this.form.get('project').setValue(respLastLog.possibleNewProject?.id === undefined ? 'none' : respLastLog.possibleNewProject?.id);
    });
    return false;
  }

  isThisIsLastLogOnForm() {
    if ((this.lastLogOfEquip.possibleNewDepartment?.id === undefined ? 'none' : this.lastLogOfEquip.possibleNewDepartment?.id) === this.form.get('department').value &&
      (this.lastLogOfEquip.possibleNewProject?.id === undefined ? 'none' : this.lastLogOfEquip.possibleNewProject?.id) === this.form.get('project').value) {
      this.error = this.errorOfNotTheSameAsLastLog;
      return true;
    } else {
      this.error = '';
      return false;
    }
  }
}
