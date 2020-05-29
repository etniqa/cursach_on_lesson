package edu.stev.cursach.dao.classes.typeOfAgreement.impls;

import edu.stev.cursach.dao.classes.typeOfAgreement.repository.TypeOfAgreementRepository;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.dataSet.DataSet;
import edu.stev.cursach.model.pojos.TypeOfAgreement;
import edu.stev.cursach.service.classes.agreementHasAgreement.impls.AgreementHasAgreementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class TypeOfAgreementDaoImpl implements IDao<TypeOfAgreement> {
    private Logger logger = Logger.getLogger(TypeOfAgreementDaoImpl.class.getName());

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
    TypeOfAgreementRepository repository;

    @PostConstruct
    void init() {
        repository.deleteAll();
        this.repository.saveAll(this.dataSet.getTypeOfAgreements());
    }

    @Override
    public MongoRepository getRepository() {
        return repository;
    }
}
