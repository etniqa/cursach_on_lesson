package edu.stev.cursach.controller.web;

import edu.stev.cursach.form.OrganizationForm;
import edu.stev.cursach.form.TechnicianHasEquipmentForm;
import edu.stev.cursach.model.pojos.*;
import edu.stev.cursach.service.classes.agreementHasAgreement.impls.AgreementHasAgreementServiceImpl;
import edu.stev.cursach.service.classes.department.impls.DepartmentServiceImpl;
import edu.stev.cursach.service.classes.equipment.impls.EquipmentServiceImpls;
import edu.stev.cursach.service.classes.organization.impls.OrganizationServiceImpl;
import edu.stev.cursach.service.classes.technicianHasEquipment.impls.TechnicianHasEquipmentServiceImpl;
import edu.stev.cursach.service.classes.typeOfAgreement.impls.TypeOfAgreementServiceImpl;
import edu.stev.cursach.service.classes.worker.impls.WorkerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/technician_has_equipment")
public class TechnicianHasEquipmentWebController {
    @Autowired
    AgreementHasAgreementServiceImpl agreementHasAgreementService;
    @Autowired
    DepartmentServiceImpl departmentService;
    @Autowired
    EquipmentServiceImpls equipmentService;
    @Autowired
    OrganizationServiceImpl organizationService;
    @Autowired
    TypeOfAgreementServiceImpl typeOfAgreementService;
    @Autowired
    WorkerServiceImpl workerService;
    @Autowired
    TechnicianHasEquipmentServiceImpl technicianHasEquipmentService;

    @RequestMapping("/get/list")
    String getAll(Model model){
        model.addAttribute("technicianHasEquipments", technicianHasEquipmentService.getAll());
        return "technicianHasEquipmentList";}
    @RequestMapping("/delete/{id}")
    String delete(@PathVariable("id") String id) {
        technicianHasEquipmentService.delete(id);
        return "redirect:/web/technician_has_equipment/get/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    String add(Model model) {
        TechnicianHasEquipmentForm technicianHasEquipmentForm = new TechnicianHasEquipmentForm();
        model.addAttribute("technicianHasEquipmentForm", technicianHasEquipmentForm);

        Map<String, String> techniciansMap = this.workerService.getAll().stream()
                .filter(worker -> worker instanceof Technician)
                .collect(Collectors.toMap(Worker::getId, Worker::getName));
        model.addAttribute("techniciansMap", techniciansMap);

        Map<String, String> equipmentsMap = equipmentService.getAll().stream()
                .collect(Collectors.toMap(Equipment::getId, Equipment::getName));
        model.addAttribute("equipmentsMap", equipmentsMap);
        return "technicianHasEquipmentAdd";
    }

    //for post filled form for some bean to add
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    String add(@ModelAttribute("technicianHasEquipmentForm") TechnicianHasEquipmentForm technicianHasEquipmentForm) {
        TechnicianHasEquipment newTechnicianHasEquipment = new TechnicianHasEquipment(
                null,
                technicianHasEquipmentForm.getName(),
                technicianHasEquipmentForm.getDescription(),
                null, null,
                (Technician) workerService.get(technicianHasEquipmentForm.getTechnicianId()),
                equipmentService.get(technicianHasEquipmentForm.getEquipmentId())
        );
        technicianHasEquipmentService.save(newTechnicianHasEquipment);
        return "redirect:/web/technician_has_equipment/get/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        TechnicianHasEquipment technicianHasEquipmentWhichEdit = technicianHasEquipmentService.get(id);
        TechnicianHasEquipmentForm technicianHasEquipmentForm = new TechnicianHasEquipmentForm(
                technicianHasEquipmentWhichEdit.getName(),
                technicianHasEquipmentWhichEdit.getDescription(),
                technicianHasEquipmentWhichEdit.getTechnician().getId(),
                technicianHasEquipmentWhichEdit.getEquipment().getId()
        );
        model.addAttribute("technicianHasEquipmentForm", technicianHasEquipmentForm);

        Map<String, String> techniciansMap = this.workerService.getAll().stream()
                .filter(worker -> worker instanceof Technician)
                .collect(Collectors.toMap(Worker::getId, Worker::getName));
        model.addAttribute("techniciansMap", techniciansMap);

        Map<String, String> equipmentsMap = equipmentService.getAll().stream()
                .collect(Collectors.toMap(Equipment::getId, Equipment::getName));
        model.addAttribute("equipmentsMap", equipmentsMap);
        return "technicianHasEquipmentAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(@PathVariable("id") String id, @ModelAttribute("technicianHasEquipmentForm") TechnicianHasEquipmentForm technicianHasEquipmentForm) {
        TechnicianHasEquipment technicianHasEquipmentWhichEdit = technicianHasEquipmentService.get(id);
        technicianHasEquipmentWhichEdit = new TechnicianHasEquipment(
                id,
                technicianHasEquipmentForm.getName(),
                technicianHasEquipmentForm.getDescription(),
                technicianHasEquipmentWhichEdit.getCreationDate(),
                LocalDateTime.now(),
                (Technician) workerService.get(technicianHasEquipmentForm.getTechnicianId()),
                equipmentService.get(technicianHasEquipmentForm.getEquipmentId())
        );
        technicianHasEquipmentService.edit(technicianHasEquipmentWhichEdit);
        return "redirect:/web/technician_has_equipment/get/list";
    }
}
