package edu.stev.cursach.dao.classes.agreementHasAgreement.impls;

import edu.stev.cursach.dao.classes.agreementHasAgreement.repository.AgreementHasAgreementRepository;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.dataSet.DataSet;
import edu.stev.cursach.model.pojos.AgreementHasAgreement;
import edu.stev.cursach.service.classes.agreementHasAgreement.impls.AgreementHasAgreementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class AgreementHasAgreementDaoImpl implements IDao<AgreementHasAgreement> {
    private Logger logger = Logger.getLogger(AgreementHasAgreementDaoImpl.class.getName());

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
    DataSet dataSet; // connected to lists to set default values in DB

    @Autowired
    AgreementHasAgreementRepository repository;

    @Override
    public MongoRepository getRepository() {
        return repository;
    }

    @PostConstruct
    void init(){
        repository.deleteAll();
        repository.saveAll(this.dataSet.getAgreementHasAgreementList());
    }

    public void deleteUsingContractAndProj(String idContractDel, String idProjDel) {
        AgreementHasAgreement deleteLigature = this.repository.findAll().stream()
                .peek(agreementHasAgreement -> {
                    System.out.println(agreementHasAgreement.getHeadAgreement().getId());
                    System.out.println(agreementHasAgreement.getOtherAgreement().getId());
                    System.out.println(idContractDel);
                })
                .filter(agreementHasAgreement -> agreementHasAgreement.getHeadAgreement().getId().equals(idContractDel) &&
                        agreementHasAgreement.getOtherAgreement().getId().equals(idProjDel)).findFirst().orElse(null);
        if (deleteLigature != null) {
            System.out.println(deleteLigature.toString());
            this.repository.deleteById(deleteLigature.getId());
        } else {
            System.out.println("exception: there is no ligature in repository");
        }
    }
}
