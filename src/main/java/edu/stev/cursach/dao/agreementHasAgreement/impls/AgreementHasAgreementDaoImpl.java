package edu.stev.cursach.dao.agreementHasAgreement.impls;

import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.dataSet.DataSet;
import edu.stev.cursach.model.AgreementHasAgreement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class AgreementHasAgreementDaoImpl implements IDao<AgreementHasAgreement> {
    @Autowired
    DataSet dataSet;

    @Override
    public AgreementHasAgreement save(AgreementHasAgreement element) {
        return null;
    }

    @Override
    public AgreementHasAgreement get(String id) {
        return null;
    }

    @Override
    public List<AgreementHasAgreement> getAll() {
        return this.dataSet.getAgreementHasAgreementList();
    }

    @Override
    public AgreementHasAgreement edit(AgreementHasAgreement element) {
        return null;
    }

    @Override
    public AgreementHasAgreement delete(AgreementHasAgreement element) {
        return null;
    }
}
