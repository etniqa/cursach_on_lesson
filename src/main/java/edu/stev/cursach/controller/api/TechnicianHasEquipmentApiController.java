package edu.stev.cursach.controller.api;

import edu.stev.cursach.model.TechnicianHasEquipment;
import edu.stev.cursach.service.classes.technicianHasEquipment.impls.TechnicianHasEquipmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/technician_has_equipment")
public class TechnicianHasEquipmentApiController {
    @Autowired
    TechnicianHasEquipmentServiceImpl service;

    @RequestMapping("/get/list")
    List<TechnicianHasEquipment> getAll(){return this.service.getAll();}
}
