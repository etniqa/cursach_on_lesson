import {Injectable, NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AdminLayoutComponent} from './shared/admin-layout/admin-layout.component';
import {RouterModule} from '@angular/router';
import {SharedModule} from "../shared/shared.module";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {DepartmentPageLayoutComponent} from './department-page/shared/department-page-layout/department-page-layout.component';
import {DepartmentsListPageComponent} from './department-page/department-list-page/departments-list-page.component';
import {DepartmentEditPageComponent} from './department-page/department-edit-page/department-edit-page.component';
import {EquipmentPageLayoutComponent} from "./equipment-page/shared/equipment-page-layout/equipment-page-layout.component";
import {EquipmentListComponent} from "./equipment-page/equipment-list/equipment-list.component";
import {EquipmentEditComponent} from "./equipment-page/equipment-edit/equipment-edit.component";
import {AgreementPageLayoutComponent} from './agreement-page/shared/agreement-page-layout/agreement-page-layout.component';
import {AgreementContractsPageComponent} from './agreement-page/agreement-contracts-page/agreement-contracts-page.component';
import {AgreementProjectsPageComponent} from './agreement-page/agreement-projects-page/agreement-projects-page.component';
import {AgreementListPageComponent} from './agreement-page/agreement-list-page/agreement-list-page.component';
import {AgreementEditPageComponent} from './agreement-page/agreement-edit-page/agreement-edit-page.component';
import {MatRadioModule} from '@angular/material/radio';
import { OrganizationPageLayoutComponent } from './organization/shared/organization-page-layout/organization-page-layout.component';
import {OrganizationListPageComponent} from "./organization/organization-list-page/organization-list-page.component";
import {OrganizationEditPageComponent} from "./organization/organization-edit-page/organization-edit-page.component";
import { LayoutPageComponent } from './technician_has_equipment/shared/layout-page/layout-page.component';
import { TechnicianHasEquipmentListPageComponent } from './technician_has_equipment/technician-has-equipment-list-page/technician-has-equipment-list-page.component';
import { TechnicianHasEquipmentEditPageComponent } from './technician_has_equipment/technician-has-equipment-edit-page/technician-has-equipment-edit-page.component';
import { WorkerLayoutComponent } from './worker/shared/worker-layout/worker-layout.component';
import { WorkerListPageComponent } from './worker/worker-list-page/worker-list-page.component';
import { WorkerEditPageComponent } from './worker/worker-edit-page/worker-edit-page.component';
import { AgreementsInPeriodPageComponent } from './agreement-page/agreements-in-period-page/agreements-in-period-page.component';
import { AmountOfDepartmentsWhereCanleadIsTheSameComponent } from './worker/amount-of-departments-where-canlead-is-the-same/amount-of-departments-where-canlead-is-the-same.component';
import { DepartmentAndAmountOfWorkersPageComponent } from './department-page/department-and-amount-of-workers-page/department-and-amount-of-workers-page.component';
import { ProjsInContractPageComponent } from './agreement-page/projs-in-contract-page/projs-in-contract-page.component';
import { AgreementCalculateCostComponent } from './agreement-page/agreement-calculate-cost/agreement-calculate-cost.component';
import { LogOfChangeOfEquipmentPageLayoutComponent } from './log-of-change-of-equipment/shared/log-of-change-of-equipment-page-layout/log-of-change-of-equipment-page-layout.component';
import { LogOfChangeOfEquipmentListPageComponent } from './log-of-change-of-equipment/log-of-change-of-equipment-list-page/log-of-change-of-equipment-list-page.component';
import { LogOfChangeOfEquipmentEditPageComponent } from './log-of-change-of-equipment/log-of-change-of-equipment-edit-page/log-of-change-of-equipment-edit-page.component';
import { LogOfChangeOfEquipmentGetInPeriodPageComponent } from './log-of-change-of-equipment/log-of-change-of-equipment-get-in-period-page/log-of-change-of-equipment-get-in-period-page.component';
import { LogOfChangeOfEquipmentGetDuringAgreementComponent } from './log-of-change-of-equipment/log-of-change-of-equipment-get-during-agreement/log-of-change-of-equipment-get-during-agreement.component';
import { LogOfChangesOfWorkerListPageComponent } from './log-of-changes-of-worker/log-of-changes-of-worker-list-page/log-of-changes-of-worker-list-page.component';
import { LogOfChangesOfWorkerEditPageComponent } from './log-of-changes-of-worker/log-of-changes-of-worker-edit-page/log-of-changes-of-worker-edit-page.component';
import { LogOfChangesOfWorkerLayoutComponent } from './log-of-changes-of-worker/shared/log-of-changes-of-worker-layout/log-of-changes-of-worker-layout.component';
import {LogOfChangesOfWorkerGetInPeriodComponent} from "./log-of-changes-of-worker/log-of-changes-of-worker-get-in-period/log-of-changes-of-worker-get-in-period.component";
import { AgreementGetOfSuborgsComponent } from './agreement-page/agreement-get-of-suborgs/agreement-get-of-suborgs.component';
import { LogChiefOfAgreementListComponent } from './log-chief-of-agreement/log-chief-of-agreement-list/log-chief-of-agreement-list.component';
import {LogChiefOfAgreemntLayoutComponent} from "./log-chief-of-agreement/log-chief-of-agreemnt-layout/log-chief-of-agreemnt-layout.component";
import {LogChiefOfAgreemntEditComponent} from "./log-chief-of-agreement/log-chief-of-agreemnt-edit/log-chief-of-agreemnt-edit.component";
import { LogHeadOfDepartmentLayoutComponent } from './log-head-of-department/log-head-of-department-layout/log-head-of-department-layout.component';
import { LogHeadOfDepartmentListComponent } from './log-head-of-department/log-head-of-department-list/log-head-of-department-list.component';
import { LogHeadOfDepartmentEditComponent } from './log-head-of-department/log-head-of-department-edit/log-head-of-department-edit.component';
import { SearchByNamePipe } from './shared/search-by-name.pipe';

