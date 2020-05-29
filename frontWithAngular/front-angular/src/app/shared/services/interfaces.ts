export interface CommonFields {
  id?: string;
  name?: string;
  description?: string;
  creationDate?: Date;
  dateModified?: Date;
}

export interface Department extends CommonFields{
  organization?: Organization;
}

export interface Organization extends CommonFields {
  organization?: Organization;
}

export interface Equipment extends CommonFields {
  depWhichResponsible?: Department;
  projectWhereIsNowEquip?: Project;
}

export interface LogOfChangeOfEquipment extends CommonFields{
  equipWhichChangeField?: Equipment;
  possibleNewDepartment?: Department;
  possibleNewProject?: Project;
  dateBegAfterChange?: Date;
  dateEndBeforeNewChange?: Date;
}

export interface LogChiefOfAgreement extends CommonFields{
  begDate?: Date;
  endDate?: Date;
  agreement?: Agreement;
  chief?: CanLead;
}

export interface LogHeadOfDepartment extends CommonFields{
  begDate?: Date;
  endDate?: Date;
  headOfDepartment?: CanLead;
  department?: Department;
}

export interface LogOfChangeOfWorker extends CommonFields{
  workerWhoChangeSmth?: Worker;
  possibleNewDepartment?: Department;
  possibleNewProj ?: Project;
  dateTimeOfChange?: Date;
  dateTimeBeforeNewChange?: Date;
}

export interface Agreement extends CommonFields{
  dateBeg?: Date;
  dateEnd?: Date;
  organizationWhichSign?: Organization;
  fullName?: string;
  cost?: number;
}

// tslint:disable-next-line:no-empty-interface
export interface Project extends Agreement{
}
// tslint:disable-next-line:no-empty-interface
export interface Contract extends Agreement{
}

export interface Organization extends CommonFields {
  headOrganization?: Organization;
}

export interface Worker extends CommonFields{
  departmentWhereWorks?: Department;
  agreementWhereIsWorking?: Agreement;
  shortClassName?: string;
  shortClassnameWithName: string;
}
export interface CanLead extends Worker{
}
export interface Designer extends CanLead{
  numberOfLicences?: number;
}
export interface Engineer {
  yearOfExperience?: number;
}
export interface Staff {
  rang?: number;
}
export interface Technician extends Worker {
  yearOfExperience?: number;
}

export interface TechnicianHasEquipment extends CommonFields{
  technician?: Technician;
  equipment?: Equipment;
}

export interface AgreementHasAgreement extends CommonFields{
  headAgreуm?: Agreement;
  dependentAgreem?: Agreement;
}

export interface RespPairListAndInt {
  list?: Agreement[];
  totalCost?: number;
}
