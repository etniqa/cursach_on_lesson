package edu.stev.cursach.controller.api.controllers;

import edu.stev.cursach.controller.api.cmnInterface.ICommonApiController;
import edu.stev.cursach.model.pojos.AgreementHasAgreement;
import edu.stev.cursach.service.classes.agreementHasAgreement.impls.AgreementHasAgreementServiceImpl;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/agreement_has_agreement")
@CrossOrigin("*")
public class AgreementHasAgreementApiController implements ICommonApiController<AgreementHasAgreement> {
    private Logger logger = Logger.getLogger(AgreementHasAgreement.class.getName());

    @PostConstruct
    void initialize() {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        this.logger.addHandler(consoleHandler);
    }

    @Autowired
    AgreementHasAgreementServiceImpl agreementHasAgreementService;

    @Override
    public IService getService() {
        return this.agreementHasAgreementService;
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }
}
