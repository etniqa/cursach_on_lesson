package edu.stev.cursach.dataSet.impls;

import edu.stev.cursach.dataSet.cmnInterfaces.IDataSet;
import edu.stev.cursach.dataSet.mainDataSet.DataSet;
import edu.stev.cursach.model.classes.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrganizationDataSet implements IDataSet<Organization> {
    @Autowired
    DataSet dataSet;

    @Override
    public List<Organization> getList() {
        return dataSet.getOrganizations();
    }
}
