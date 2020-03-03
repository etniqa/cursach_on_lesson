package edu.stev.cursach.dao.classes.logChiefOfTypeOfProject.impls;

import edu.stev.cursach.dao.classes.logChiefOfTypeOfProject.repository.LogChiefOfTypeOfProjectRepository;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.dataSet.DataSet;
import edu.stev.cursach.model.LogChiefOfTypeOfProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
@Component
public class LogChiefOfTypeOfProjectDaoImpl implements IDao<LogChiefOfTypeOfProject> {
    @Autowired
    DataSet dataSet;
    @Autowired
    LogChiefOfTypeOfProjectRepository repository;

    @PostConstruct
    void init(){
        repository.deleteAll();
        repository.saveAll(this.dataSet.getLogChiefOfTypeOfProjects());
    }

    @Override
    public MongoRepository getRepository() {
        return repository;
    }
}
