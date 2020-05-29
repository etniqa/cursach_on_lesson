package edu.stev.cursach.dao.classes.department.impls;

import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.dao.classes.department.repository.DepartmentRepository;
import edu.stev.cursach.dataSet.DataSet;
import edu.stev.cursach.model.pojos.Department;
import edu.stev.cursach.service.classes.agreementHasAgreement.impls.AgreementHasAgreementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class DepartmentDaoImpl implements IDao<Department> {
    private Logger logger = Logger.getLogger(DepartmentDaoImpl.class.getName());

    @PostConstruct
    void initialize() {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        this.logger.addHandler(consoleHandler);
    }
    @Override
    public Logger getLogger() {
        return this.logger;
    }
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
