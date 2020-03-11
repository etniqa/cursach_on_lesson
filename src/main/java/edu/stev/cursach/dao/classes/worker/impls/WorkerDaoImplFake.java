package edu.stev.cursach.dao.classes.worker.impls;

import edu.stev.cursach.dao.classes.worker.repository.WorkerRepository;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.dataSet.DataSet;
import edu.stev.cursach.model.classes.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class WorkerDaoImplFake implements IDao<Worker> {
    @Autowired
    DataSet dataSet;
    @Autowired
    WorkerRepository repository;
    @PostConstruct
    void init(){
        repository.deleteAll();
        this.repository.saveAll(dataSet.getWorkerList());
    }

    @Override
    public MongoRepository getRepository() {
        return repository;
    }
}
