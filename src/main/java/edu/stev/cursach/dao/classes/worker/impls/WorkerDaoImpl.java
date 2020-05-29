package edu.stev.cursach.dao.classes.worker.impls;

import com.mongodb.util.JSON;
import edu.stev.cursach.dao.classes.department.repository.DepartmentRepository;
import edu.stev.cursach.dao.classes.worker.repository.WorkerRepository;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.dataSet.DataSet;
import edu.stev.cursach.form.forRealRequests.ForWorkerGroupByDepartment;
import edu.stev.cursach.model.pojos.Department;
import edu.stev.cursach.model.pojos.Worker;
import edu.stev.cursach.service.classes.agreementHasAgreement.impls.AgreementHasAgreementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class WorkerDaoImpl implements IDao<Worker> {
    private Logger logger = Logger.getLogger(WorkerDaoImpl.class.getName());

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
    WorkerRepository repository;
    @Autowired
    DepartmentRepository repositoryDepartment;

    @PostConstruct
    void init() {
        repository.deleteAll();
        this.repository.saveAll(dataSet.getWorkerList());
    }

    @Override
    public MongoRepository getRepository() {
        return repository;
    }

    public List<ForWorkerGroupByDepartment> groupByDepartment() {
        List<ForWorkerGroupByDepartment> responseList = new ArrayList<>();
        this.repository.findAll().stream()
                .collect(Collectors.groupingBy(Worker::getDepartmentId, Collectors.counting()))
                .forEach((key, val) -> {
                    responseList.add(new ForWorkerGroupByDepartment(repositoryDepartment.findById(key).orElse(null), val));
                });
        responseList.stream().forEach(elem -> {
            System.out.println(elem.department.getName());
            System.out.println(elem.amountOfWorkers);
        });
        return responseList;
    }
}
