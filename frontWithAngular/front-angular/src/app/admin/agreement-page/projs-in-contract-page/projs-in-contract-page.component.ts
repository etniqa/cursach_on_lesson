import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {AgreementService} from "../../../shared/services/agreement.service";
import {Agreement, Contract, Organization, Project} from "../../../shared/services/interfaces";
import {OrganizationService} from "../../../shared/services/organization.service";

@Component({
  selector: 'app-projs-in-contract-page',
  templateUrl: './projs-in-contract-page.component.html',
  styleUrls: ['./projs-in-contract-page.component.scss']
})
export class ProjsInContractPageComponent implements OnInit {
  isLoadedForm = false;
  isLoadedResp = null;
  form: FormGroup;
  organizations: Organization[];
  contracts: Contract[];
  projectsForContract: Project[];
  chosenOrgId = '';
  chosenContractId = '';
  constructor(private agreementService: AgreementService,
              private organizationService: OrganizationService,
              ) { }

  ngOnInit(): void {
    this.organizationService.getAll().subscribe(respOrgs => {
      this.organizations = respOrgs;
      this.isLoadedForm = true;
    });

    this.form = new FormGroup({
      organization: new FormControl(null, [Validators.required]),
      contract: new FormControl(null, [Validators.required]),
    });
  }

  changeOrg(orgId: string) {
    this.chosenOrgId = orgId;
    this.isLoadedForm = false;
    this.agreementService.getContractsForThisOrg(this.chosenOrgId).subscribe(respContracts => {
      this.contracts = respContracts;
      this.isLoadedForm = true;
    });
  }

  changeContract(contractId: string) {
    this.chosenContractId = contractId;
    console.log(this.chosenContractId);
  }

  search() {
    this.isLoadedResp = false;
    this.agreementService.getProjectsForThisContract(this.chosenContractId).subscribe(respProjs => {
      this.projectsForContract = respProjs;
      console.log(this.projectsForContract);
      this.isLoadedResp = true;
    });
  }

  delete(projDel: Project) {
    this.isLoadedResp = false;
    this.agreementService.deleteAndGetProjectsForContract(projDel.id, this.form.get('contract').value).subscribe(respProjs => {
      this.projectsForContract = respProjs;
      console.log(this.projectsForContract);
      this.isLoadedResp = true;
    });
  }
}
