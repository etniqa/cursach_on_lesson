package edu.stev.cursach.service.classes.logOfChangesOfEquipment.impls;

import edu.stev.cursach.dao.classes.logOfChangesOfEquipment.impls.LogOfChangesOfEquipmentDaoImpl;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
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
public class LogOfChangesOfEquipmentServiceImpl implements IService<LogOfChangesOfEquipment> {
    private Logger logger = Logger.getLogger(LogOfChangesOfEquipmentServiceImpl.class.getName());

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
    LogOfChangesOfEquipmentDaoImpl logOfChangesOfEquipmentDao;

    @Override
    public IDao getDao() {
        return logOfChangesOfEquipmentDao;
    }

    public LogOfChangesOfEquipment getLastLogByEquipId(String equipId) {
        return this.getByEquipmentId(equipId).stream().filter(log -> log.getDateEndBeforeNewChange() == null).findFirst().orElse(null);
    }

    public List<LogOfChangesOfEquipment> getByEquipmentId(String equipId) {
        return this.getAll().stream().filter(log -> log.getEquipWhichChangeField().getId().equals(equipId)).collect(Collectors.toList());
    }

    public LogOfChangesOfEquipment save(LogOfChangesOfEquipment newLastLogOfEquip) {//create
        LogOfChangesOfEquipment lastLogOfThisEquip = this.getLastLogByEquipId(newLastLogOfEquip.getEquipWhichChangeField().getId());
        lastLogOfThisEquip.setDateEndBeforeNewChange(LocalDate.now());
        this.logOfChangesOfEquipmentDao.edit(lastLogOfThisEquip);
        newLastLogOfEquip.setCreationDate(LocalDateTime.now());
        newLastLogOfEquip.setDateBegAfterChange(LocalDate.now());
        return this.logOfChangesOfEquipmentDao.save(newLastLogOfEquip);
    }

    public LogOfChangesOfEquipment getLastLogForPredictionByEquipId(String equipId) {
        return this.getLastLogByEquipId(equipId);
    }

    public List<LogOfChangesOfEquipment> getInPeriod(String dateFrom, String dateTo) {
        return this.logOfChangesOfEquipmentDao.getAll().stream().filter(log -> log.getDateBegAfterChange().compareTo(LocalDate.parse(dateFrom)) >= 0 &&
                (log.getDateEndBeforeNewChange() == null || log.getDateEndBeforeNewChange().compareTo(LocalDate.parse(dateTo)) >= 0)).collect(Collectors.toList());
    }
}
