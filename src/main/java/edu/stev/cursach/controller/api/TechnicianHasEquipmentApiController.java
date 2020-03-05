package edu.stev.cursach.controller.api;

import edu.stev.cursach.model.TechnicianHasEquipment;
import edu.stev.cursach.service.classes.technicianHasEquipment.impls.TechnicianHasEquipmentServiceImpl;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/technician_has_equipment")
public class TechnicianHasEquipmentApiController implements ICommonApiController<TechnicianHasEquipmentApiController>{
    @Autowired
    TechnicianHasEquipmentServiceImpl service;

    @Override
    public IService getService() {
        return this.service;
    }
}
