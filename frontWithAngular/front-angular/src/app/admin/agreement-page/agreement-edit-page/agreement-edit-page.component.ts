import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Agreement, Organization, Project} from '../../../shared/services/interfaces';
import {OrganizationService} from '../../../shared/services/organization.service';
import {ActivatedRoute, Router} from '@angular/router';
import {AgreementService} from '../../../shared/services/agreement.service';

@Component({
  selector: 'app-agreement-edit-page',
  templateUrl: './agreement-edit-page.component.html',
  styleUrls: ['./agreement-edit-page.component.scss']
})
export class AgreementEditPageComponent implements OnInit {
  isLoaded = false;
  form: FormGroup;
  agreement: Agreement;
  idAgreement = '';
  pageMode: 'create' | 'edit';
  organizations: Organization[];
  error = '';
  errorWrongDates = 'date from need to be less than date to';

  constructor(private agreementService: AgreementService,
              private organizationService: OrganizationService,
              private route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit() {
    this.isLoaded = false;
    this.route.params.subscribe(params => {
        if ((this.idAgreement = params.id) === 'create') {
          this.pageMode = 'create';
        } else {
          this.pageMode = 'edit';
        }
        this.agreementService.getById(this.idAgreement).subscribe(respAgreem => {
          this.agreement = respAgreem;
          this.organizationService.getAll().subscribe(respOrganizations => {
            this.organizations = respOrganizations;
            this.form = new FormGroup({
                name: new FormControl(this.pageMode === 'edit' ? this.agreement.name : null, [Validators.required]),
                description: new FormControl(this.pageMode === 'edit' ? this.agreement.description : null, [Validators.required]),
                dateBeg: new FormControl(this.pageMode === 'edit' ? this.agreement.dateBeg : null, [Validators.required]),
                dateEnd: new FormControl(this.pageMode === 'edit' ? this.agreement.dateEnd : null, Validators.required),
                organization: new FormControl(this.pageMode === 'edit' ? this.agreement.organizationWhichSign.id : null, [Validators.required]),
                type: new FormControl(this.pageMode === 'edit' ? 'type' : null, [Validators.required]),
                cost: new FormControl(this.pageMode === 'edit' ? this.agreement.cost : null, [Validators.required])
            }
            );
            this.isLoaded = true;
          });
        });
      }
    );
  }

  edit() {
    let newAgreem: Agreement = {};
    if (this.pageMode === 'edit') {
      newAgreem = {...this.agreement};
    }
    newAgreem.name = this.form.get('name').value;
    newAgreem.description = this.form.get('description').value;
    newAgreem.dateBeg = this.form.get('dateBeg').value;
    newAgreem.dateEnd = this.form.get('dateEnd').value;
    newAgreem.organizationWhichSign = this.organizations.find(org => org.id === this.form.get('organization').value);
    newAgreem.cost = this.form.get('cost').value;
    console.log(newAgreem);
    if (this.pageMode === 'create') {
      this.agreementService.save(newAgreem, this.form.get('type').value).subscribe(success => this.router.navigate(['/admin', 'agreement', 'list']));
    } else {
      this.agreementService.edit(newAgreem).subscribe(success => this.router.navigate(['/admin', 'agreement', 'list']));
    }
  }

  isDatesAreWrong() {
    console.log('check');
    if (Date.parse(this.form.get('dateBeg').value) > Date.parse(this.form.get('dateEnd').value)) {
      this.error = this.errorWrongDates;
      return true;
    } else {
      this.error = '';
      return false;
    }

  }
}
