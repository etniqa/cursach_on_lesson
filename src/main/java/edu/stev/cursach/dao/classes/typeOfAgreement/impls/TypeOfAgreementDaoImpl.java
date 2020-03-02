package edu.stev.cursach.dao.classes.typeOfAgreement.impls;

import edu.stev.cursach.dao.classes.typeOfAgreement.repository.TypeOfAgreementRepository;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.dataSet.DataSet;
import edu.stev.cursach.model.TypeOfAgreement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
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
    public TypeOfAgreement save(TypeOfAgreement element) {
        return null;
    }

    @Override
    public TypeOfAgreement get(String id) {
        return null;
    }

    @Override
    public List<TypeOfAgreement> getAll() {
        return this.dataSet.getTypeOfAgreements();
    }

    @Override
    public TypeOfAgreement edit(String id, TypeOfAgreement newElem) {
        return null;
    }

    @Override
    public TypeOfAgreement delete(String id) {
        return null;
    }
}
