package edu.stev.cursach.service.cmnInterfaces;

import edu.stev.cursach.dao.classes.agreementHasAgreement.impls.AgreementHasAgreementDaoImpl;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.model.AgreementHasAgreement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//declaration 5 meths of CRUD
public interface IService<T> {
    IDao getDao();

    default T save(T element){
        return (T) getDao().save(element);
    } //create
    default T get(String id){
        return (T) getDao().get(id);
    } //read
    default List<T> getAll(){
        return getDao().getAll();
    }
    T edit(T element); //update
    default T delete(String id){
        System.out.println("delete call");
        return (T) getDao().delete(id);
    } //delete


}
