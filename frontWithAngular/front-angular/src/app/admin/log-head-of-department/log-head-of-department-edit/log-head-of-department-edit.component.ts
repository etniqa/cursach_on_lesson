import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {
  Agreement,
  CanLead,
  Department,
  LogChiefOfAgreement,
  LogHeadOfDepartment
} from "../../../shared/services/interfaces";
import {LogChiefOfAgreementService} from "../../../shared/services/log-chief-of-agreement.service";
import {WorkerService} from "../../../shared/services/worker.service";
import {AgreementService} from "../../../shared/services/agreement.service";
import {ActivatedRoute, Router} from "@angular/router";
import {DepartmentService} from "../../../shared/services/department.service";
import {LogHeadOfDepartmentService} from "../../../shared/services/log-head-of-department.service";

@Component({
  selector: 'app-log-head-of-department-edit',
  templateUrl: './log-head-of-department-edit.component.html',
  styleUrls: ['./log-head-of-department-edit.component.scss']
})
export class LogHeadOfDepartmentEditComponent implements OnInit {
  isLoaded = false;
  form: FormGroup;
  logEdit: LogHeadOfDepartment;
  idLog = '';
  pageMode: 'create' | 'edit';
  departments: Agreement[];
  canLeads: CanLead[];
  lastLogHeadOfDepartment: LogHeadOfDepartment;
  errorOfNotTheSameAsLastLog = 'New log of equipment must be not the same as the last one.';
  error = '';

  constructor(private logHeadOfDepartmentService: LogHeadOfDepartmentService,
              private workerService: WorkerService,
              private departmentService: DepartmentService,
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
      this.logHeadOfDepartmentService.getById(this.idLog).subscribe(respLog => {
        this.logEdit = respLog;
        this.departmentService.getAll().subscribe(respDepartments => {
          this.departments = respDepartments;
          this.workerService.getCanLeads().subscribe(respCanLeads => {
            this.canLeads = respCanLeads;
            this.form = new FormGroup({
                description: new FormControl(this.pageMode === 'edit' ? this.logEdit.description : null, Validators.required),
                department: new FormControl(this.pageMode === 'edit' ?
                  this.logEdit.department.id : null, [Validators.required]),
                headOfDepartment: new FormControl(this.pageMode === 'edit' ?
                  (this.logEdit.headOfDepartment.id) : null, [Validators.required]),
              }
            );
            if (this.pageMode === 'edit') {
              this.changeDepartment(this.logEdit.department.id);
            }
            this.isLoaded = true;
          });
        });
      });
    });
  }

  save() {
    let newLogHeadOfDepartment: LogHeadOfDepartment = {};
    if (this.pageMode === 'edit') {
      newLogHeadOfDepartment = {...this.logEdit};
    }
    newLogHeadOfDepartment.description = this.form.get('description').value;
    newLogHeadOfDepartment.department = this.departments.find(dep => dep.id === this.form.get('department').value);
    newLogHeadOfDepartment.headOfDepartment = this.canLeads.find(canLead => canLead.id === this.form.get('headOfDepartment').value);
    console.log(newLogHeadOfDepartment);
    if (this.pageMode === 'create') {
      this.logHeadOfDepartmentService.save(newLogHeadOfDepartment).subscribe(resp => this.router.navigate(['/admin', 'log_head_of_department', 'list']));
    } else {
      this.logHeadOfDepartmentService.edit(newLogHeadOfDepartment).subscribe(resp => this.router.navigate(['/admin', 'log_head_of_department', 'list']));
    }
  }

  changeDepartment(depId: string) {
    this.logHeadOfDepartmentService.getLastForThisDepartment(depId).subscribe(respLastLog => {
      this.lastLogHeadOfDepartment = respLastLog;
      console.log(respLastLog);
      this.form.get('department').setValue(respLastLog.department?.id === undefined ? 'none' : respLastLog.department?.id);
      this.form.get('headOfDepartment').setValue(respLastLog.headOfDepartment?.id === undefined ? 'none' : respLastLog.headOfDepartment?.id);
    });
    return false;
  }

  isThisIsLastLogOnForm() {

    if (this.lastLogHeadOfDepartment.department?.id === this.form.get('department').value &&
      this.lastLogHeadOfDepartment.headOfDepartment?.id === this.form.get('headOfDepartment').value) {
      this.error = this.errorOfNotTheSameAsLastLog;
      return true;
    } else {
      this.error = '';
      return false;
    }
  }
}
