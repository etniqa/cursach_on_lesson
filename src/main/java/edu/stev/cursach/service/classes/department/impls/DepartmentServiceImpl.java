package edu.stev.cursach.service.classes.department.impls;

import edu.stev.cursach.dao.classes.department.impls.DepartmentDaoImpl;
import edu.stev.cursach.dao.classes.worker.impls.WorkerDaoImpl;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.model.pojos.Department;
import edu.stev.cursach.model.pojos.Worker;
import edu.stev.cursach.service.classes.agreementHasAgreement.impls.AgreementHasAgreementServiceImpl;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements IService<Department> {
    private Logger logger = Logger.getLogger(DepartmentServiceImpl.class.getName());

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
    DepartmentDaoImpl dao;
    @Autowired
    DepartmentDaoImpl departmentDao;

    @Autowired
    WorkerDaoImpl workerDao;

    @Override
    public IDao getDao() {
        return this.dao;
    }

    public List<Pair<Department, Long>> getDepartmentAndAmountOfWorkers() {
        Map<String, Long> collect = this.workerDao.getAll().stream()
                .collect(Collectors.groupingBy(Worker::getDepartmentId, Collectors.counting()));
        List<Pair<Department, Long>> res = new LinkedList<>();
        collect.forEach((key, val) -> {
            res.add(Pair.of(this.departmentDao.getById(key), val));
        });
        return res;
    }
}
