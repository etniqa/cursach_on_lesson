package edu.stev.cursach.controller.web;

import edu.stev.cursach.model.Equipment;
import edu.stev.cursach.service.equipment.impls.EquipmentServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/web/equipment")
public class EquipmentWebController {
    @Autowired
    EquipmentServiceImpls equipmentServiceImpls;

    @RequestMapping("/list")
    String getAll(Model model){
        model.addAttribute("equipments", equipmentServiceImpls.getAll());
        return "equipmentList";
    }
}
