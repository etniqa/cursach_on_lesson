package edu.stev.cursach.service.classes.equipment.impls;

import edu.stev.cursach.dao.classes.equipment.impls.EquipmentDaoImpls;
import edu.stev.cursach.model.Equipment;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EquipmentServiceImpls implements IService<Equipment> {
    @Autowired
    EquipmentDaoImpls dao;

    @Override
    public Equipment save(Equipment element) {
        return null;
    }

    @Override
    public Equipment get(String id) {
        return null;
    }

    @Override
    public List<Equipment> getAll() {
        return dao.getAll();
    }

    @Override
    public Equipment edit(Equipment element) {
        return null;
    }

    @Override
    public Equipment delete(Equipment element) {
        return null;
    }
}
