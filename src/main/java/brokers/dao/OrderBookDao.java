package brokers.dao;

import brokers.entity.OrderBook;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderBookDao extends MongoRepository<OrderBook, ObjectId> {
}
