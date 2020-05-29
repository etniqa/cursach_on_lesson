package edu.stev.cursach.dao.classes.technicianHasEquipment.impls;

import edu.stev.cursach.dao.classes.technicianHasEquipment.repository.TechnicianHasEquipmentRepository;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.dataSet.DataSet;
import edu.stev.cursach.model.pojos.TechnicianHasEquipment;
import edu.stev.cursach.service.classes.agreementHasAgreement.impls.AgreementHasAgreementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class TechnicianHasEquipmentDaoImpl implements IDao<TechnicianHasEquipment> {
    private Logger logger = Logger.getLogger(TechnicianHasEquipmentDaoImpl.class.getName());

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
    TechnicianHasEquipmentRepository repository;

    @PostConstruct
    void init(){
        repository.deleteAll();
        this.repository.saveAll(this.dataSet.getTechnicianHasEquipmentsList());
    }

    @Override
    public MongoRepository getRepository() {
        return repository;
    }
}
