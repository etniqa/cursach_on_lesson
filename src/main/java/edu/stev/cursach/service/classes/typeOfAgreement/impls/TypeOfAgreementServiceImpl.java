package edu.stev.cursach.service.classes.typeOfAgreement.impls;

import edu.stev.cursach.dao.classes.typeOfAgreement.impls.TypeOfAgreementDaoImpl;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.model.classes.TypeOfAgreement;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeOfAgreementServiceImpl implements IService<TypeOfAgreement> {
    @Autowired
    TypeOfAgreementDaoImpl dao;
    @Override
    public IDao getDao() {
        return this.dao;
    }

    @Override
    public TypeOfAgreement edit(TypeOfAgreement element) {
        return null;
    }
    //    @Override
//    public TypeOfAgreement save(TypeOfAgreement element) {
//        return null;
//    }
//
//    @Override
//    public TypeOfAgreement get(String id) {
//        return null;
//    }
//
//    @Override
//    public List<TypeOfAgreement> getAll() {
//        return dao.getAll();
//    }
//
//    @Override
//    public TypeOfAgreement edit(TypeOfAgreement element) {
//        return null;
//    }
//
//    @Override
//    public TypeOfAgreement delete(String id) {
//        return dao.delete(id);
//    }
}
