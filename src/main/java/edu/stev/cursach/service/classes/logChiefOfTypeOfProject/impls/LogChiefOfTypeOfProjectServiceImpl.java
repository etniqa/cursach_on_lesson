package edu.stev.cursach.service.classes.logChiefOfTypeOfProject.impls;

import edu.stev.cursach.dao.classes.logChiefOfTypeOfProject.impls.LogChiefOfTypeOfProjectDaoImpl;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.model.pojos.LogChiefOfTypeOfProject;
import edu.stev.cursach.model.pojos.LogOfChangesOfEquipment;
import edu.stev.cursach.service.classes.agreementHasAgreement.impls.AgreementHasAgreementServiceImpl;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class LogChiefOfTypeOfProjectServiceImpl implements IService<LogChiefOfTypeOfProject> {
    private Logger logger = Logger.getLogger(LogChiefOfTypeOfProjectServiceImpl.class.getName());

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
    LogChiefOfTypeOfProjectDaoImpl dao;

    @Override
    public IDao getDao() {
        return dao;
    }

    public LogChiefOfTypeOfProject save(LogChiefOfTypeOfProject newLastLogChief) {//create
        LogChiefOfTypeOfProject lastLogChief = this.getLastLogForAgreem(newLastLogChief.getAgreement().getId());
        lastLogChief.setEndDate(LocalDate.now());
        this.dao.edit(lastLogChief);
        newLastLogChief.setCreationDate(LocalDateTime.now());
        newLastLogChief.setBegDate(LocalDate.now());
        return this.dao.save(newLastLogChief);
    }

    public List<LogChiefOfTypeOfProject> getListOfActiveChiefs() {
        return this.dao.getAll().stream().filter(log -> log.getEndDate() == null).collect(Collectors.toList());
    }

    public LogChiefOfTypeOfProject getLastLogForAgreem(String agreemId) {
        return this.dao.getAll().stream().filter(log -> log.getAgreement().getId().equals(agreemId)).findFirst().orElse(null);
    }
}
