package edu.stev.cursach.controller.web.cmnInterface;

import edu.stev.cursach.form.AgreementHasAgreementForForm;
import edu.stev.cursach.form.IForForm;
import edu.stev.cursach.model.pojos.AgreementHasAgreement;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface IWebController<T extends IForForm> {
    String getTableName();
    IService getService();

    @RequestMapping("/get/list")
    default String getAll(Model model){
        String newStr = new String();
        model.addAttribute(getTableName() + "s", getService().getAll());
        return getTableName() + "List";
    }

    @RequestMapping("/delete/{id}")
    default String delete(@PathVariable("id") String id) {
        getService().delete(id);
        return "redirect:/web/" + getTableName() + "/get/list";
    }
}
