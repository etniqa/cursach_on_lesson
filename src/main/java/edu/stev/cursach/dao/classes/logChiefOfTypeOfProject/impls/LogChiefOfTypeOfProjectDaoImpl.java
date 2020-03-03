package edu.stev.cursach.dao.classes.logChiefOfTypeOfProject.impls;

import edu.stev.cursach.dao.classes.logChiefOfTypeOfProject.repository.LogChiefOfTypeOfProjectRepository;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.dataSet.DataSet;
import edu.stev.cursach.model.Department;
import edu.stev.cursach.model.LogChiefOfTypeOfProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
@Component
public class LogChiefOfTypeOfProjectDaoImpl implements IDao<LogChiefOfTypeOfProject> {
    @Autowired
    DataSet dataSet;
    @Autowired
    LogChiefOfTypeOfProjectRepository repository;

    @PostConstruct
    void init(){
        repository.deleteAll();
        repository.saveAll(this.getAll());
    }

    @Override
    public LogChiefOfTypeOfProject save(LogChiefOfTypeOfProject element) {
        return null;
    }

    @Override
    public LogChiefOfTypeOfProject get(String id) {
        return null;
    }

    @Override
    public List<LogChiefOfTypeOfProject> getAll() {
        return this.dataSet.getLogChiefOfTypeOfProjects();
    }

    @Override
    public LogChiefOfTypeOfProject edit(String id, LogChiefOfTypeOfProject newElem) {
        return null;
    }

    @Override
    public LogChiefOfTypeOfProject delete(String id) {
        LogChiefOfTypeOfProject whichNeedToDelete = this.get(id);
        this.dataSet.getLogChiefOfTypeOfProjects().remove(this.get(id));
        return whichNeedToDelete;
    }
}
