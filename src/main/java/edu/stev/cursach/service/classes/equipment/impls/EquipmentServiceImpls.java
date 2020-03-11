package edu.stev.cursach.service.classes.equipment.impls;

import edu.stev.cursach.dao.classes.equipment.impls.EquipmentDaoImpls;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.model.pojos.Equipment;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentServiceImpls implements IService<Equipment> {
    @Autowired
    EquipmentDaoImpls dao;

    @Override
    public IDao getDao() {
        return dao;
    }

    @Override
    public Equipment edit(Equipment element) {
        return null;
    }
}
