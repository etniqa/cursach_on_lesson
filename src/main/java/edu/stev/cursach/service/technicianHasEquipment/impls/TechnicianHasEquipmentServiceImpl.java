package edu.stev.cursach.service.technicianHasEquipment.impls;

import edu.stev.cursach.dao.classes.technicianHasEquipment.impls.TechnicianHasEquipmentDaoImpl;
import edu.stev.cursach.model.TechnicianHasEquipment;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TechnicianHasEquipmentServiceImpl implements IService<TechnicianHasEquipment> {
    @Autowired
    TechnicianHasEquipmentDaoImpl dao;

    @Override
    public TechnicianHasEquipment save(TechnicianHasEquipment element) {
        return dao.save(element);
    }

    @Override
    public TechnicianHasEquipment get(String id) {
        return dao.get(id);
    }

    @Override
    public List<TechnicianHasEquipment> getAll() {
        return dao.getAll();
    }

    @Override
    public TechnicianHasEquipment edit(TechnicianHasEquipment element) {
        return dao.edit(element);
    }

    @Override
    public TechnicianHasEquipment delete(TechnicianHasEquipment element) {
        return dao.delete(element);
    }
}
