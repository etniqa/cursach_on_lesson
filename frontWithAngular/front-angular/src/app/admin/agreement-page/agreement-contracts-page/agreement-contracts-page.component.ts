import { Component, OnInit } from '@angular/core';
import {Agreement, Contract} from "../../../shared/services/interfaces";
import {AgreementService} from "../../../shared/services/agreement.service";

@Component({
  selector: 'app-agreement-contracts-page',
  templateUrl: './agreement-contracts-page.component.html',
  styleUrls: ['./agreement-contracts-page.component.scss']
})
export class AgreementContractsPageComponent implements OnInit {
  isLoaded = false;
  contracts: Contract[];
  constructor(
    private agreementService: AgreementService,
  ) { }

  ngOnInit(): void {
    this.isLoaded = false;
    this.agreementService.getContracts().subscribe(respContracts => {
      this.contracts = respContracts;
      this.isLoaded = true;
    });
  }

  delete(agreem: Agreement) {
    this.isLoaded = false;
    this.agreementService.delete(agreem).subscribe(success => {
      this.agreementService.getContracts().subscribe(respContracts => {
        this.contracts = respContracts;
        this.isLoaded = true;
      });
    });
  }

  checkIsNeedToAddInactiveClass(contract: Contract) {
    return contract.dateEnd ? Date.parse(contract.dateEnd as unknown as string) < Date.now() : false;
  }
}
