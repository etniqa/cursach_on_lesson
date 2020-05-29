package edu.stev.cursach.service.classes.logOfChangesOfWorker.impls;

import edu.stev.cursach.dao.classes.logOfChangesOfWorker.impls.LogOfChangesOfWorkerDaoImpl;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.model.pojos.LogOfChangesOfEquipment;
import edu.stev.cursach.model.pojos.LogOfChangesOfWorker;
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
public class LogOfChangesOfWorkerServiceImpl implements IService<LogOfChangesOfWorker> {
    private Logger logger = Logger.getLogger(LogOfChangesOfWorkerServiceImpl.class.getName());

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
    LogOfChangesOfWorkerDaoImpl dao;

    @Override
    public IDao getDao() {
        return this.dao;
    }

    public LogOfChangesOfWorker save(LogOfChangesOfWorker newLastLogOfWorker) {//create
        LogOfChangesOfWorker lastLogOfThisWorker = this.getLastLogForPredictionByWorkerId(newLastLogOfWorker.getWorkerWhoChangeSmth().getId());
        lastLogOfThisWorker.setDateTimeBeforeNewChange(LocalDate.now());
        this.dao.edit(lastLogOfThisWorker);
        newLastLogOfWorker.setCreationDate(LocalDateTime.now());
        newLastLogOfWorker.setDateTimeOfChange(LocalDate.now());
        return this.dao.save(newLastLogOfWorker);
    }

    public List<LogOfChangesOfWorker> getInPeriod(String dateFrom, String dateTo) {
            return this.dao.getAll().stream().filter(log -> log.getDateTimeOfChange().compareTo(LocalDate.parse(dateFrom)) >= 0 &&
                    (log.getDateTimeBeforeNewChange() == null || log.getDateTimeBeforeNewChange().compareTo(LocalDate.parse(dateTo)) >= 0)).collect(Collectors.toList());
    }

    public LogOfChangesOfWorker getLastLogForPredictionByWorkerId(String workerId) {
        return this.dao.getAll().stream().filter(log -> log.getWorkerWhoChangeSmth().getId().equals(workerId) && log.getDateTimeBeforeNewChange() == null).findFirst().orElse(null);
    }
}
