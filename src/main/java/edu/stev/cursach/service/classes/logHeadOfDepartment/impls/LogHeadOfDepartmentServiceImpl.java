package edu.stev.cursach.service.classes.logHeadOfDepartment.impls;

import edu.stev.cursach.dao.classes.logHeadOfDepartment.impls.LogHeadOfDepartmentDaoImpl;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.model.pojos.LogChiefOfTypeOfProject;
import edu.stev.cursach.model.pojos.LogHeadOfDepartment;
import edu.stev.cursach.model.pojos.LogOfChangesOfEquipment;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class LogHeadOfDepartmentServiceImpl implements IService<LogHeadOfDepartment> {
    private Logger logger = Logger.getLogger(LogHeadOfDepartmentServiceImpl.class.getName());

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
    LogHeadOfDepartmentDaoImpl dao;

    public LogHeadOfDepartment save(LogHeadOfDepartment newLastLogHeadOfDep) {//create
        LogHeadOfDepartment lastLogHeadOfDep = this.getLastForThisDepartment(newLastLogHeadOfDep.getDepartment().getId());
        lastLogHeadOfDep.setEndDate(LocalDate.now());
        this.dao.edit(lastLogHeadOfDep);
        newLastLogHeadOfDep.setCreationDate(LocalDateTime.now());
        newLastLogHeadOfDep.setBegDate(LocalDate.now());
        return this.dao.save(newLastLogHeadOfDep);
    }

    @Override
    public IDao getDao() {
        return dao;
    }

    public LogHeadOfDepartment removeFromPosition(String id){
        LogHeadOfDepartment logHeadOfDepartmentWhichNeedToSetEndDate = this.getById(id);
        logHeadOfDepartmentWhichNeedToSetEndDate.setEndDate(LocalDate.now());
        return this.save(logHeadOfDepartmentWhichNeedToSetEndDate);
    }

    public LogHeadOfDepartment getLastForThisDepartment(String depId) {
        return this.dao.getAll().stream().filter(log -> log.getEndDate() == null && log.getDepartment().getId().equals(depId)).findFirst().orElse(null);
    }
}
