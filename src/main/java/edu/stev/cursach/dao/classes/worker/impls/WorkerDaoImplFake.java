package edu.stev.cursach.dao.classes.worker.impls;

import edu.stev.cursach.dao.classes.worker.repository.WorkerRepository;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.dataSet.cmnInterfaces.IDataSet;
import edu.stev.cursach.dataSet.impls.WorkerDataSet;
import edu.stev.cursach.dataSet.mainDataSet.DataSet;
import edu.stev.cursach.model.classes.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
@Component
public class WorkerDaoImplFake implements IDao<Worker> {
    @Autowired
    WorkerDataSet dataSet;

    @Override
    public IDataSet getDataSet() {
        return this.dataSet;
    }
//    @PostConstruct
//    void init(){
//        repository.deleteAll();
//        this.repository.saveAll(dataSet.getWorkerList());
//    }

    /*@Override
    public Worker save(Worker element) {
        return null;
    }

    @Override
    public Worker get(String id) {
        return null;
    }

    @Override
    public List getAll() {
        return this.dataSet.getWorkerList();
    }

    @Override
    public Worker edit(String id, Worker newElem) {
        return null;
    }

    @Override
    public Worker delete(String id) {
        return null;
    }*/
}
