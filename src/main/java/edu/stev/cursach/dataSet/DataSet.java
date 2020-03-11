package edu.stev.cursach.dataSet;

import edu.stev.cursach.model.pojos.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
public class DataSet {
    private Organization continuumOrganization = new Organization(UUID.randomUUID().toString(),
            "Continuum", "from Chernivtsi. There is no head organization", LocalDateTime.now(),
            null, null);
    private Department motorcycleRepairDepartment = new Department(UUID.randomUUID().toString(),
            "Department of bike`s repair", "in Continuum", LocalDateTime.now(),
            null, continuumOrganization);//head  = Rudyaga
    private Department carRepairDepartment = new Department(UUID.randomUUID().toString(), "Department of car`s repair", "in Continuum",
            LocalDateTime.now(), null, continuumOrganization);//head = Baranov
    private Contract withVolkswagenContract = new Contract(UUID.randomUUID().toString(),
            "With Volkswagen", "in car`s repair", LocalDateTime.now(), null, LocalDateTime.now(),
            null, continuumOrganization, 0); //head will be Baranov S.
    private Contract withHondaContract = new Contract(UUID.randomUUID().toString(), "with honda",
            "in bike`s repair", LocalDateTime.now(), null, LocalDateTime.now(), null, continuumOrganization,
            0);//chief will be Ghubya M.
    private Project warrantyRepairProject = new Project(UUID.randomUUID().toString(), "Warranty repair", "with Volkswagen", LocalDateTime.now(),
            null, LocalDateTime.now(), null, continuumOrganization, 0);//chief - Batyev A.
    private Organization bmxForLifeOrganization = new Organization(UUID.randomUUID().toString(),
            "bmx for life", "in Continuum", LocalDateTime.now(),
            null, continuumOrganization);
    private Project wheelExchangeProject = new Project(UUID.randomUUID().toString(),
            "Happy wheel", "for Honda and Volkswagen", LocalDateTime.now(),
            null, LocalDateTime.now(), null, bmxForLifeOrganization, 0);//chief - Rydyaga D.
    //workers
    //leaders
    private Designer rudyagaDesigner = new Designer(UUID.randomUUID().toString(), "Rudyaga D.", "from Chernivtsi", LocalDateTime.now(),
            null, motorcycleRepairDepartment, wheelExchangeProject, 3);
    private Engineer baranovEngineer = new Engineer(UUID.randomUUID().toString(), "Baranov S.", "from Novosnistrovsk", LocalDateTime.now(),
            null, carRepairDepartment, wheelExchangeProject, 1);
    private Engineer batyevEngineer = new Engineer(UUID.randomUUID().toString(), "Batyeb A.", "from Chernivtsi", LocalDateTime.now(),
            null, carRepairDepartment, warrantyRepairProject, 2);
    private Engineer ghybyaEngineer = new Engineer(UUID.randomUUID().toString(), "Ghybya M.", "from Chernivtsi", LocalDateTime.now(),
            null, motorcycleRepairDepartment, wheelExchangeProject, 3);
    //just workers
    private Assistant voznyukAssistant = new Assistant(UUID.randomUUID().toString(), "Voznyuk K.", "helper", LocalDateTime.now(),
            null, motorcycleRepairDepartment, warrantyRepairProject, 4);
    private Designer vodyancukDesigner = new Designer(UUID.randomUUID().toString(), "Vodyanchuk V.", "from village", LocalDateTime.now(),
            null, carRepairDepartment, warrantyRepairProject, 5);
    private Equipment electropumpEquipment = new Equipment(UUID.randomUUID().toString(), "t-2000 electroppump", "", LocalDateTime.now(),
            null, motorcycleRepairDepartment, wheelExchangeProject);
    private Equipment diskRepairEquipment = new Equipment(UUID.randomUUID().toString(), "Disk repair tool ALFA-tau 3.0", "", LocalDateTime.now(),
            null, carRepairDepartment, warrantyRepairProject);
    private Technician morozTechnician = new Technician(UUID.randomUUID().toString(), "Moroz V.", "help to Max", LocalDateTime.now(), null,
            motorcycleRepairDepartment, wheelExchangeProject);//diskRepairEquipment, electropumpEquipment
    private Equipment electrojackEquipment = new Equipment(UUID.randomUUID().toString(), "Electrojack Braun 5645", "", LocalDateTime.now(),
            null, carRepairDepartment, warrantyRepairProject);
    private Technician andriichukTechnician = new Technician(UUID.randomUUID().toString(), "Andriichuk D.", "help to Max", LocalDateTime.now(), null,
            carRepairDepartment, warrantyRepairProject);//electrojackEquipment

