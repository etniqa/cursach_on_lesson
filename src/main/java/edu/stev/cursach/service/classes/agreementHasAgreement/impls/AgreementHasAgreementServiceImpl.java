package edu.stev.cursach.service.classes.agreementHasAgreement.impls;

import edu.stev.cursach.dao.classes.agreementHasAgreement.impls.AgreementHasAgreementDaoImpl;
import edu.stev.cursach.model.AgreementHasAgreement;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AgreementHasAgreementServiceImpl implements IService<AgreementHasAgreement> {
    @Autowired
    AgreementHasAgreementDaoImpl dao;

    @Override
    public AgreementHasAgreement save(AgreementHasAgreement element) {
        return null;
    }

    @Override
    public AgreementHasAgreement get(String id) {
        return null;
    }

//    @Override
//    public AgreementHasAgreement get(String id) {
//        return dao.get(id);
//    }

    @Override
    public List<AgreementHasAgreement> getAll() {
        return this.dao.getAll();
    }

    @Override
    public AgreementHasAgreement edit(AgreementHasAgreement element) {
        return null;
    }

    @Override
    public AgreementHasAgreement delete(String id) {
        return null;
    }

}
