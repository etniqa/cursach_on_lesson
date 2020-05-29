package edu.stev.cursach.controller.api.controllers;

import edu.stev.cursach.controller.api.cmnInterface.ICommonApiController;
import edu.stev.cursach.model.pojos.Contract;
import edu.stev.cursach.model.pojos.Project;
import edu.stev.cursach.model.pojos.TypeOfAgreement;
import edu.stev.cursach.service.classes.agreementHasAgreement.impls.AgreementHasAgreementServiceImpl;
import edu.stev.cursach.service.classes.typeOfAgreement.impls.TypeOfAgreementServiceImpl;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/type_of_agreement")
@CrossOrigin("*")
public class TypeOfAgreementApiController implements ICommonApiController<TypeOfAgreement> {
    @Autowired
    TypeOfAgreementServiceImpl typeOfAgreementService;

    @Autowired
    AgreementHasAgreementServiceImpl agreementHasAgreementService;

    @Override
    public IService getService() {
        return this.typeOfAgreementService;
    }
    private Logger logger = Logger.getLogger(TypeOfAgreementApiController.class.getName());

    @PostConstruct
    void initialize() {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        System.out.println(consoleHandler.getLevel());
        consoleHandler.setLevel(Level.ALL);
        System.out.println(consoleHandler.getLevel());
        this.logger.addHandler(consoleHandler);
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    @RequestMapping(value = "/get/projects", method = RequestMethod.GET)
    public List<Project> getProjects() {
        return this.typeOfAgreementService.getProjects();
    }

    @RequestMapping(value = "/get/contracts", method = RequestMethod.GET)
    public List<Contract> getContracts() {
        return this.typeOfAgreementService.getContracts();
    }

    @RequestMapping(value = "/get/in_period/{from}/{to}", method = RequestMethod.GET)
    public List<TypeOfAgreement> getAgreementsInPeriod(@PathVariable("from") String fromDateStr, @PathVariable("to") String toDateStr) {
        LocalDate fromDate = LocalDate.parse(fromDateStr);
        LocalDate toDate = LocalDate.parse(toDateStr);
        return this.typeOfAgreementService.getAgreementsInPeriod(fromDate, toDate);
    }

    @RequestMapping(value = "/add/{type}", method = RequestMethod.POST)
    TypeOfAgreement addAgreementWithType(@RequestBody TypeOfAgreement agreem,
                         @PathVariable("type") String type) {
        System.out.println(type);
        System.out.println(type.equals("project"));
        if (type.equals("project")) {
            System.out.println("creating new proj");
            Project newProj = new Project();
            BeanUtils.copyProperties(agreem, newProj);
            return (TypeOfAgreement) this.getService().save(newProj);
        } else {
            Contract newContract = new Contract();
            System.out.println("creating new contract");
            BeanUtils.copyProperties(agreem, newContract);
            return (TypeOfAgreement) this.getService().save(newContract);
        }
    }

    @RequestMapping(value = "/get/contracts_for_org/{orgId}", method = RequestMethod.GET)
    public List<Contract> getContractsForOrg(@PathVariable("orgId") String orgId) {
        return this.typeOfAgreementService.getContractsForOrg(orgId);
    }


    @RequestMapping(value = "/get/projects_for_contract/{contractId}", method = RequestMethod.GET)
    public List<Project> getProjsForContract(@PathVariable("contractId") String contractId) {
        return this.typeOfAgreementService.getProjectsForContract(contractId);
    }

    @RequestMapping(value = "/delete_ligature_contract_with_project_and_get_projects_for_contract/{idContractDel}/{idDeleteProj}", method = RequestMethod.DELETE)
    public List<Project> deleteObject(@PathVariable("idDeleteProj") String idDeleteProj,
                                 @PathVariable("idContractDel") String idContractDel) {
        return this.typeOfAgreementService.deleteLigatureAndGetProjsForContract(idContractDel, idDeleteProj );
    }

    @RequestMapping(value = "/get/calculate_cost/{dateFrom}/{dateTo}", method = RequestMethod.GET)
    public Pair<List<TypeOfAgreement>, Integer> calculateCostInPeriod(@PathVariable("dateFrom") String dateFrom,
                                                                      @PathVariable("dateTo") String dateTo) {
        return this.typeOfAgreementService.calculateCostInPeriod(dateFrom, dateTo);
    }

    @RequestMapping(value = "/get/from_suborganizations_of/{idSuborg}", method = RequestMethod.GET)
    public  Pair<List<TypeOfAgreement>, Integer> getAgreementsAndcalculateCostOfSuborg(@PathVariable("idSuborg") String idSuborg) {
        return this.typeOfAgreementService.getAgreementsAndcalculateCostOfSuborg(idSuborg);
    }
}
