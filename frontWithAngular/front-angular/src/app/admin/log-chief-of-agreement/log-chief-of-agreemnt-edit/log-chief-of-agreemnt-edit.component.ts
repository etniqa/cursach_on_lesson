import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {
  Agreement, CanLead,
  Department,
  Equipment,
  LogChiefOfAgreement,
  LogOfChangeOfEquipment,
  Project
} from "../../../shared/services/interfaces";
import {LogOfChangeOfEquipmentService} from "../../../shared/services/log-of-change-of-equipment.service";
import {EquipmentService} from "../../../shared/services/equipment.service";
import {DepartmentService} from "../../../shared/services/department.service";
import {AgreementService} from "../../../shared/services/agreement.service";
import {ActivatedRoute, Router} from "@angular/router";
import {LogChiefOfAgreementService} from "../../../shared/services/log-chief-of-agreement.service";
import {WorkerService} from "../../../shared/services/worker.service";

@Component({
  selector: 'app-log-chief-of-agreemnt-edit',
  templateUrl: './log-chief-of-agreemnt-edit.component.html',
  styleUrls: ['./log-chief-of-agreemnt-edit.component.scss']
})
export class LogChiefOfAgreemntEditComponent implements OnInit {
  isLoaded = false;
  form: FormGroup;
  logEdit: LogChiefOfAgreement;
  idLog = '';
  pageMode: 'create' | 'edit';
  agreements: Agreement[];
  canLeads: CanLead[];
  lastLogOfAgreem: LogChiefOfAgreement;
  errorOfNotTheSameAsLastLog = 'New log of equipment must be not the same as the last one.';
  error = '';

  constructor(private logChiefOfAgreementService: LogChiefOfAgreementService,
              private workerService: WorkerService,
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
      this.logChiefOfAgreementService.getById(this.idLog).subscribe(respLog => {
        this.logEdit = respLog;
        this.agreementService.getAll().subscribe(respAgreems => {
          this.agreements = respAgreems;
          this.workerService.getCanLeads().subscribe(respCanLeads => {
            this.canLeads = respCanLeads;
            this.form = new FormGroup({
                description: new FormControl(this.pageMode === 'edit' ? this.logEdit.description : null, Validators.required),
                agreement: new FormControl(this.pageMode === 'edit' ?
                  this.logEdit.agreement.id : null, [Validators.required]),
                chief: new FormControl(this.pageMode === 'edit' ?
                  (this.logEdit.chief.id) : null, [Validators.required]),
              }
            );
            if (this.pageMode === 'edit') {
              this.changeAgreem(this.logEdit.agreement.id);
            }
            this.isLoaded = true;
          });
        });
      });
    });
  }

  save() {
    let newLogChiefOfAgreem: LogChiefOfAgreement = {};
    if (this.pageMode === 'edit') {
      newLogChiefOfAgreem = {...this.logEdit};
    }
    newLogChiefOfAgreem.description = this.form.get('description').value;
    newLogChiefOfAgreem.agreement = this.agreements.find(dep => dep.id === this.form.get('agreement').value);
    newLogChiefOfAgreem.chief = this.canLeads.find(canLead => canLead.id === this.form.get('chief').value);
    console.log(newLogChiefOfAgreem);
    if (this.pageMode === 'create') {
      this.logChiefOfAgreementService.save(newLogChiefOfAgreem).subscribe(resp => this.router.navigate(['/admin', 'log_chief_of_agreement', 'list']));
    } else {
      this.logChiefOfAgreementService.edit(newLogChiefOfAgreem).subscribe(resp => this.router.navigate(['/admin', 'log_chief_of_agreement', 'list']));
    }
  }

  changeAgreem(agreemId: string) {
    this.logChiefOfAgreementService.getLastLogForAgreem(agreemId).subscribe(respLastLog => {
      this.lastLogOfAgreem = respLastLog;
      console.log(respLastLog);
      this.form.get('agreement').setValue(respLastLog.agreement?.id === undefined ? 'none' : respLastLog.agreement?.id);
      this.form.get('chief').setValue(respLastLog.chief?.id === undefined ? 'none' : respLastLog.chief?.id);
    });
    return false;
  }

  isThisIsLastLogOnForm() {
    if ((this.lastLogOfAgreem.agreement?.id === undefined ? 'none' : this.lastLogOfAgreem.agreement?.id) === this.form.get('agreement').value &&
      (this.lastLogOfAgreem.chief?.id === undefined ? 'none' : this.lastLogOfAgreem.chief?.id) === this.form.get('chief').value) {
      this.error = this.errorOfNotTheSameAsLastLog;
      return true;
    } else {
      this.error = '';
      return false;
    }
  }
}
