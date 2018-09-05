package brokers.dao;

import brokers.entity.Loan;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanDao extends MongoRepository<Loan, ObjectId> {
}
