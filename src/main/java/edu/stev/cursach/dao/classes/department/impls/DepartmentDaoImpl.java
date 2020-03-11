package edu.stev.cursach.dao.classes.department.impls;

import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.dao.classes.department.repository.DepartmentRepository;
import edu.stev.cursach.dataSet.DataSet;
import edu.stev.cursach.model.pojos.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DepartmentDaoImpl implements IDao<Department> {
    @Autowired
    DataSet dataSet;
    @Autowired
    DepartmentRepository repository;

    @PostConstruct
    void init(){
        repository.deleteAll();
        repository.saveAll(dataSet.getDepartments());//create table
    }

    @Override
    public MongoRepository getRepository() {
        return repository;
    }
}
