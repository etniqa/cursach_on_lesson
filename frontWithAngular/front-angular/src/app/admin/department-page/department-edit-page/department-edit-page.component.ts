import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Department, Organization} from '../../../shared/services/interfaces';
import {DepartmentService} from '../../../shared/services/department.service';
import {ActivatedRoute, Router} from '@angular/router';
import {OrganizationService} from '../../../shared/services/organization.service';

@Component({
  selector: 'app-department-edit-page',
  templateUrl: './department-edit-page.component.html',
  styleUrls: ['./department-edit-page.component.scss']
})
export class DepartmentEditPageComponent implements OnInit {
  isLoaded = false;
  form: FormGroup;
  departmentEdit: Department;
  idDepartmentEdit = '';
  pageMode: 'create' | 'edit';
  organizations: Organization[];

  constructor(private departmentService: DepartmentService,
              private organizationService: OrganizationService,
              private route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit() {

    this.isLoaded = false;
    this.route.params.subscribe(params => {
        if ((this.idDepartmentEdit = params.id) === 'create') {
          this.pageMode = 'create';
        } else {
          this.pageMode = 'edit';
        }
        this.departmentService.getById(this.idDepartmentEdit).subscribe(respDepartment => {
          this.departmentEdit = respDepartment;
          this.organizationService.getAll().subscribe(respOrganizations => {
            this.organizations = respOrganizations;
          });
          this.form = new FormGroup({
              name: new FormControl(this.pageMode === 'edit' ? this.departmentEdit.name : null, [Validators.required]),
              description: new FormControl(this.pageMode === 'edit' ? this.departmentEdit.description : null, [Validators.required]),
              organization: new FormControl(this.pageMode === 'edit' ? this.departmentEdit.organization.id : null, [Validators.required])
            }
          );
          this.isLoaded = true;
        });
      }
    );
  }

  edit() {
    let newDep: Department = {};
    if (this.pageMode === 'edit') {
      newDep = {...this.departmentEdit};
    }
    newDep.name = this.form.get('name').value;
    newDep.description = this.form.get('description').value;
    newDep.organization = this.organizations.find(org => org.id === this.form.get('organization').value);
    console.log(newDep);
    if (this.pageMode === 'create') {
      this.departmentService.save(newDep).subscribe(success => this.router.navigate(['/admin', 'department', 'list']));
    } else {
      this.departmentService.edit(newDep).subscribe(success => this.router.navigate(['/admin', 'department', 'list']));
    }
  }
}
