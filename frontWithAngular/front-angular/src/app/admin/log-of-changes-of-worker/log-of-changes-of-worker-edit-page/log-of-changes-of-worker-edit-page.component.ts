import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {
  Department,
  Equipment,
  LogOfChangeOfEquipment,
  LogOfChangeOfWorker,
  Project, Worker
} from "../../../shared/services/interfaces";
import {LogOfChangeOfEquipmentService} from "../../../shared/services/log-of-change-of-equipment.service";
import {EquipmentService} from "../../../shared/services/equipment.service";
import {DepartmentService} from "../../../shared/services/department.service";
import {AgreementService} from "../../../shared/services/agreement.service";
import {ActivatedRoute, Router} from "@angular/router";
import {WorkerService} from "../../../shared/services/worker.service";
import {LogOfChangesOfWorkerService} from "../../../shared/services/log-of-changes-of-worker.service";

@Component({
  selector: 'app-log-of-changes-of-worker-edit-page',
  templateUrl: './log-of-changes-of-worker-edit-page.component.html',
  styleUrls: ['./log-of-changes-of-worker-edit-page.component.scss']
})
export class LogOfChangesOfWorkerEditPageComponent implements OnInit {
  isLoaded = false;
  form: FormGroup;
  logEdit: LogOfChangeOfWorker;
  idLog = '';
  pageMode: 'create' | 'edit';
  workers: Worker[];
  departments: Department[];
  projects: Project[];
  lastLogOfWorker: LogOfChangeOfWorker;
  errorOfNotTheSameAsLastLog = 'New log of change of worker must be not the same as the last one.';
  error = '';

  constructor(private logOfChangesOfWorkerService: LogOfChangesOfWorkerService,
              private workerService: WorkerService,
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
      this.logOfChangesOfWorkerService.getById(this.idLog).subscribe(respLog => {
        this.logEdit = respLog;
        console.log(this.logEdit);
        // console.log(this.logEdit.possibleNewProj);
        this.departmentService.getAll().subscribe(respDeps => {
          this.departments = respDeps;
          this.workerService.getAll().subscribe(respWorkers => {
            this.workers = respWorkers;
            this.agreementService.getProjects().subscribe(respProjs => {
              this.projects = respProjs;
              this.form = new FormGroup({
                  description: new FormControl(this.pageMode === 'edit' ? this.logEdit.description : null),
                  worker: new FormControl(this.pageMode === 'edit' ?
                    this.logEdit.workerWhoChangeSmth.id : null, [Validators.required]),
                  department: new FormControl(this.pageMode === 'edit' ?
                    (this.logEdit.possibleNewDepartment === null ? 'none' : this.logEdit.possibleNewDepartment.id) : null, [Validators.required]),
                  project: new FormControl(this.pageMode === 'edit' ?
                    (this.logEdit.possibleNewProj === null ? 'none' : this.logEdit.possibleNewProj.id) : null, [Validators.required]),
                }
              );
              if (this.pageMode === 'edit') {
                this.changeWorker(this.logEdit.workerWhoChangeSmth.id);
              }
              this.isLoaded = true;
            });
          });
        });
      });
    });
  }

  edit() {
    let newLogOfChangesOfEquipment: LogOfChangeOfWorker = {};
    if (this.pageMode === 'edit') {
      newLogOfChangesOfEquipment = {...this.logEdit};
    }
    newLogOfChangesOfEquipment.description = this.form.get('description').value;
    newLogOfChangesOfEquipment.workerWhoChangeSmth = this.workers.find(worker => worker.id === this.form.get('worker').value);
    newLogOfChangesOfEquipment.possibleNewDepartment = this.departments.find(dep => dep.id === this.form.get('department').value);
    newLogOfChangesOfEquipment.possibleNewProj = this.projects.find(proj => proj.id === this.form.get('project').value);
    if (this.pageMode === 'create') {
      this.logOfChangesOfWorkerService.save(newLogOfChangesOfEquipment).subscribe(resp => this.router.navigate(['/admin', 'log_of_changes_of_worker', 'list']));
    } else {
      this.logOfChangesOfWorkerService.edit(newLogOfChangesOfEquipment).subscribe(resp => this.router.navigate(['/admin', 'log_of_changes_of_worker', 'list']));
    }
  }

  changeWorker(equipId: string) {
    this.logOfChangesOfWorkerService.getLastLogForPredictionByEquipId(equipId).subscribe(respLastLog => {
      this.lastLogOfWorker = respLastLog;
      console.log(respLastLog);
      this.form.get('department').setValue(respLastLog.possibleNewDepartment?.id === undefined ? 'none' : respLastLog.possibleNewDepartment?.id);
      this.form.get('project').setValue(respLastLog.possibleNewProj?.id === undefined ? 'none' : respLastLog.possibleNewProj?.id);
    });
  }

  isThisIsLastLogOnForm() {
    if ((this.lastLogOfWorker.possibleNewDepartment?.id === undefined ? 'none' : this.lastLogOfWorker.possibleNewDepartment?.id) === this.form.get('department').value &&
      (this.lastLogOfWorker.possibleNewProj?.id === undefined ? 'none' : this.lastLogOfWorker.possibleNewProj?.id) === this.form.get('project').value) {
      this.error = this.errorOfNotTheSameAsLastLog;
      return true;
    } else {
      this.error = '';
      return false;
    }
  }
}
