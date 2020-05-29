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
          if (this.pageMode === 'edit') {
            console.log(this.worker);
            console.log(this.mapNameOfAdditionalField[this.worker.shortClassName.toLowerCase()]);
            console.log((this.worker as Designer)[this.mapNameOfAdditionalField[this.worker.shortClassName.toLowerCase()]]);
          }
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
    let newWorker: Worker = {};
    if (this.pageMode === 'edit') {
      newWorker = {...this.worker};
    }
    newWorker.name = this.form.get('name').value;
    newWorker.description = this.form.get('description').value;
    newWorker.departmentWhereWorks = this.departments.find(dep => dep.id === this.form.get('department').value);
    newWorker.agreementWhereIsWorking = this.agreements.find(agr => agr.id === this.form.get('agreement').value);
    if (this.pageMode === 'create') {
      this.agreementService.save(newWorker, this.form.get('type').value).subscribe(success => this.router.navigate(['/admin', 'agreement', 'list']));
    } else {
      this.agreementService.edit(newWorker).subscribe(success => this.router.navigate(['/admin', 'agreement', 'list']));
    }
  }
}
