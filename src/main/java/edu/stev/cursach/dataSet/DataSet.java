package edu.stev.cursach.dataSet;

import edu.stev.cursach.model.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Component
public class DataSet {
    private Organization continuumOrganization = new Organization("Continuum", "from Chernivtsi. There is no head organization", LocalDateTime.now(),
            null, null);
    private Department motorcycleRepairDepartment = new Department("Department of bike`s repair", "in Continuum", LocalDateTime.now(),
            null, continuumOrganization, null);
    private Department carRepairDepartment = new Department("Department of car`s repair", "in Continuum",
            LocalDateTime.now(), null, continuumOrganization, null);
    private Contract withVolkswagenContract = new Contract("With Volkswagen", "in car`s repair", LocalDateTime.now(),
            null, LocalDateTime.now(), null, null, continuumOrganization); //leader will be Baranov S.
    private Contract withHondaContract = new Contract("With Honda", "in bike`s repair", LocalDateTime.now(),
            null, LocalDateTime.now(), null, null, continuumOrganization);//leader will be Ghubya M.
    private Project warrantyRepairProject = new Project("Warranty repair", "with Volkswagen", LocalDateTime.now(),
            null, LocalDateTime.now(), null, null, continuumOrganization);//leader - Batyev A.
    private Project wheelExchangeProject = new Project("Happy wheel", "for Honda and Volkswagen", LocalDateTime.now(),
            null, LocalDateTime.now(), null, null, continuumOrganization);//leader - Rydyaga D.
    private Organization bmxForLifeOrganization = new Organization("bmx for life", "in Continuum", LocalDateTime.now(),
            null, continuumOrganization);
    //workers
    //leaders
    private Designer rydyagaDesigner = new Designer("Rudyaga D.", "from Chernivtsi", LocalDateTime.now(),
            null, motorcycleRepairDepartment, wheelExchangeProject, 3);
    private Engineer baranovEngineer = new Engineer("Baranov S.", "from Novosnistrovsk", LocalDateTime.now(),
            null, carRepairDepartment, wheelExchangeProject);
    private Engineer batyevEngineer = new Engineer("Batyeb A.", "from Chernivtsi", LocalDateTime.now(),
            null, carRepairDepartment, warrantyRepairProject);
    private Engineer ghybyaEngineer = new Engineer("Ghybya M.", "from Chernivtsi", LocalDateTime.now(),
            null, motorcycleRepairDepartment, wheelExchangeProject);
    //just workers
    private Assistant voznyukAssistant = new Assistant("Voznyuk K.", "helper", LocalDateTime.now(),
            null, motorcycleRepairDepartment, warrantyRepairProject);
    private Designer vodyancukDesigner = new Designer("Vodyanchuk V.", "from village", LocalDateTime.now(),
            null, carRepairDepartment, warrantyRepairProject, 5);
    private Equipment electropumpEquipment = new Equipment("t-2000 electroppump", "", LocalDateTime.now(),
            null, motorcycleRepairDepartment, wheelExchangeProject);
    private Equipment diskRepairEquipment = new Equipment("Disk repair tool ALFA-tau 3.0", "", LocalDateTime.now(),
            null, carRepairDepartment, warrantyRepairProject);
    private Technician morozTechnician = new Technician("Moroz V.", "help to Max", LocalDateTime.now(), null,
            motorcycleRepairDepartment, wheelExchangeProject, diskRepairEquipment, electropumpEquipment);
    private Equipment electrojackEquipment = new Equipment("Electrojack Braun 5645", "", LocalDateTime.now(),
            null, carRepairDepartment, warrantyRepairProject);
    private Technician andriichukTechnician = new Technician("Andriichuk D.", "help to Max", LocalDateTime.now(), null,
            carRepairDepartment, warrantyRepairProject, electrojackEquipment);

    private List<AgreementBelongToAgreement> agreementBelongToAgreementList = Arrays.asList(
            new AgreementBelongToAgreement(warrantyRepairProject, withVolkswagenContract),
            new AgreementBelongToAgreement(wheelExchangeProject, withVolkswagenContract),
            new AgreementBelongToAgreement(wheelExchangeProject, withHondaContract)
    );
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

    public List<TypeOfAgreement> getTypeOfAgreements() {
        return typeOfAgreements;
    }

    public List<AgreementBelongToAgreement> getAgreementBelongToAgreementList() {
        return agreementBelongToAgreementList;
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
}
