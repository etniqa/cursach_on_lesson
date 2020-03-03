package edu.stev.cursach.service.classes.typeOfAgreement.impls;

import edu.stev.cursach.dao.classes.typeOfAgreement.impls.TypeOfAgreementDaoImpl;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.model.TypeOfAgreement;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfAgreementServiceImpl implements IService<TypeOfAgreement> {
    @Autowired
    TypeOfAgreementDaoImpl dao;

    @Override
    public IDao getDao() {
        return dao;
    }

    @Override
    public TypeOfAgreement edit(TypeOfAgreement element) {
        return null;
    }
}
