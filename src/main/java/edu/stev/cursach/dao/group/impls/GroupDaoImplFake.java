package edu.stev.cursach.dao.group.impls;

import edu.stev.cursach.dao.group.cmnInterfaces.IDao;
import edu.stev.cursach.dataSet.cmnInterfaces.IDataSet;
import edu.stev.cursach.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class GroupDaoImplFake implements IDao<Group> {
    @Autowired
    IDataSet dataSet;

    @Override
    public IDataSet getDataSet() {
        return dataSet;
    }
}
