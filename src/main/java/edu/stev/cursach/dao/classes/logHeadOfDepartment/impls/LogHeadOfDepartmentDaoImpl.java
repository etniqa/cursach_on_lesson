package edu.stev.cursach.dao.classes.logHeadOfDepartment.impls;

import edu.stev.cursach.dao.classes.logHeadOfDepartment.repository.LogHeadOfDepartmentRepository;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.dataSet.DataSet;
import edu.stev.cursach.model.pojos.LogHeadOfDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class LogHeadOfDepartmentDaoImpl implements IDao<LogHeadOfDepartment> {
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

    public LogHeadOfDepartment removeFromHead(String idCanLeadWhichRemoving){
        LogHeadOfDepartment logHeadOfDepartmentWhichNeedToSetEndDate = repository.findAll().stream()
                .filter(logHeadOfDepartment -> logHeadOfDepartment.getDepartment().getId().equals(idCanLeadWhichRemoving) &&
                        logHeadOfDepartment.getEndDate() == null)
                .findFirst().orElse(null);
        logHeadOfDepartmentWhichNeedToSetEndDate.setEndDate(LocalDate.now());
        return this.save(logHeadOfDepartmentWhichNeedToSetEndDate);
    }
}
