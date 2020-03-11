package edu.stev.cursach.controller.api.controllers;

import edu.stev.cursach.controller.api.interfaces.ICommonApiController;
import edu.stev.cursach.service.classes.technicianHasEquipment.impls.TechnicianHasEquipmentServiceImpl;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/technician_has_equipment")
public class TechnicianHasEquipmentApiController implements ICommonApiController<TechnicianHasEquipmentApiController> {
    @Autowired
    TechnicianHasEquipmentServiceImpl service;

    @Override
    public IService getService() {
        return this.service;
    }
}
