package edu.stev.cursach.dao.agreementBelongToAgreement.impls;

import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.dataSet.DataSet;
import edu.stev.cursach.model.AgreementBelongToAgreement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class AgreementBelongToAgreementDaoImplFake implements IDao<AgreementBelongToAgreement> {
    @Autowired
    DataSet dataSet;

    @Override
    public AgreementBelongToAgreement save(AgreementBelongToAgreement element) {
        return null;
    }

    @Override
    public AgreementBelongToAgreement get(String id) {
        return null;
    }

    @Override
    public List<AgreementBelongToAgreement> getAll() {
        return this.dataSet.getAgreementBelongToAgreementList();
    }

    @Override
    public AgreementBelongToAgreement edit(AgreementBelongToAgreement element) {
        return null;
    }

    @Override
    public AgreementBelongToAgreement delete(AgreementBelongToAgreement element) {
        return null;
    }
}
