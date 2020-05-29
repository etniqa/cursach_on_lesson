package edu.stev.cursach.controller.web;

import edu.stev.cursach.form.forListOnFTL.LogOfChangesOfEquipmentForm;
import edu.stev.cursach.model.pojos.*;
import edu.stev.cursach.service.classes.department.impls.DepartmentServiceImpl;
import edu.stev.cursach.service.classes.equipment.impls.EquipmentServiceImpls;
import edu.stev.cursach.service.classes.logOfChangesOfEquipment.impls.LogOfChangesOfEquipmentServiceImpl;
import edu.stev.cursach.service.classes.typeOfAgreement.impls.TypeOfAgreementServiceImpl;
import edu.stev.cursach.service.classes.worker.impls.WorkerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/log_of_changes_of_equipment")
public class LogOfChangesOfEquipmentWebController {
    @Autowired
    LogOfChangesOfEquipmentServiceImpl logOfChangesOfEquipmentService;
    @Autowired
    EquipmentServiceImpls equipmentServiceImpls;
    @Autowired
    DepartmentServiceImpl departmentService;
    @Autowired
    TypeOfAgreementServiceImpl typeOfAgreementService;
    @Autowired
    WorkerServiceImpl workerService;

    @RequestMapping("/get/list")
    String getAll(Model model) {
        model.addAttribute("logOfChangesOfEquipments", logOfChangesOfEquipmentService.getAll());
        return "logOfChangesOfEquipmentList";
    }

    @RequestMapping("/delete/{id}")
    String delete(@PathVariable("id") String id) {
        logOfChangesOfEquipmentService.delete(id);
        return "redirect:/web/log_of_changes_of_equipment/get/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    String add(Model model) {
        LogOfChangesOfEquipmentForm logOfChangesOfEquipmentForm = new LogOfChangesOfEquipmentForm();
        this.addAttributes(model, logOfChangesOfEquipmentForm);
        return "logOfChangesOfEquipmentAddOrEdit";
    }

    //for post filled form for some bean to add
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    String add(@ModelAttribute("logOfChangesOfEquipmentForm") LogOfChangesOfEquipmentForm logOfChangesOfEquipmentForm) {
        LogOfChangesOfEquipment newLogOfChangesOfEquipment = new LogOfChangesOfEquipment(null,
                logOfChangesOfEquipmentForm.getName(),
                logOfChangesOfEquipmentForm.getDescription(),
                null, null,
                equipmentServiceImpls.getById(logOfChangesOfEquipmentForm.getEquipWhichChangeFieldId()),
                departmentService.getById(logOfChangesOfEquipmentForm.getPossibleNewDepartmentId()),
                (Project) typeOfAgreementService.getById(logOfChangesOfEquipmentForm.getPossibleNewProjectId()),
                logOfChangesOfEquipmentForm.getDateBegAfterChange(), null);
        logOfChangesOfEquipmentService.save(newLogOfChangesOfEquipment);
        return "redirect:/web/log_of_changes_of_equipment/get/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        LogOfChangesOfEquipment logOfChangesOfEquipmentEdit = logOfChangesOfEquipmentService.getById(id);
        LogOfChangesOfEquipmentForm logOfChangesOfEquipmentForm = new LogOfChangesOfEquipmentForm(
                logOfChangesOfEquipmentEdit.getName(),
                logOfChangesOfEquipmentEdit.getDescription(),
                logOfChangesOfEquipmentEdit.getEquipWhichChangeField() == null ? "null" : logOfChangesOfEquipmentEdit.getEquipWhichChangeField().getId(),
                logOfChangesOfEquipmentEdit.getPossibleNewDepartment() == null ? "null" : logOfChangesOfEquipmentEdit.getPossibleNewDepartment().getId(),
                logOfChangesOfEquipmentEdit.getPossibleNewProject() == null ? "null" : logOfChangesOfEquipmentEdit.getPossibleNewProject().getId(),
                logOfChangesOfEquipmentEdit.getDateBegAfterChange(),
                null
        );
        this.addAttributes(model, logOfChangesOfEquipmentForm);
        return "logOfChangesOfEquipmentAddOrEdit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(@PathVariable("id") String id, @ModelAttribute("logOfChangesOfEquipmentForm") LogOfChangesOfEquipmentForm logOfChangesOfEquipmentForm) {
        LogOfChangesOfEquipment logOfChangesOfEquipmentEdit = logOfChangesOfEquipmentService.getById(id);
        logOfChangesOfEquipmentEdit = new LogOfChangesOfEquipment(
                id,
                logOfChangesOfEquipmentForm.getName(),
                logOfChangesOfEquipmentForm.getDescription(),
                logOfChangesOfEquipmentEdit.getCreationDate(), null,
                equipmentServiceImpls.getById(logOfChangesOfEquipmentForm.getEquipWhichChangeFieldId()),
                departmentService.getById(logOfChangesOfEquipmentForm.getPossibleNewDepartmentId()),
                (Project) typeOfAgreementService.getById(logOfChangesOfEquipmentForm.getPossibleNewProjectId()),
                logOfChangesOfEquipmentEdit.getDateBegAfterChange(),
                logOfChangesOfEquipmentEdit.getDateEndBeforeNewChange()
                );
        logOfChangesOfEquipmentService.edit(logOfChangesOfEquipmentEdit);
        return "redirect:/web/log_of_changes_of_equipment/get/list";
    }

    private void addAttributes(Model model, LogOfChangesOfEquipmentForm logOfChangesOfEquipmentForm) {
        model.addAttribute("logOfChangesOfEquipmentForm", logOfChangesOfEquipmentForm);
        equipmentServiceImpls.getAll().forEach(elem -> System.out.println(elem.toString()));
        Map<String, String> equipmentsMap = equipmentServiceImpls.getAll().stream()
                .collect(Collectors.toMap(Equipment::getId, Equipment::getName));
        equipmentsMap.put("null", "none");
        model.addAttribute("equipmentsMap", equipmentsMap);
        Map<String, String> departmentsMap = departmentService.getAll().stream()
                .collect(Collectors.toMap(Department::getId, Department::getName));
        departmentsMap.put("null", "none");
        model.addAttribute("departmentsMap", departmentsMap);
        Map<String, String> projectsMap = typeOfAgreementService.getProjects().stream()
                .collect(Collectors.toMap(Project::getId, Project::getFullName));
        projectsMap.put("null", "none");
        model.addAttribute("projectsMap", projectsMap);
    }
}
