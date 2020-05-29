package edu.stev.cursach.service.classes.typeOfAgreement.impls;

import edu.stev.cursach.dao.classes.typeOfAgreement.impls.TypeOfAgreementDaoImpl;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.model.pojos.AgreementHasAgreement;
import edu.stev.cursach.model.pojos.Contract;
import edu.stev.cursach.model.pojos.Project;
import edu.stev.cursach.model.pojos.TypeOfAgreement;
import edu.stev.cursach.service.classes.agreementHasAgreement.impls.AgreementHasAgreementServiceImpl;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class TypeOfAgreementServiceImpl implements IService<TypeOfAgreement> {
    private Logger logger = Logger.getLogger(TypeOfAgreementServiceImpl.class.getName());

    @PostConstruct
    void initialize() {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        this.logger.addHandler(consoleHandler);
    }
    @Override
    public Logger getLogger() {
        return this.logger;
    }

    @Autowired
    TypeOfAgreementDaoImpl dao;

    @Autowired
    AgreementHasAgreementServiceImpl agreementHasAgreementService;

    @Override
    public IDao getDao() {
        return dao;
    }

    public List<TypeOfAgreement> getAgreementsInPeriod(LocalDate dateFrom, LocalDate dateTo) {
        return this.dao.getAll().stream().filter(agreem ->
                        dateFrom.compareTo(agreem.getDateBeg()) <= 0
                                && (agreem.getDateEnd() != null && agreem.getDateEnd().compareTo(dateTo) <= 0)
        ).collect(Collectors.toList());
    }


    public List<Contract> getContractsForOrg(String orgId) {
        return this.getAll().stream()
                .filter(agreem -> agreem instanceof Contract && agreem.getOrganizationWhichSign().getId().equals(orgId))
                .map(agreem -> (Contract) agreem)
                .collect(Collectors.toList());
    }

    public List<Contract> getContracts() {
        return dao.getAll().stream()
                .filter(agreem -> agreem instanceof Contract)
                .map(agreem -> (Contract) agreem)
                .collect(Collectors.toList());
    }

    public List<Project> getProjects() {
        return dao.getAll().stream()
                .filter(agreem -> agreem instanceof Project)
                .map(agreem -> (Project) agreem)
                .collect(Collectors.toList());
    }


    public List<Project> getProjectsForContract(String contractId) {
        return this.agreementHasAgreementService.getProjectsForContract(contractId);
    }

    public List<Project> deleteLigatureAndGetProjsForContract(String idContractDel, String idDeleteProj) {
        this.agreementHasAgreementService.deleteLigatureContrWithProjectAndGetAllForContract(idContractDel, idDeleteProj);
        return this.agreementHasAgreementService.getProjectsForContract(idContractDel);
    }

    private List<TypeOfAgreement> getCompletedAgreements() {
        return this.dao.getAll().stream().peek(elem -> System.out.println((elem.getDateEnd() == null ||
                elem.getDateEnd().isAfter(LocalDate.now())) + elem.toString()))
                .filter(agreem -> agreem.getDateEnd() != null &&
                        (agreem.getDateEnd().isBefore(LocalDate.now()) || agreem.getDateEnd().isEqual(LocalDate.now()))).collect(Collectors.toList());
    }

    public Pair<List<TypeOfAgreement>, Integer> calculateCostInPeriod(String dateFrom, String dateTo) {
        List<TypeOfAgreement> agreemsInPeriod = (dateFrom.equals("null") ? this.getCompletedAgreements() : this.getAgreementsInPeriod(LocalDate.parse(dateFrom), LocalDate.parse(dateTo)));
        return Pair.of(agreemsInPeriod, agreemsInPeriod.stream().mapToInt(TypeOfAgreement::getCost).sum());
    }

    public Pair<List<TypeOfAgreement>, Integer> getAgreementsAndcalculateCostOfSuborg(String idSuborg) {
        List<TypeOfAgreement> agreemsOfSuborg = this.getAll().stream().filter(agreem -> agreem.getOrganizationWhichSign().getId().equals(idSuborg)).collect(Collectors.toList());
        this.getAll().stream().filter(agreem -> agreem.getOrganizationWhichSign().getId().equals(idSuborg)).forEach(elem -> System.out.println(elem.toString()));
        return Pair.of(agreemsOfSuborg, agreemsOfSuborg.stream().mapToInt(TypeOfAgreement::getCost).sum());
    }
}
