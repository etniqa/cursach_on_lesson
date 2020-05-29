package edu.stev.cursach.dao.classes.logChiefOfTypeOfProject.impls;

import edu.stev.cursach.dao.classes.logChiefOfTypeOfProject.repository.LogChiefOfTypeOfProjectRepository;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.dataSet.DataSet;
import edu.stev.cursach.model.pojos.LogChiefOfTypeOfProject;
import edu.stev.cursach.service.classes.agreementHasAgreement.impls.AgreementHasAgreementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class LogChiefOfTypeOfProjectDaoImpl implements IDao<LogChiefOfTypeOfProject> {
    private Logger logger = Logger.getLogger(LogChiefOfTypeOfProjectDaoImpl.class.getName());

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
    LogChiefOfTypeOfProjectRepository repository;

    @PostConstruct
    void init(){
        repository.deleteAll();
        repository.saveAll(this.dataSet.getLogChiefOfTypeOfProjects());
    }

    @Override
    public MongoRepository getRepository() {
        return repository;
    }
}
