package edu.stev.cursach.service.agreementBelongToAgreement.impls;

import edu.stev.cursach.dao.agreementBelongToAgreement.impls.AgreementBelongToAgreementDaoImplFake;
import edu.stev.cursach.model.AgreementBelongToAgreement;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AgreementBelongToAgreementServiceImpl implements IService<AgreementBelongToAgreement> {
    @Autowired
    AgreementBelongToAgreementDaoImplFake dao;

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
        return this.dao.getAll();
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
