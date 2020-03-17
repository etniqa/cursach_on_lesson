package edu.stev.cursach.service.classes.technicianHasEquipment.impls;

import edu.stev.cursach.dao.classes.technicianHasEquipment.impls.TechnicianHasEquipmentDaoImpl;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.model.pojos.TechnicianHasEquipment;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TechnicianHasEquipmentServiceImpl implements IService<TechnicianHasEquipment> {
    @Autowired
    TechnicianHasEquipmentDaoImpl dao;

    @Override
    public IDao getDao() {
        return dao;
    }
}
