package edu.stev.cursach.service.organization.impls;

import edu.stev.cursach.dao.classes.organization.impls.OrganizationDaoImpl;
import edu.stev.cursach.model.Organization;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrganizationServiceImpl implements IService<Organization> {
    @Autowired
    OrganizationDaoImpl organizationDao;

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
        return this.organizationDao.getAll();
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
