package edu.stev.cursach.service.classes.worker.impls;

import edu.stev.cursach.dao.classes.logHeadOfDepartment.impls.LogHeadOfDepartmentDaoImpl;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.dao.classes.worker.impls.WorkerDaoImpl;
import edu.stev.cursach.form.forRealRequests.ForWorkerGroupByDepartment;
import edu.stev.cursach.model.pojos.CanLead;
import edu.stev.cursach.model.pojos.LogHeadOfDepartment;
import edu.stev.cursach.model.pojos.Technician;
import edu.stev.cursach.model.pojos.Worker;
import edu.stev.cursach.service.classes.agreementHasAgreement.impls.AgreementHasAgreementServiceImpl;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class WorkerServiceImpl implements IService<Worker> {
    private Logger logger = Logger.getLogger(WorkerServiceImpl.class.getName());

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
    WorkerDaoImpl dao;

    @Autowired
    LogHeadOfDepartmentDaoImpl logHeadOfDepartmentDao;

    @Override
    public IDao getDao() {
        return dao;
    }

    public List<ForWorkerGroupByDepartment> groupByDepartment() {
        return this.dao.groupByDepartment();
    }

    public List<LogHeadOfDepartment> getActualHeads() {
        return logHeadOfDepartmentDao.getAll().stream()
                .filter(logHeadOfDepartment -> logHeadOfDepartment.getEndDate() == null)
                .collect(Collectors.toList());
    }

    public List<Pair<CanLead, Integer>> getMapWithCanLeadAndAmount() {
        List<Pair<CanLead, Integer>> responseList = new ArrayList<>();
        List<LogHeadOfDepartment> headAndDepartmentNowList = this.getActualHeads();
        headAndDepartmentNowList.stream()
                .collect(Collectors.groupingBy(LogHeadOfDepartment::getHeadOfDepartmentId))
                .forEach((key, value) -> {
                    responseList.add(Pair.of(value.get(0).getHeadOfDepartment(), value.size()));
                });
        //debug
        responseList.forEach((elem) -> {
            System.out.println(elem.getFirst());
            System.out.println(elem.getSecond());
            System.out.println();
        });
        //
        return responseList;
    }

    public List<CanLead> getCanLeads() {
        return this.dao.getAll().stream().filter(worker -> worker instanceof CanLead).map(elem -> (CanLead) elem).collect(Collectors.toList());
    }

    public List<Technician> getTechnicians() {
        return this.dao.getAll().stream().filter(elem -> elem instanceof Technician).map(elem -> (Technician) elem).collect(Collectors.toList());
    }
}
