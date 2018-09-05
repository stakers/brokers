package brokers.dao;

import brokers.entity.CardDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardDetailsDao extends MongoRepository<CardDetails, String> {

}
