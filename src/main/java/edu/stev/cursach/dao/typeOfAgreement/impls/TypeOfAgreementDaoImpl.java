package edu.stev.cursach.dao.typeOfAgreement.impls;

import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.dataSet.DataSet;
import edu.stev.cursach.model.TypeOfAgreement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class TypeOfAgreementDaoImpl implements IDao<TypeOfAgreement> {
    @Autowired
    DataSet dataSet;

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
    public TypeOfAgreement edit(TypeOfAgreement element) {
        return null;
    }

    @Override
    public TypeOfAgreement delete(TypeOfAgreement element) {
        return null;
    }
}
