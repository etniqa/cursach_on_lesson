package edu.stev.cursach.dao.classes.typeOfAgreement.impls;

import edu.stev.cursach.dao.classes.typeOfAgreement.repository.TypeOfAgreementRepository;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.dataSet.DataSet;
import edu.stev.cursach.model.classes.TypeOfAgreement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TypeOfAgreementDaoImpl implements IDao<TypeOfAgreement> {
    @Autowired
    DataSet dataSet;
    @Autowired
    TypeOfAgreementRepository repository;

    @PostConstruct
    void init(){
        repository.deleteAll();
        this.repository.saveAll(this.dataSet.getTypeOfAgreements());
    }

    @Override
    public MongoRepository getRepository() {
        return repository;
    }
}
