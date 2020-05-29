package edu.stev.cursach.service.classes.organization.impls;

import edu.stev.cursach.dao.classes.organization.impls.OrganizationDaoImpl;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.model.pojos.Organization;
import edu.stev.cursach.service.classes.agreementHasAgreement.impls.AgreementHasAgreementServiceImpl;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class OrganizationServiceImpl implements IService<Organization> {
    private Logger logger = Logger.getLogger(OrganizationServiceImpl.class.getName());

    @PostConstruct
    void initialize() {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        this.logger.addHandler(consoleHandler);
    }
    @Override
    public Logger getLogger() {
        return this.logger;
    }
    @Autowired
    OrganizationDaoImpl dao;

    @Override
    public IDao getDao() {
        return dao;
    }

    public List<Organization> getSuborgs() {
//        this.dao.getAll().stream().forEach(elem -> System.out.println(elem.toString()));
        return this.dao.getAll().stream().filter(org -> org.getHeadOrganization() != null).collect(Collectors.toList());
    }
}
