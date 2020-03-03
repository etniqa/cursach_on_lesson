package edu.stev.cursach.dataSet.impls;

import edu.stev.cursach.dataSet.cmnInterfaces.IDataSet;
import edu.stev.cursach.dataSet.mainDataSet.DataSet;
import edu.stev.cursach.model.classes.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DepartmentDataSet implements IDataSet<Department> {
    @Autowired
    DataSet dataSet;

    @Override
    public List<Department> getList() {
        return dataSet.getDepartments();
    }
}
