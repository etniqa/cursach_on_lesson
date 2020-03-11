package edu.stev.cursach.service.classes.agreementHasAgreement.impls;

import edu.stev.cursach.dao.classes.agreementHasAgreement.impls.AgreementHasAgreementDaoImpl;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.model.pojos.AgreementHasAgreement;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgreementHasAgreementServiceImpl implements IService<AgreementHasAgreement> {
    @Autowired
    AgreementHasAgreementDaoImpl dao;

    @Override
    public IDao getDao() {
        return dao;
    }

    @Override
    public AgreementHasAgreement edit(AgreementHasAgreement element) {
        return null;
    }
}
