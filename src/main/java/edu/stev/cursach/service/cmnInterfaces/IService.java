package edu.stev.cursach.service.cmnInterfaces;

import edu.stev.cursach.dao.classes.agreementHasAgreement.impls.AgreementHasAgreementDaoImpl;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.model.AgreementHasAgreement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//declaration 5 meths of CRUD
public interface IService<T> {
//    IDao getDao();

    T save(T element); //create
    T get(String id);
//    default T get(String id){
//        System.out.println(getDao().get(id));
//        return (T) getDao().get(id);
//    } //read
    List<T> getAll();
    T edit(T element); //update
    T delete(String id); //delete


}
