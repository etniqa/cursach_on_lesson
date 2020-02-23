package edu.stev.cursach.dao.organization.impls;

import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.dataSet.DataSet;
import edu.stev.cursach.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class OrganizationDaoImpl implements IDao<Organization> {
    @Autowired
    DataSet dataSet;

    @Override
    public Organization save(Organization element) {
        return null;
    }

    @Override
    public Organization get(String id) {
        return null;
    }

    @Override
    public List<Organization> getAll() {
        return this.dataSet.getOrganizations();
    }

    @Override
    public Organization edit(Organization element) {
        return null;
    }

    @Override
    public Organization delete(Organization element) {
        return null;
    }
}
