package edu.stev.cursach.service.classes.technicianHasEquipment.impls;

import edu.stev.cursach.dao.classes.technicianHasEquipment.impls.TechnicianHasEquipmentDaoImpl;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.model.pojos.TechnicianHasEquipment;
import edu.stev.cursach.service.classes.agreementHasAgreement.impls.AgreementHasAgreementServiceImpl;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class TechnicianHasEquipmentServiceImpl implements IService<TechnicianHasEquipment> {
    private Logger logger = Logger.getLogger(TechnicianHasEquipmentServiceImpl.class.getName());

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
    TechnicianHasEquipmentDaoImpl dao;

    @Override
    public IDao getDao() {
        return dao;
    }
}
