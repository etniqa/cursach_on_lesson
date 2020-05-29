import { Component, OnInit } from '@angular/core';
import {Agreement, Contract, Project} from "../../../shared/services/interfaces";
import {AgreementService} from "../../../shared/services/agreement.service";

@Component({
  selector: 'app-agreement-projects-page',
  templateUrl: './agreement-projects-page.component.html',
  styleUrls: ['./agreement-projects-page.component.scss']
})
export class AgreementProjectsPageComponent implements OnInit {
  isLoaded = false;
  projects: Project[];
  constructor(
    private agreementService: AgreementService,
  ) { }

  ngOnInit(): void {
    this.isLoaded = false;
    this.agreementService.getProjects().subscribe(respProjs => {
      this.projects = respProjs;
      this.isLoaded = true;
    });
  }

  delete(agreem: Agreement) {
    this.isLoaded = false;
    this.agreementService.delete(agreem).subscribe(success => {
      this.agreementService.getProjects().subscribe(respProjs => {
        this.projects = respProjs;
        this.isLoaded = true;
      });
    });
  }

  checkIsNeedToAddInactiveClass(project: Project) {
    return project.dateEnd ? Date.parse(project.dateEnd as unknown as string) < Date.now() : false;
  }
}
