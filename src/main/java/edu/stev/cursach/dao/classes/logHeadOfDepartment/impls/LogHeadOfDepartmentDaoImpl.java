package edu.stev.cursach.dao.classes.logHeadOfDepartment.impls;

import edu.stev.cursach.dao.classes.logHeadOfDepartment.repository.LogHeadOfDepartmentRepository;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.dataSet.DataSet;
import edu.stev.cursach.model.pojos.LogHeadOfDepartment;
import edu.stev.cursach.service.classes.agreementHasAgreement.impls.AgreementHasAgreementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class LogHeadOfDepartmentDaoImpl implements IDao<LogHeadOfDepartment> {
    private Logger logger = Logger.getLogger(LogHeadOfDepartmentDaoImpl.class.getName());

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
    LogHeadOfDepartmentRepository repository;

    @PostConstruct
    void init(){
        this.repository.deleteAll();
        this.repository.saveAll(this.dataSet.getLogHeadOfDepartments());
    }

    @Override
    public MongoRepository getRepository() {
        return repository;
    }

}
