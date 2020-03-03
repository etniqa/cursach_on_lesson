package edu.stev.cursach.dao.classes.typeOfAgreement.impls;

import edu.stev.cursach.dao.classes.typeOfAgreement.repository.TypeOfAgreementRepository;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.dataSet.cmnInterfaces.IDataSet;
import edu.stev.cursach.dataSet.impls.TypeOfAgreementDataSet;
import edu.stev.cursach.dataSet.mainDataSet.DataSet;
import edu.stev.cursach.model.classes.TypeOfAgreement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
@Component
public class TypeOfAgreementDaoImpl implements IDao<TypeOfAgreement> {
    @Autowired
    TypeOfAgreementDataSet dataSet;

    @Override
    public IDataSet getDataSet() {
        return this.dataSet;
    }
    //    @PostConstruct
//    void init(){
//        repository.deleteAll();
//        this.repository.saveAll(this.dataSet.getTypeOfAgreements());
//    }

/*    @Override
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
        TypeOfAgreement whichNeedToDelete = this.get(id);
        this.dataSet.getTypeOfAgreements().remove(this.get(id));
        return whichNeedToDelete;
    }*/
}
