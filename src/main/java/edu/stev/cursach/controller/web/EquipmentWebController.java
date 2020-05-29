package edu.stev.cursach.controller.web;

import edu.stev.cursach.form.EquipmentForm;
import edu.stev.cursach.model.pojos.Department;
import edu.stev.cursach.model.pojos.Equipment;
import edu.stev.cursach.model.pojos.Project;
import edu.stev.cursach.service.classes.agreementHasAgreement.impls.AgreementHasAgreementServiceImpl;
import edu.stev.cursach.service.classes.department.impls.DepartmentServiceImpl;
import edu.stev.cursach.service.classes.equipment.impls.EquipmentServiceImpls;
import edu.stev.cursach.service.classes.organization.impls.OrganizationServiceImpl;
import edu.stev.cursach.service.classes.typeOfAgreement.impls.TypeOfAgreementServiceImpl;
import edu.stev.cursach.service.classes.worker.impls.WorkerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/equipment")
public class EquipmentWebController {
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

    @RequestMapping("/get/list")
    String getAll(Model model){
        model.addAttribute("equipments", equipmentService.getAll());
        return "equipmentList";
    }

    @RequestMapping("/delete/{id}")
    String delete(@PathVariable("id") String id) {
        equipmentService.delete(id);
        return "redirect:/web/equipment/get/list";
    }

    //before transfer to form for editing I fill form
    //linking all fields in form to my ObjectForm class
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(@PathVariable("id") String id, Model model){
        Equipment equipmentWhichEdit = equipmentService.getById(id);
        EquipmentForm equipmentForm = new EquipmentForm(equipmentWhichEdit.getName(), equipmentWhichEdit.getDescription(),
                equipmentWhichEdit.getDepWhichResponsible().getId(), equipmentWhichEdit.getProjectWhereIsNowEquip().getId());
        model.addAttribute("equipmentForm", equipmentForm);

        Map<String, String> departmentsMap = departmentService.getAll().stream().collect(
                Collectors.toMap(Department::getId, Department::getName));
        departmentsMap.put("null", "in common using");
        model.addAttribute("departmentsMap", departmentsMap);

        List<Project> projects = typeOfAgreementService.getAll().stream()
                .filter(typeOfAgreement -> typeOfAgreement instanceof Project)
                .map(typeOfAgreement -> (Project) typeOfAgreement)
                .collect(Collectors.toList());
        Map<String, String> projectsMap = projects.stream().collect(Collectors.toMap(Project::getId, Project::getFullName));
        projectsMap.put("null", "nowhere");
        model.addAttribute("projectsMap", projectsMap);
        return "equipmentAdd";
    }
   //after submit on form of editing
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(@PathVariable("id") String id, @ModelAttribute("equipmentForm") EquipmentForm equipmentForm){
        Equipment equipmentWhichEdit = equipmentService.getById(id);
        equipmentWhichEdit = new Equipment(equipmentWhichEdit.getId(), equipmentForm.getName(), equipmentForm.getDescription(),
                equipmentWhichEdit.getCreationDate(), equipmentWhichEdit.getDateModified(),
                this.departmentService.getById(equipmentForm.getDepWhichResponsibleId()), (Project) typeOfAgreementService.getById(equipmentForm.getProjectWhereIsNowEquipId()));
        equipmentService.edit(equipmentWhichEdit);
        return "redirect:/web/equipment/get/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    String add(Model model){
        EquipmentForm equipmentForm = new EquipmentForm();
        model.addAttribute("equipmentForm", equipmentForm);

        Map<String, String> departmentsMap = departmentService.getAll().stream().collect(
                Collectors.toMap(Department::getId, Department::getName));
        departmentsMap.put("null", "in common using");
        model.addAttribute("departmentsMap", departmentsMap);

        List<Project> projects = typeOfAgreementService.getAll().stream()
                .filter(typeOfAgreement -> typeOfAgreement instanceof Project)
                .map(typeOfAgreement -> (Project) typeOfAgreement)
                .collect(Collectors.toList());
        Map<String, String> projectsMap = projects.stream().collect(Collectors.toMap(Project::getId, Project::getFullName));
        projectsMap.put("null", "nowhere");
        model.addAttribute("projectsMap", projectsMap);
        return "equipmentAdd";
    }
    //after submit on form of editing
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    String add(@ModelAttribute("equipmentForm") EquipmentForm equipmentForm){
        Equipment equipmentWhichEdit = new Equipment(null, equipmentForm.getName(), equipmentForm.getDescription(),
                null, null,
                this.departmentService.getById(equipmentForm.getDepWhichResponsibleId()), (Project) typeOfAgreementService.getById(equipmentForm.getProjectWhereIsNowEquipId()));
        equipmentService.save(equipmentWhichEdit);
        return "redirect:/web/equipment/get/list";
    }
}
