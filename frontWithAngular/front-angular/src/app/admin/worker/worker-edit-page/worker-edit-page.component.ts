import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Agreement, Department, Designer, Organization, Worker} from '../../../shared/services/interfaces';
import {AgreementService} from '../../../shared/services/agreement.service';
import {OrganizationService} from '../../../shared/services/organization.service';
import {ActivatedRoute, Router} from '@angular/router';
import {DepartmentService} from '../../../shared/services/department.service';
import {WorkerService} from '../../../shared/services/worker.service';

@Component({
  selector: 'app-worker-edit-page',
  templateUrl: './worker-edit-page.component.html',
  styleUrls: ['./worker-edit-page.component.scss']
})
export class WorkerEditPageComponent implements OnInit {
  isLoaded = false;
  form: FormGroup;
  worker: Worker;
  id = '';
  pageMode: 'create' | 'edit';
  departments: Department[];
  agreements: Agreement[];

  constructor(private agreementService: AgreementService,
              private workerService: WorkerService,
              private departmentService: DepartmentService,
              private route: ActivatedRoute,
              private router: Router) {
  }

  private mapNameOfAdditionalField = [
    {assistant: 'rate'},
    {designer: 'numberOfLicences'},
    {engineer: 'yearsOfExperience'},
    {staff: 'rang'},
    {technician: 'yearsOfExperience'},
  ];

  ngOnInit() {
    this.isLoaded = false;
    this.route.params.subscribe(params => {
        if ((this.id = params.id) === 'create') {
          this.pageMode = 'create';
        } else {
          this.pageMode = 'edit';
        }
        this.workerService.getById(this.id).subscribe(respWorker => {
          this.worker = respWorker;
          console.log(this.worker);
          console.log(this.mapNameOfAdditionalField[this.worker.shortClassName.toLowerCase()]);
          console.log((this.worker as Designer)[this.mapNameOfAdditionalField[this.worker.shortClassName.toLowerCase()]]);
          this.departmentService.getAll().subscribe(respDeps => {
            this.departments = respDeps;
            this.agreementService.getProjects().subscribe(respProjs => {
              this.agreements = respProjs;
              this.form = new FormGroup({
                  name: new FormControl(this.pageMode === 'edit' ? this.worker.name : null, [Validators.required]),
                  description: new FormControl(this.pageMode === 'edit' ? this.worker.description : null, [Validators.required]),
                  department: new FormControl(this.pageMode === 'edit' ? this.worker.departmentWhereWorks.id : null, [Validators.required]),
                  agreement: new FormControl(this.pageMode === 'edit' ? this.worker.agreementWhereIsWorking.id : null, [Validators.required]),
                  // additionalField: new FormControl(this.pageMode === 'edit' ?
                  //   (this.worker[this.nameOfAdditionalField[this.worker.shortClassName.toLowerCase()]])
                  //   : null, [Validators.required])
                }
              );
              this.isLoaded = true;
            });
          });
        });
      }
    );
  }

  edit() {
    // let newAgreem: Agreement = {};
    // if (this.pageMode === 'edit') {
    //   newAgreem = {...this.worker};
    // }
    // newAgreem.name = this.form.get('name').value;
    // newAgreem.description = this.form.get('description').value;
    // newAgreem.dateBeg = this.form.get('dateBeg').value;
    // newAgreem.dateEnd = this.form.get('dateEnd').value;
    // newAgreem.organizationWhichSign = this.organizations.find(org => org.id === this.form.get('organization').value);
    // console.log(newAgreem);
    // if (this.pageMode === 'create') {
    //   this.agreementService.save(newAgreem, this.form.get('type').value).subscribe(success => this.router.navigate(['/admin', 'agreement', 'list']));
    // } else {
    //   this.agreementService.edit(newAgreem).subscribe(success => this.router.navigate(['/admin', 'agreement', 'list']));
    // }
  }
}
