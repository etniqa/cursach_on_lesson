package edu.stev.cursach.dao.classes.logHeadOfDepartment.impls;

import edu.stev.cursach.dao.classes.logHeadOfDepartment.repository.LogHeadOfDepartmentRepository;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.dataSet.cmnInterfaces.IDataSet;
import edu.stev.cursach.dataSet.impls.LogHeadOfDepartmentDataSet;
import edu.stev.cursach.dataSet.mainDataSet.DataSet;
import edu.stev.cursach.model.classes.LogHeadOfDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
@Component
public class LogHeadOfDepartmentDaoImpl implements IDao<LogHeadOfDepartment> {
    @Autowired
    LogHeadOfDepartmentDataSet dataSet;

    @Override
    public IDataSet getDataSet() {
        return this.dataSet;
    }
//    @PostConstruct
//    void init(){
//        this.repository.deleteAll();
//        this.repository.saveAll(this.getAll());
//    }


    /*@Override
    public LogHeadOfDepartment save(LogHeadOfDepartment element) {
        return null;
    }

    @Override
    public LogHeadOfDepartment get(String id) {
        return null;
    }

    @Override
    public List<LogHeadOfDepartment> getAll() {
        return dataSet.getLogHeadOfDepartments();
    }

    @Override
    public LogHeadOfDepartment edit(String id, LogHeadOfDepartment newElem) {
        return null;
    }

    @Override
    public LogHeadOfDepartment delete(String id) {
        LogHeadOfDepartment whichNeedToDelete = this.get(id);
        this.dataSet.getLogHeadOfDepartments().remove(this.get(id));
        return whichNeedToDelete;
    }*/
}