@Injectable()
@NgModule({
  declarations: [
    DepartmentPageLayoutComponent,
    DepartmentsListPageComponent,
    DepartmentEditPageComponent,
    EquipmentPageLayoutComponent,
    EquipmentListComponent,
    EquipmentEditComponent,
    AgreementPageLayoutComponent,
    AgreementContractsPageComponent,
    AgreementProjectsPageComponent,
    AgreementListPageComponent,
    AgreementEditPageComponent,
    OrganizationPageLayoutComponent,
    OrganizationListPageComponent,
    OrganizationEditPageComponent,
    LayoutPageComponent,
    TechnicianHasEquipmentListPageComponent,
    TechnicianHasEquipmentEditPageComponent,
    WorkerLayoutComponent,
    WorkerListPageComponent,
    WorkerEditPageComponent,
    AgreementsInPeriodPageComponent,
    AmountOfDepartmentsWhereCanleadIsTheSameComponent,
    DepartmentAndAmountOfWorkersPageComponent,
    ProjsInContractPageComponent,
    AgreementCalculateCostComponent,
    LogOfChangeOfEquipmentPageLayoutComponent,
    LogOfChangeOfEquipmentListPageComponent,
    LogOfChangeOfEquipmentEditPageComponent,
    LogOfChangeOfEquipmentGetInPeriodPageComponent,
    LogOfChangeOfEquipmentGetDuringAgreementComponent,
    LogOfChangesOfWorkerListPageComponent,
    LogOfChangesOfWorkerEditPageComponent,
    LogOfChangesOfWorkerLayoutComponent,
    LogOfChangesOfWorkerGetInPeriodComponent,
    LogOfChangesOfWorkerGetInPeriodComponent,
    AgreementGetOfSuborgsComponent,
    LogChiefOfAgreementListComponent,
    LogChiefOfAgreemntLayoutComponent,
    LogChiefOfAgreemntEditComponent,
    LogChiefOfAgreementListComponent,
    LogHeadOfDepartmentLayoutComponent,
    LogHeadOfDepartmentListComponent,
    LogHeadOfDepartmentEditComponent,
    SearchByNamePipe
  ],
  imports: [
    CommonModule,
    RouterModule.forChild([{
      path: '', component: AdminLayoutComponent, children: [
        {path: '', redirectTo: '/admin/agreement/list', pathMatch: 'full'},
        {
          path: 'department', component: DepartmentPageLayoutComponent, children: [
            {path: '', redirectTo: '/admin/department/list', pathMatch: 'full'},
            {path: 'list', component: DepartmentsListPageComponent},
            {path: 'department_and_amount_of_workers', component: DepartmentAndAmountOfWorkersPageComponent},
            {path: 'edit/:id', component: DepartmentEditPageComponent},
          ]
        },
        {
          path: 'equipment', component: EquipmentPageLayoutComponent, children: [
            {path: '', redirectTo: '/admin/equipment/list', pathMatch: 'full'},
            {path: 'list', component: EquipmentListComponent},
            {path: 'edit/:id', component: EquipmentEditComponent},
          ]
        },
        {
          path: 'log_of_changes_of_worker', component: LogOfChangesOfWorkerLayoutComponent, children: [
            {path: '', redirectTo: '/admin/log_of_changes_of_worker/list', pathMatch: 'full'},
            {path: 'list', component: LogOfChangesOfWorkerListPageComponent},
            {path: 'edit/:id', component: LogOfChangesOfWorkerEditPageComponent},
            {path: 'get_in_period', component: LogOfChangesOfWorkerGetInPeriodComponent},
          ]
        },
        {
          path: 'log_of_changes_of_equipment', component: LogOfChangesOfWorkerLayoutComponent, children: [
            {path: '', redirectTo: '/admin/log_of_changes_of_equipment/list', pathMatch: 'full'},
            {path: 'list', component: LogOfChangeOfEquipmentListPageComponent},
            {path: 'edit/:id', component: LogOfChangeOfEquipmentEditPageComponent},
            {path: 'get_in_period', component: LogOfChangeOfEquipmentGetInPeriodPageComponent},
          ]
        },
        {
          path: 'log_chief_of_agreement', component: LogChiefOfAgreemntLayoutComponent, children: [
            {path: '', redirectTo: '/admin/log_chief_of_agreement/list', pathMatch: 'full'},
            {path: 'list', component: LogChiefOfAgreementListComponent},
            {path: 'edit/:id', component: LogChiefOfAgreemntEditComponent},
          ]
        },
        {
          path: 'log_head_of_department', component: LogHeadOfDepartmentLayoutComponent, children: [
            {path: '', redirectTo: '/admin/log_head_of_department/list', pathMatch: 'full'},
            {path: 'list', component: LogHeadOfDepartmentListComponent},
            {path: 'edit/:id', component: LogHeadOfDepartmentEditComponent},
          ]
        },
        {
          path: 'agreement', component: AgreementPageLayoutComponent, children: [
            {path: '', redirectTo: '/admin/agreement/list', pathMatch: 'full'},
            {path: 'list', component: AgreementListPageComponent},
            {path: 'edit/:id', component: AgreementEditPageComponent},
            {path: 'projects', component: AgreementProjectsPageComponent},
            {path: 'contracts', component: AgreementContractsPageComponent},
            {path: 'get_in_period', component: AgreementsInPeriodPageComponent},
            {path: 'projs_in_contract', component: ProjsInContractPageComponent},
            {path: 'calculate_cost', component: AgreementCalculateCostComponent},
            {path: 'get_of_suborgs', component: AgreementGetOfSuborgsComponent},
          ]
        },
        {
          path: 'organization', component: OrganizationPageLayoutComponent, children: [
            {path: '', redirectTo: '/admin/organization/list', pathMatch: 'full'},
            {path: 'list', component: OrganizationListPageComponent},
            {path: 'edit/:id', component: OrganizationEditPageComponent},
          ]
        },
        {
          path: 'technician_has_equipment', component: LayoutPageComponent, children: [
            {path: '', redirectTo: '/admin/technician_has_equipment/list', pathMatch: 'full'},
            {path: 'list', component: TechnicianHasEquipmentListPageComponent},
            {path: 'edit/:id', component: TechnicianHasEquipmentEditPageComponent},
          ]
        },
        {
          path: 'worker', component: WorkerLayoutComponent, children: [
            {path: '', redirectTo: '/admin/worker/list', pathMatch: 'full'},
            {path: 'list', component: WorkerListPageComponent},
            {path: 'edit/:id', component: WorkerEditPageComponent},
            {path: 'map_with_canlead_and_amount', component: AmountOfDepartmentsWhereCanleadIsTheSameComponent},
          ]
        }
      ]
    }]),
    SharedModule,
    ReactiveFormsModule,
    FormsModule,
    MatRadioModule,
  ],
  exports: [
    RouterModule,
    SharedModule,
  ]
})
export class AdminModule {
}
