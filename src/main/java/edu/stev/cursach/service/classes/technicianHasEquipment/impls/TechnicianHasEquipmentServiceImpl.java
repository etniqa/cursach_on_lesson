package edu.stev.cursach.service.classes.technicianHasEquipment.impls;

import edu.stev.cursach.dao.classes.technicianHasEquipment.impls.TechnicianHasEquipmentDaoImpl;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.model.classes.TechnicianHasEquipment;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TechnicianHasEquipmentServiceImpl implements IService<TechnicianHasEquipment> {
    @Autowired
    TechnicianHasEquipmentDaoImpl dao;
    @Override
    public IDao getDao() {
        return this.dao;
    }

    @Override
    public TechnicianHasEquipment edit(TechnicianHasEquipment element) {
        return null;
    }
    //    @Override
//    public TechnicianHasEquipment save(TechnicianHasEquipment element) {
//        return dao.save(element);
//    }
//
//    @Override
//    public TechnicianHasEquipment get(String id) {
//        return dao.get(id);
//    }
//
//    @Override
//    public List<TechnicianHasEquipment> getAll() {
//        return dao.getAll();
//    }
//
//    @Override
//    public TechnicianHasEquipment edit(TechnicianHasEquipment element) {
////        return dao.edit(element);
//    return null;
//    }
//
//    @Override
//    public TechnicianHasEquipment delete(String id) {
//        return dao.delete(id);
//    }
}
