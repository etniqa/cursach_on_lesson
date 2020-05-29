package edu.stev.cursach.dataSet;

import edu.stev.cursach.model.pojos.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
            "Department of motorcycle`s repair", "in Continuum", LocalDateTime.now(),
            null, continuumOrganization);//head  = Rudyaga
    private Department forCheckDepartment = new Department(UUID.randomUUID().toString(),
            "Head - Steve", "in Continuum", LocalDateTime.now(),
            null, continuumOrganization);//head  = Rudyaga
    private Department carRepairDepartment = new Department(UUID.randomUUID().toString(), "Department of car`s repair", "in Continuum",
            LocalDateTime.now(), null, continuumOrganization);//head = Baranov

    private Contract withVolkswagenContract = new Contract(UUID.randomUUID().toString(),
            "With Volkswagen", "", LocalDateTime.now(), null, LocalDate.parse("2019-01-01"),
            LocalDate.parse("2020-01-01"), continuumOrganization, 100); //head will be Baranov S.
    private Contract withHondaContract = new Contract(UUID.randomUUID().toString(), "with honda",
            "", LocalDateTime.now(), null, LocalDate.parse("2019-06-01"), LocalDate.parse("2020-01-01"), continuumOrganization,
            100);//chief will be Ghubya M.
    private Project warrantyRepairProject = new Project(UUID.randomUUID().toString(), "Warranty repair", "with Volkswagen", LocalDateTime.now(),
            null, LocalDate.parse("2020-01-01"), LocalDate.now(), continuumOrganization, 100);//chief - Batyev A.
    private Project wheelExchangeProject = new Project(UUID.randomUUID().toString(),
            "Happy wheel", "for Honda and Volkswagen", LocalDateTime.now(),
            null, LocalDate.now(), LocalDate.parse("2021-01-01"), continuumOrganization, 100);//chief - Rydyaga D.

    private Organization bmxForLifeOrganization = new Organization(UUID.randomUUID().toString(),
            "bmx for life", "in Continuum", LocalDateTime.now(),
            null, continuumOrganization);
    private Department bicycleDepartment = new Department(UUID.randomUUID().toString(),
            "Department of bicycle", "in Bmx For Life", LocalDateTime.now(),
            null, bmxForLifeOrganization);//head  = Tymofiichuk
    private Contract withSundayContract = new Contract(UUID.randomUUID().toString(), "with bmx Sunday brand",
            "in paint project", LocalDateTime.now(), null, LocalDate.now(), LocalDate.parse("2020-07-01"), bmxForLifeOrganization,
            100);//chief will be Tymofiichuk
    private Project paintProject = new Project(UUID.randomUUID().toString(),
            "rainbow", "", LocalDateTime.now(),
            null, LocalDate.now(), LocalDate.parse("2021-12-12"), bmxForLifeOrganization, 100);//chief - Tymofiichuk


    //equipments
    private Equipment electropumpEquipment = new Equipment(UUID.randomUUID().toString(), "t-2000 electroppump", "", LocalDateTime.now(),
            null, motorcycleRepairDepartment, wheelExchangeProject);
    private Equipment diskRepairEquipment = new Equipment(UUID.randomUUID().toString(), "Disk repair tool ALFA-tau 3.0", "", LocalDateTime.now(),
            null, carRepairDepartment, warrantyRepairProject);
    private Equipment electrojackEquipment = new Equipment(UUID.randomUUID().toString(), "Electrojack Braun 5645", "", LocalDateTime.now(),
            null, carRepairDepartment, warrantyRepairProject);
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

    private Engineer tymofEngineer = new Engineer(UUID.randomUUID().toString(), "Tymofiichuk N.", "from Chernivtsi", LocalDateTime.now(),
            null, bicycleDepartment, paintProject, 3);
    //just workers
    private Assistant voznyukAssistant = new Assistant(UUID.randomUUID().toString(), "Voznyuk K.", "helper", LocalDateTime.now(),
            null, motorcycleRepairDepartment, warrantyRepairProject, 70);
    private Designer vodyancukDesigner = new Designer(UUID.randomUUID().toString(), "Vodyanchuk V.", "from village", LocalDateTime.now(),
            null, carRepairDepartment, warrantyRepairProject, 5);
    private Technician morozTechnician = new Technician(UUID.randomUUID().toString(), "Moroz V.", "help to Max", LocalDateTime.now(), null,
            motorcycleRepairDepartment, wheelExchangeProject, 2);//diskRepairEquipment, electropumpEquipment
    private Technician andriichukTechnician = new Technician(UUID.randomUUID().toString(), "Andriichuk D.", "help to Max", LocalDateTime.now(), null,
            carRepairDepartment, warrantyRepairProject, 3);//electrojackEquipment

    private Staff popykStaff = new Staff(UUID.randomUUID().toString(), "Popyk M.", "staff", LocalDateTime.now(),
            null, bicycleDepartment, paintProject, 7);

    private List<AgreementHasAgreement> agreementHasAgreementList = new ArrayList<>(Arrays.asList(
            new AgreementHasAgreement(UUID.randomUUID().toString(), "name",
                    "description", LocalDateTime.now(), null, withVolkswagenContract, warrantyRepairProject),
            new AgreementHasAgreement(UUID.randomUUID().toString(), "name",
                    "description", LocalDateTime.now(), null, withVolkswagenContract, wheelExchangeProject),
            new AgreementHasAgreement(UUID.randomUUID().toString(), "name",
                    "description", LocalDateTime.now(), null, withHondaContract, wheelExchangeProject),
            new AgreementHasAgreement(UUID.randomUUID().toString(), "from bmx for life",
                    "", LocalDateTime.now(), null, paintProject, withSundayContract)
    ));

    private List<TechnicianHasEquipment> technicianHasEquipmentsList = new ArrayList<>(Arrays.asList(
            new TechnicianHasEquipment(UUID.randomUUID().toString(), "", "", LocalDateTime.now(),
                    null, andriichukTechnician, electrojackEquipment),
            new TechnicianHasEquipment(UUID.randomUUID().toString(), "", "", LocalDateTime.now(), null, morozTechnician, diskRepairEquipment),
            new TechnicianHasEquipment(UUID.randomUUID().toString(), "", "", LocalDateTime.now(), null, morozTechnician, electropumpEquipment)));
    private List<LogHeadOfDepartment> logHeadOfDepartments = new ArrayList<>(Arrays.asList(
            new LogHeadOfDepartment(UUID.randomUUID().toString(), "name", "", LocalDateTime.now(),
                    null, LocalDate.of(2020, 1, 1),
                    null,
                    baranovEngineer, carRepairDepartment),
            new LogHeadOfDepartment(UUID.randomUUID().toString(), "name", "", LocalDateTime.now(),
                    null, LocalDate.of(2020, 1, 1),
                    null,
                    baranovEngineer, forCheckDepartment),
            new LogHeadOfDepartment(UUID.randomUUID().toString(), "name", "", LocalDateTime.now(),
                    null, LocalDate.of(2020, 1, 10),
                    null, rudyagaDesigner, motorcycleRepairDepartment),
            new LogHeadOfDepartment(UUID.randomUUID().toString(), "", "from bmx for life", LocalDateTime.now(),
                    null, LocalDate.of(2020, 01, 10),
                    null, tymofEngineer, bicycleDepartment)));
    private List<LogChiefOfTypeOfProject> logChiefOfTypeOfProjects = new ArrayList<>(Arrays.asList(
            new LogChiefOfTypeOfProject(UUID.randomUUID().toString(), "name", "", LocalDateTime.now(),
                    null, LocalDate.of(2020, 2, 3),
                    null, withVolkswagenContract, baranovEngineer),
            new LogChiefOfTypeOfProject(UUID.randomUUID().toString(), "name", "", LocalDateTime.now(),
                    null, LocalDate.of(2019, 12, 25),
                    null, warrantyRepairProject, batyevEngineer),
            new LogChiefOfTypeOfProject(UUID.randomUUID().toString(), "name", "", LocalDateTime.now(),
                    null, LocalDate.of(2020, 1, 15),
                    null, withHondaContract, ghybyaEngineer),
            new LogChiefOfTypeOfProject(UUID.randomUUID().toString(), "name", "", LocalDateTime.now(),
                    null, LocalDate.of(2020, 2, 3),
                    null, wheelExchangeProject, rudyagaDesigner),
            new LogChiefOfTypeOfProject(UUID.randomUUID().toString(), "name", "", LocalDateTime.now(),
                    null, LocalDate.of(2020, 2, 3),
                    null, paintProject, tymofEngineer)
    ));
    private List<LogOfChangesOfWorker> logOfChangesOfWorkerList = new ArrayList<>(Arrays.asList(
            new LogOfChangesOfWorker(UUID.randomUUID().toString(), "getting on job", LocalDateTime.of(LocalDate.parse("2018-01-01"), LocalTime.MIN),
                    null, rudyagaDesigner, motorcycleRepairDepartment, null, LocalDate.parse("2018-01-01"), LocalDate.parse("2020-05-24")),
            new LogOfChangesOfWorker(UUID.randomUUID().toString(), "getting on job",LocalDateTime.of(LocalDate.parse("2018-01-01"), LocalTime.MIN),
                    null, baranovEngineer, carRepairDepartment, null, LocalDate.parse("2018-01-01"), LocalDate.parse("2020-05-24")),
            new LogOfChangesOfWorker(UUID.randomUUID().toString(), "getting on job", LocalDateTime.of(LocalDate.parse("2018-01-01"), LocalTime.MIN),
                    null, batyevEngineer, carRepairDepartment, null, LocalDate.parse("2018-01-01"), LocalDate.parse("2020-01-01")),
            new LogOfChangesOfWorker(UUID.randomUUID().toString(), "getting on job", LocalDateTime.of(LocalDate.parse("2018-01-01"), LocalTime.MIN),
                    null, ghybyaEngineer, motorcycleRepairDepartment, null, LocalDate.parse("2018-01-01"), LocalDate.parse("2020-05-24")),
            new LogOfChangesOfWorker(UUID.randomUUID().toString(), "getting on job", LocalDateTime.of(LocalDate.parse("2018-01-01"), LocalTime.MIN),
                    null, voznyukAssistant, motorcycleRepairDepartment, null, LocalDate.parse("2018-01-01"), LocalDate.parse("2020-01-01")),
            new LogOfChangesOfWorker(UUID.randomUUID().toString(), "getting on job", LocalDateTime.of(LocalDate.parse("2018-01-01"), LocalTime.MIN),
                    null, vodyancukDesigner, carRepairDepartment, null, LocalDate.parse("2018-01-01"), this.warrantyRepairProject.getDateBeg()),
            new LogOfChangesOfWorker(UUID.randomUUID().toString(), "getting on job", LocalDateTime.of(LocalDate.parse("2018-01-01"), LocalTime.MIN),
                    null, morozTechnician, motorcycleRepairDepartment, null, LocalDate.parse("2018-01-01"), this.wheelExchangeProject.getDateBeg()),
            new LogOfChangesOfWorker(UUID.randomUUID().toString(), "getting on job", LocalDateTime.of(LocalDate.parse("2018-01-01"), LocalTime.MIN),
                    null, andriichukTechnician, carRepairDepartment, null, LocalDate.parse("2018-01-01"), this.warrantyRepairProject.getDateBeg()),
            new LogOfChangesOfWorker(UUID.randomUUID().toString(), "getting on job", LocalDateTime.of(LocalDate.parse("2018-01-01"), LocalTime.MIN),
                    null, tymofEngineer, bicycleDepartment, null, LocalDate.parse("2018-01-01"), this.paintProject.getDateBeg()),

            new LogOfChangesOfWorker(UUID.randomUUID().toString(), null, this.wheelExchangeProject.getDateBeg().atStartOfDay(),
                    null, rudyagaDesigner, motorcycleRepairDepartment, this.wheelExchangeProject, this.wheelExchangeProject.getDateBeg(), null),
            new LogOfChangesOfWorker(UUID.randomUUID().toString(), null, this.wheelExchangeProject.getDateBeg().atStartOfDay(),
                    null, baranovEngineer, carRepairDepartment, this.wheelExchangeProject, this.wheelExchangeProject.getDateBeg(), null),
            new LogOfChangesOfWorker(UUID.randomUUID().toString(), null, this.warrantyRepairProject.getDateBeg().atStartOfDay(),
                    null, batyevEngineer, carRepairDepartment, this.warrantyRepairProject, this.warrantyRepairProject.getDateBeg(), null),
            new LogOfChangesOfWorker(UUID.randomUUID().toString(), null, this.wheelExchangeProject.getDateBeg().atStartOfDay(),
                    null, ghybyaEngineer, motorcycleRepairDepartment, this.wheelExchangeProject, this.wheelExchangeProject.getDateBeg(), null),
            new LogOfChangesOfWorker(UUID.randomUUID().toString(), null, this.warrantyRepairProject.getDateBeg().atStartOfDay(),
                    null, voznyukAssistant, motorcycleRepairDepartment, this.warrantyRepairProject, this.warrantyRepairProject.getDateBeg(), null),
            new LogOfChangesOfWorker(UUID.randomUUID().toString(), null, this.warrantyRepairProject.getDateBeg().atStartOfDay(),
                    null, vodyancukDesigner, carRepairDepartment, this.warrantyRepairProject, this.warrantyRepairProject.getDateBeg(), null),
            new LogOfChangesOfWorker(UUID.randomUUID().toString(), null, this.wheelExchangeProject.getDateBeg().atStartOfDay(),
                    null, morozTechnician, motorcycleRepairDepartment, this.wheelExchangeProject, this.wheelExchangeProject.getDateBeg(), null),
            new LogOfChangesOfWorker(UUID.randomUUID().toString(), null,this.warrantyRepairProject.getDateBeg().atStartOfDay(),
                    null, andriichukTechnician, carRepairDepartment, this.warrantyRepairProject, this.warrantyRepairProject.getDateBeg(), null),
            new LogOfChangesOfWorker(UUID.randomUUID().toString(), null, this.paintProject.getDateBeg().atStartOfDay(),
                    null, tymofEngineer, bicycleDepartment, this.paintProject, this.paintProject.getDateBeg(), null)
            ));

    public List<LogOfChangesOfWorker> getLogOfChangesOfWorkerList() {
        return logOfChangesOfWorkerList;
    }

    public List<LogOfChangesOfEquipment> getLogOfChangesOfEquipments() {
        return logOfChangesOfEquipments;
    }

    private List<LogOfChangesOfEquipment> logOfChangesOfEquipments = new ArrayList<>(Arrays.asList(
            // get all equipments
            new LogOfChangesOfEquipment(UUID.randomUUID().toString(), "", "getting", LocalDateTime.now(),
                    null, electropumpEquipment, this.carRepairDepartment, null,
                    LocalDate.parse("2017-01-01"), LocalDate.parse("2020-01-01")),
            new LogOfChangesOfEquipment(UUID.randomUUID().toString(), "", "getting", LocalDateTime.now(),
                    null, electrojackEquipment, this.carRepairDepartment, null,
                    LocalDate.parse("2017-01-01"), LocalDate.parse("2020-01-01")),
            new LogOfChangesOfEquipment(UUID.randomUUID().toString(), "", "getting", LocalDateTime.now(),
                    null, diskRepairEquipment, this.carRepairDepartment, null,
                    LocalDate.parse("2017-01-01"), LocalDate.parse("2019-01-01")),

            new LogOfChangesOfEquipment(UUID.randomUUID().toString(), "", "between departments", LocalDateTime.now(),
                    null, electrojackEquipment, null, warrantyRepairProject,
                    LocalDate.parse("2019-01-01"), LocalDate.parse("2020-01-01")),

            new LogOfChangesOfEquipment(UUID.randomUUID().toString(), "", "", LocalDateTime.now(),
                    null, diskRepairEquipment, null, wheelExchangeProject,
                    LocalDate.parse("2020-01-01"), null),
            new LogOfChangesOfEquipment(UUID.randomUUID().toString(), "", "", LocalDateTime.now(),
                    null, electropumpEquipment, null, wheelExchangeProject,
                    LocalDate.parse("2020-01-01"), null),
            new LogOfChangesOfEquipment(UUID.randomUUID().toString(), "", "", LocalDateTime.now(),
                    null, electrojackEquipment, null, warrantyRepairProject,
                    LocalDate.parse("2020-01-01"), null)
    ));

    private List<Worker> workerList = new ArrayList<>(Arrays.asList(
            rudyagaDesigner,
            baranovEngineer,
            batyevEngineer,
            ghybyaEngineer,
            voznyukAssistant,
            vodyancukDesigner,
            morozTechnician,
            andriichukTechnician,
            tymofEngineer
    ));
    private List<TypeOfAgreement> typeOfAgreements = new ArrayList<>(Arrays.asList(
            withVolkswagenContract,
            withHondaContract,
            warrantyRepairProject,
            wheelExchangeProject,
            withSundayContract,
            paintProject
    ));
    private List<Organization> organizations = new ArrayList<>(Arrays.asList(
            continuumOrganization,
            bmxForLifeOrganization
    ));
    private List<Department> departments = new ArrayList<>(Arrays.asList(
            motorcycleRepairDepartment,
            carRepairDepartment,
            bicycleDepartment,
            forCheckDepartment
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
