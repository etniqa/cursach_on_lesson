package edu.stev.cursach.dao.classes.typeOfAgreement.repository;

import edu.stev.cursach.model.TypeOfAgreement;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TypeOfAgreementRepository extends MongoRepository<TypeOfAgreement, String> {
}