package edu.stev.cursach.dao.classes.agreementHasAgreement.repository;

import edu.stev.cursach.model.classes.AgreementHasAgreement;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AgreementHasAgreementRepository extends MongoRepository<AgreementHasAgreement, String> {
}
