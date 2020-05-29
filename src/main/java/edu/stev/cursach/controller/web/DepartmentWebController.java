package edu.stev.cursach.controller.web;

import edu.stev.cursach.form.forListOnFTL.DepartmentForListOnFTL;
import edu.stev.cursach.form.DepartmentForm;
import edu.stev.cursach.model.pojos.CanLead;
import edu.stev.cursach.model.pojos.Department;
import edu.stev.cursach.model.pojos.LogHeadOfDepartment;
import edu.stev.cursach.model.pojos.Organization;
import edu.stev.cursach.service.classes.agreementHasAgreement.impls.AgreementHasAgreementServiceImpl;
import edu.stev.cursach.service.classes.department.impls.DepartmentServiceImpl;
import edu.stev.cursach.service.classes.equipment.impls.EquipmentServiceImpls;
import edu.stev.cursach.service.classes.logHeadOfDepartment.impls.LogHeadOfDepartmentServiceImpl;
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
@RequestMapping("/web/department")
public class DepartmentWebController {
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
    LogHeadOfDepartmentServiceImpl logHeadOfDepartmentService;

    @RequestMapping("/get/list")
    String getAll(Model model){
        List<Department> departmentsList = departmentService.getAll();

        //order heads of department where begEnd==null (these heads are really heads now)
        List<LogHeadOfDepartment> headAndDepartmentNowList = logHeadOfDepartmentService.getAll().stream()
                .filter(logHeadOfDepartment -> logHeadOfDepartment.getEndDate() == null).collect(Collectors.toList());

        //order CanLeadList to departmentList
        List<CanLead> canLeadsOrderlyAccordingToDepartmentList = departmentsList.stream()
                .map(department -> headAndDepartmentNowList.stream()
                        .filter(headAndDepartmentNow -> headAndDepartmentNow.getDepartment().getId().equals(department.getId()))
                        .findFirst().orElse(null).getHeadOfDepartment())
                .collect(Collectors.toList());

        List<DepartmentForListOnFTL> departmentsForListOnFTL =
                departmentsList.stream()
                .map(department -> new DepartmentForListOnFTL(department, (headAndDepartmentNowList.stream()
                .filter(headAndDepartmentNow -> headAndDepartmentNow.getDepartment().getId().equals(department.getId()))
                .findFirst().orElse(null).getHeadOfDepartment()))).collect(Collectors.toList());

        model.addAttribute("departmentsForListOnFTL", departmentsForListOnFTL);

        model.addAttribute("headsOfDepartment", canLeadsOrderlyAccordingToDepartmentList);
        return "departmentList";
    }

    @RequestMapping("/delete/{id}")
    String delete(@PathVariable("id") String id) {
        //set end date to head of deleted department
        logHeadOfDepartmentService.delete(id);
        departmentService.delete(id);
        return "redirect:/web/department/get/list";
    }

    //before transfer to form for editing I fill form
    //linking all fields in form to my ObjectForm class
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(@PathVariable("id") String id, Model model){
        Department departmentWhichEdit = departmentService.getById(id);
        DepartmentForm departmentForm = new DepartmentForm(departmentWhichEdit.getName(), departmentWhichEdit.getDescription(),
                departmentWhichEdit.getOrganization().getId());

        Map<String, String> organizationsMap = organizationService.getAll().stream()
                .collect(Collectors.toMap(Organization::getId, Organization::getName));
        model.addAttribute("departmentForm", departmentForm);
        model.addAttribute("organizationsMap", organizationsMap);
        return "departmentAdd";
    }
    //after submit on form of editing
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(@PathVariable("id") String id, @ModelAttribute("departmentForm") DepartmentForm departmentForm){
        Department departmentWhichEdit = departmentService.getById(id);
        departmentWhichEdit = new Department(departmentWhichEdit.getId(), departmentForm.getName(), departmentForm.getDescription(),
                departmentWhichEdit.getCreationDate(), departmentWhichEdit.getDateModified(), organizationService.getById(departmentForm.getOrganizationId()));

        departmentService.edit(departmentWhichEdit);
        return "redirect:/web/department/get/list";
    }

    //before transfer to form for adding I fill form
    //linking all fields in form to my ObjectForm class
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    String add(Model model){
        DepartmentForm departmentForm = new DepartmentForm();
        Map<String, String> organizationsMap = organizationService.getAll().stream()
                .collect(Collectors.toMap(Organization::getId, Organization::getName));
        model.addAttribute("organizationsMap", organizationsMap);
        model.addAttribute("departmentForm", departmentForm);
        return "departmentAdd";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    String add(@ModelAttribute("departmentForm") DepartmentForm departmentForm){
        this.departmentService.save(new Department(null, departmentForm.getName(), departmentForm.getDescription(),
                null, null, organizationService.getById(departmentForm.getOrganizationId())));
        return "redirect:/web/department/get/list";
    }
}

