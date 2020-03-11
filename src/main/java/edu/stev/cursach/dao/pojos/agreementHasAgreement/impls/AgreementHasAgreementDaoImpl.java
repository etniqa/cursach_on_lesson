package edu.stev.cursach.dao.classes.agreementHasAgreement.impls;

import edu.stev.cursach.dao.classes.agreementHasAgreement.repository.AgreementHasAgreementRepository;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.dataSet.DataSet;
import edu.stev.cursach.model.classes.AgreementHasAgreement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class AgreementHasAgreementDaoImpl implements IDao<AgreementHasAgreement> {
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
}
