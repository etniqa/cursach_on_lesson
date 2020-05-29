import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Department, Equipment, Organization, Project} from "../../../shared/services/interfaces";
import {EquipmentService} from "../../../shared/services/equipment.service";
import {DepartmentService} from "../../../shared/services/department.service";
import {AgreementService} from "../../../shared/services/agreement.service";
import {ActivatedRoute, Router} from "@angular/router";
import {OrganizationService} from "../../../shared/services/organization.service";

@Component({
  selector: 'app-organiation-edit-page',
  templateUrl: './organization-edit-page.component.html',
  styleUrls: ['./organization-edit-page.component.scss']
})
export class OrganizationEditPageComponent implements OnInit {
  isLoaded = false;
  form: FormGroup;
  org: Organization;
  idOrgEdit = '';
  pageMode: 'create' | 'edit';
  organizations: Organization[];
  projects: Project[];

  constructor(private organizationService: OrganizationService,
              private route: ActivatedRoute,
              private router: Router) {

  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      // tslint:disable-next-line:no-conditional-assignment
      if ((this.idOrgEdit = params.id) === 'create') {
        this.pageMode = 'create';
      } else {
        this.pageMode = 'edit';
      }
      this.organizationService.getAll().subscribe(respOrgs => {
        this.organizations = respOrgs.filter(org => {
          if (org.id === this.idOrgEdit) this.org = org;
          else return true;
        });
        this.form = new FormGroup({
            name: new FormControl(this.pageMode === 'edit' ? this.org.name : null, [Validators.required]),
            description: new FormControl(this.pageMode === 'edit' ? this.org.description : null, [Validators.required]),
            headOrganization: new FormControl(this.pageMode === 'edit' ? this.org.headOrganization?.id : null, [Validators.required]),
          }
        );
        this.isLoaded = true;
      });
    });
  }

  edit() {
    let newOrg: Organization = {};
    if (this.pageMode === 'edit') {
      newOrg = {...this.org};
    }
    newOrg.name = this.form.get('name').value;
    newOrg.description = this.form.get('description').value;
    newOrg.headOrganization = this.form.get('headOrganization').value === 'none' ? null : this.organizations.find(org => org.id === this.form.get('headOrganization').value);
    console.log(newOrg);
    if (this.pageMode === 'create') {
      this.organizationService.save(newOrg).subscribe(resp => this.router.navigate(['/admin', 'organization', 'list']));
    } else {
      this.organizationService.edit(newOrg).subscribe(resp => this.router.navigate(['/admin', 'organization', 'list']));
    }
  }
}
