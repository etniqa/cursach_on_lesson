package edu.stev.cursach.service.classes.agreementHasAgreement.impls;

import edu.stev.cursach.dao.classes.agreementHasAgreement.impls.AgreementHasAgreementDaoImpl;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.model.pojos.AgreementHasAgreement;
import edu.stev.cursach.model.pojos.Contract;
import edu.stev.cursach.model.pojos.Project;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class AgreementHasAgreementServiceImpl implements IService<AgreementHasAgreement> {
    private Logger logger = Logger.getLogger(AgreementHasAgreementServiceImpl.class.getName());

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
    AgreementHasAgreementDaoImpl dao;


    @Override
    public IDao getDao() {
        return dao;
    }

    @RequestMapping(value = "/delete_ligature_contr_and_proj/{idProjDel}/{idCOntractDel}", method = RequestMethod.DELETE)
    public List<AgreementHasAgreement> deleteLigatureContrWithProjectAndGetAllForContract(@PathVariable("idProjDel") String idProjDel,
                                                                                          @PathVariable("idCOntractDel") String idContractDel) {
        this.dao.deleteUsingContractAndProj(idProjDel, idContractDel);
        return this.dao.getAll();
    }

    public List<Project> getProjectsForContract(String contractId) {
        return this.dao.getAll().stream()
                .filter(agreementHasAgreement ->
                        agreementHasAgreement.getHeadAgreement() instanceof Contract &&
                                agreementHasAgreement.getHeadAgreement().getId().equals(contractId)
                )
                .map(agreementHasAgreement -> (Project) agreementHasAgreement.getOtherAgreement())
                .collect(Collectors.toList());
    }
}
