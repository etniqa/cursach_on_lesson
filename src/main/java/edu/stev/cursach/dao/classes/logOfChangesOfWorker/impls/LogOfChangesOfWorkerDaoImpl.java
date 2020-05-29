package edu.stev.cursach.dao.classes.logOfChangesOfWorker.impls;

import edu.stev.cursach.dao.classes.logOfChangesOfWorker.repository.LogOfChangesOfWorkerRepository;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.dataSet.DataSet;
import edu.stev.cursach.model.pojos.LogOfChangesOfWorker;
import edu.stev.cursach.service.classes.agreementHasAgreement.impls.AgreementHasAgreementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class LogOfChangesOfWorkerDaoImpl implements IDao<LogOfChangesOfWorker> {
    private Logger logger = Logger.getLogger(LogOfChangesOfWorkerDaoImpl.class.getName());

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
    LogOfChangesOfWorkerRepository repository;

    @PostConstruct
    void init(){
        this.repository.deleteAll();
        this.repository.saveAll(this.dataSet.getLogOfChangesOfWorkerList());
    }

    @Override
    public MongoRepository getRepository() {
        return repository;
    }

    @Override
    public List<LogOfChangesOfWorker> getAll() {
        System.out.println("Get all in dao");
        return this.repository.findAll();
    }
}