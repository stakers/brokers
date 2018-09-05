package brokers.dao;

import brokers.entity.BankDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankDetailsDao extends MongoRepository<BankDetails, String> {

}
