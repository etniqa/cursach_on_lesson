import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Department, Equipment, Organization, Project} from "../../../shared/services/interfaces";
import {DepartmentService} from "../../../shared/services/department.service";
import {OrganizationService} from "../../../shared/services/organization.service";
import {ActivatedRoute, Router} from "@angular/router";
import {EquipmentService} from "../../../shared/services/equipment.service";
import {AgreementService} from "../../../shared/services/agreement.service";

@Component({
  selector: 'app-equipment-edit',
  templateUrl: './equipment-edit.component.html',
  styleUrls: ['./equipment-edit.component.scss']
})
export class EquipmentEditComponent implements OnInit {
  isLoaded = false;
  form: FormGroup;
  equipmentEdit: Equipment;
  idEquipmentEdit = '';
  pageMode: 'create' | 'edit';
  departments: Department[];
  projects: Project[];

  constructor(private equipmentService: EquipmentService,
              private departmentService: DepartmentService,
              private agreementService: AgreementService,
              private route: ActivatedRoute,
              private router: Router) {

  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      // tslint:disable-next-line:no-conditional-assignment
      if ((this.idEquipmentEdit = params.id) === 'create') {
        this.pageMode = 'create';
      } else {
        this.pageMode = 'edit';
      }
      this.equipmentService.getById(this.idEquipmentEdit).subscribe(respEquip => {
        this.equipmentEdit = respEquip;
        this.departmentService.getAll().subscribe(respDeps => {
          this.departments = respDeps;
          this.agreementService.getProjects().subscribe(respProjs => {
            this.projects = respProjs;
            this.form = new FormGroup({
                name: new FormControl(this.pageMode === 'edit' ? this.equipmentEdit.name : null, [Validators.required]),
                description: new FormControl(this.pageMode === 'edit' ? this.equipmentEdit.description : null, [Validators.required]),
                department: new FormControl(this.pageMode === 'edit' ? this.equipmentEdit.depWhichResponsible.id : null, [Validators.required]),
                project: new FormControl(this.pageMode === 'edit' ? this.equipmentEdit.projectWhereIsNowEquip.id : null, [Validators.required]),
              }
            );
            this.isLoaded = true;
          });
        });
      });
    });
  }

  edit() {
    let newEquip: Equipment = {};
    if (this.pageMode === 'edit') {
      newEquip = {...this.equipmentEdit};
    }
    newEquip.name = this.form.get('name').value;
    newEquip.description = this.form.get('description').value;
    newEquip.depWhichResponsible = this.departments.find(dep => dep.id === this.form.get('department').value);
    newEquip.projectWhereIsNowEquip = this.projects.find(proj => proj.id === this.form.get('project').value);
    console.log(newEquip);
    if (this.pageMode === 'create') {
      this.equipmentService.save(newEquip).subscribe(resp => this.router.navigate(['/admin', 'equipment', 'list']));
    } else {
      this.equipmentService.edit(newEquip).subscribe(resp => this.router.navigate(['/admin', 'equipment', 'list']));
    }
  }
}
