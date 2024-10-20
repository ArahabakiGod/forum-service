package ait.cohort46.accounting.dao;

import ait.cohort46.accounting.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface AccountingRepository extends MongoRepository<User, String> {

}
