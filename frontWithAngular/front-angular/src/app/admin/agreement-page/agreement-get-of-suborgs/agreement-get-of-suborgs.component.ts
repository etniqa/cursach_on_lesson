import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Agreement, Organization, RespPairListAndInt} from "../../../shared/services/interfaces";
import {OrganizationService} from "../../../shared/services/organization.service";
import {AgreementService} from "../../../shared/services/agreement.service";

@Component({
  selector: 'app-agreement-get-of-suborgs',
  templateUrl: './agreement-get-of-suborgs.component.html',
  styleUrls: ['./agreement-get-of-suborgs.component.scss']
})
export class AgreementGetOfSuborgsComponent implements OnInit {
  form: FormGroup;
  isLoadedForm = false;
  isLoadedResp = null;
  subOrgs: Organization[];
  pairListAndInt: RespPairListAndInt;

  constructor(private organizationService: OrganizationService,
              private agreementService: AgreementService) { }

  ngOnInit(): void {
    this.organizationService.getSuborgs().subscribe(respSuborgs => {
      this.subOrgs = respSuborgs;
      this.form = new FormGroup({
        organization: new FormControl(null, Validators.required)
      });
      this.isLoadedForm = true;
    });
  }

  private updateResp() {
    this.agreementService.getAgreemsForSuborg(this.form.get('organization').value).subscribe(resp => {
      console.log(resp);
      this.pairListAndInt = {list: resp.first, totalCost: resp.second};
      console.log(this.pairListAndInt);
      this.isLoadedResp = true;
    });
  }

  search() {
    this.updateResp();
  }

  delete(agreem: Agreement) {
    this.isLoadedResp = false;
    this.agreementService.delete(agreem).subscribe(success => {
      this.updateResp();
    });
  }
}
