package edu.stev.cursach.dataSet;

import edu.stev.cursach.model.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
public class DataSet {
    private boolean wasInit = false;
    private Organization continuumOrganization = new Organization(UUID.randomUUID().toString(),
            "Continuum", "from Chernivtsi. There is no head organization", LocalDateTime.now(),
            null, null);
    private Department motorcycleRepairDepartment = new Department(UUID.randomUUID().toString(),
            "Department of bike`s repair", "in Continuum", LocalDateTime.now(),
            null, continuumOrganization, null);//head  = Rudyaga
    private Department carRepairDepartment = new Department(UUID.randomUUID().toString(), "Department of car`s repair", "in Continuum",
            LocalDateTime.now(), null, continuumOrganization, null);//head = Baranov
    private Contract withVolkswagenContract = new Contract(UUID.randomUUID().toString(),
            "With Volkswagen", "in car`s repair", LocalDateTime.now(), null, LocalDateTime.now(),
            null, null, continuumOrganization, 0); //head will be Baranov S.
    private Contract withHondaContract = new Contract(UUID.randomUUID().toString(), "with honda",
    "in bike`s repair", LocalDateTime.now(), null, LocalDateTime.now(), null, null, continuumOrganization,
            0);//chief will be Ghubya M.
    private Project warrantyRepairProject = new Project(UUID.randomUUID().toString(), "Warranty repair", "with Volkswagen", LocalDateTime.now(),
            null, LocalDateTime.now(), null, null, continuumOrganization, 0);//chief - Batyev A.
    private Project wheelExchangeProject = new Project(UUID.randomUUID().toString(),
            "Happy wheel", "for Honda and Volkswagen", LocalDateTime.now(),
            null, LocalDateTime.now(), null, null, continuumOrganization, 0);//chief - Rydyaga D.
    private Organization bmxForLifeOrganization = new Organization(UUID.randomUUID().toString(),
            "bmx for life", "in Continuum", LocalDateTime.now(),
            null, continuumOrganization);
    //workers
    //leaders
    private Designer rydyagaDesigner = new Designer(UUID.randomUUID().toString(), "Rudyaga D.", "from Chernivtsi", LocalDateTime.now(),
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
                    "description", LocalDateTime.now(), null,  warrantyRepairProject, withVolkswagenContract),
            new AgreementHasAgreement(UUID.randomUUID().toString(), "name",
                    "description", LocalDateTime.now(), null,wheelExchangeProject, withVolkswagenContract),
            new AgreementHasAgreement(UUID.randomUUID().toString(), "name",
                    "description", LocalDateTime.now(), null,wheelExchangeProject, withHondaContract)
    ));
    private List<TechnicianHasEquipment> technicianHasEquipmentsList = new ArrayList<>(Arrays.asList(
            new TechnicianHasEquipment(UUID.randomUUID().toString(), andriichukTechnician, electrojackEquipment),
            new TechnicianHasEquipment(UUID.randomUUID().toString(), morozTechnician, diskRepairEquipment),
            new TechnicianHasEquipment(UUID.randomUUID().toString(), morozTechnician, electropumpEquipment)));
    private List<Worker> workerList = Arrays.asList(
            rydyagaDesigner,
            baranovEngineer,
            batyevEngineer,
            ghybyaEngineer,
            voznyukAssistant,
            vodyancukDesigner,
            morozTechnician,
            andriichukTechnician
            );
    private List<TypeOfAgreement> typeOfAgreements = Arrays.asList(
            withVolkswagenContract,
            withHondaContract,
            warrantyRepairProject,
            wheelExchangeProject
    );
    private List<Organization> organizations = Arrays.asList(
            continuumOrganization,
            bmxForLifeOrganization
    );
    private List<Department> departments = Arrays.asList(
            motorcycleRepairDepartment,
            carRepairDepartment
    );
    private List<Equipment> equipments = Arrays.asList(
            diskRepairEquipment,
            electrojackEquipment,
            electropumpEquipment
    );


    private void init() {
        if(this.wasInit){
            this.carRepairDepartment.setHeadOfDepartment(baranovEngineer);
            this.motorcycleRepairDepartment.setHeadOfDepartment(rydyagaDesigner);
            this.withVolkswagenContract.setChief(baranovEngineer);
            this.withHondaContract.setChief(ghybyaEngineer);
            this.warrantyRepairProject.setChief(batyevEngineer);
            this.wheelExchangeProject.setChief(rydyagaDesigner);
        }
    }

    public List<TypeOfAgreement> getTypeOfAgreements() {
        this.init();
        return typeOfAgreements;
    }

    public List<AgreementHasAgreement> getAgreementHasAgreementList() {
        this.init();
        return agreementHasAgreementList;
    }

    public List<Worker> getWorkerList() {
        this.init();
        return workerList;
    }

    public List<Organization> getOrganizations() {
        this.init();
        return organizations;
    }

    public List<Department> getDepartments() {
        this.init();
        return departments;
    }

    public List<Equipment> getEquipments() {
        this.init();
        return equipments;
    }

    public List<TechnicianHasEquipment> getTechnicianHasEquipmentsList() {
        return technicianHasEquipmentsList;
    }
}
