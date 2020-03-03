package edu.stev.cursach.dataSet.impls;

import edu.stev.cursach.dataSet.cmnInterfaces.IDataSet;
import edu.stev.cursach.dataSet.generalDataSet.DataSet;
import edu.stev.cursach.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DataSetGroupImpl implements IDataSet<Group> {
    @Autowired
    DataSet dataSet;

    @Override
    public List<Group> getList() {
        return dataSet.getGroups();
    }
}