    private List<AgreementHasAgreement> agreementHasAgreementList = new ArrayList<>(Arrays.asList(
            new AgreementHasAgreement(UUID.randomUUID().toString(), "name",
                    "description", LocalDateTime.now(), null,  withVolkswagenContract, warrantyRepairProject),
            new AgreementHasAgreement(UUID.randomUUID().toString(), "name",
                    "description", LocalDateTime.now(), null, withVolkswagenContract, wheelExchangeProject),
            new AgreementHasAgreement(UUID.randomUUID().toString(), "name",
                    "description", LocalDateTime.now(), null, withHondaContract, wheelExchangeProject)
    ));
    private List<TechnicianHasEquipment> technicianHasEquipmentsList = new ArrayList<>(Arrays.asList(
            new TechnicianHasEquipment(UUID.randomUUID().toString(), "", "",  LocalDateTime.now(),
                    null, andriichukTechnician, electrojackEquipment),
            new TechnicianHasEquipment(UUID.randomUUID().toString(), "", "",  LocalDateTime.now(), null, morozTechnician, diskRepairEquipment),
            new TechnicianHasEquipment(UUID.randomUUID().toString(),"", "", LocalDateTime.now(), null, morozTechnician, electropumpEquipment)));
    private List<LogHeadOfDepartment> logHeadOfDepartments = new ArrayList<>(Arrays.asList(
            new LogHeadOfDepartment(UUID.randomUUID().toString(), "name", "", LocalDateTime.now(),
                    null, LocalDateTime.of(2020, 1,1,0,0,0,0),
                    LocalDateTime.of(2020, 2,2,0,0,0,0),
                    baranovEngineer, carRepairDepartment),
            new LogHeadOfDepartment(UUID.randomUUID().toString(), "name", "", LocalDateTime.now(),
                    null, LocalDateTime.of(2020, 01,10,0,0,0,0),
                    null, rudyagaDesigner, motorcycleRepairDepartment)));
    private List<LogChiefOfTypeOfProject> logChiefOfTypeOfProjects = new ArrayList<>(Arrays.asList(
            new LogChiefOfTypeOfProject(UUID.randomUUID().toString(), "name", "", LocalDateTime.now(),
                    null, LocalDateTime.of(2020, 2,3,0,0,0,0),
                    null, withVolkswagenContract, baranovEngineer),
            new LogChiefOfTypeOfProject(UUID.randomUUID().toString(), "name", "", LocalDateTime.now(),
                    null, LocalDateTime.of(2019, 12,25,0,0,0,0),
                    null, warrantyRepairProject, batyevEngineer),
            new LogChiefOfTypeOfProject(UUID.randomUUID().toString(), "name", "", LocalDateTime.now(),
                    null, LocalDateTime.of(2020, 1,15,0,0,0,0),
                    null, withHondaContract, ghybyaEngineer),
            new LogChiefOfTypeOfProject(UUID.randomUUID().toString(), "name", "", LocalDateTime.now(),
                    null, LocalDateTime.of(2020, 2,3,0,0,0,0),
                    null, wheelExchangeProject, rudyagaDesigner)
    ));

    private List<Worker> workerList = new ArrayList<>(Arrays.asList(
            rudyagaDesigner,
            baranovEngineer,
            batyevEngineer,
            ghybyaEngineer,
            voznyukAssistant,
            vodyancukDesigner,
            morozTechnician,
            andriichukTechnician
    ));
    private List<TypeOfAgreement> typeOfAgreements = new ArrayList<>(Arrays.asList(
            withVolkswagenContract,
            withHondaContract,
            warrantyRepairProject,
            wheelExchangeProject
    ));
    private List<Organization> organizations = new ArrayList<>(Arrays.asList(
            continuumOrganization,
            bmxForLifeOrganization
    ));
    private List<Department> departments = new ArrayList<>(Arrays.asList(
            motorcycleRepairDepartment,
            carRepairDepartment
    ));
    private List<Equipment> equipments = new ArrayList<>(Arrays.asList(
            diskRepairEquipment,
            electrojackEquipment,
            electropumpEquipment
    ));

    public List<TypeOfAgreement> getTypeOfAgreements() {
        return typeOfAgreements;
    }

    public List<AgreementHasAgreement> getAgreementHasAgreementList() {
        return agreementHasAgreementList;
    }

    public List<Worker> getWorkerList() {
        return workerList;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public List<TechnicianHasEquipment> getTechnicianHasEquipmentsList() {
        return technicianHasEquipmentsList;
    }

    public List<LogHeadOfDepartment> getLogHeadOfDepartments() {
        return logHeadOfDepartments;
    }

    public List<LogChiefOfTypeOfProject> getLogChiefOfTypeOfProjects() {
        return logChiefOfTypeOfProjects;
    }
}
