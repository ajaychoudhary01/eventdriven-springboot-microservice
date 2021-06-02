package eventdriven.mongodbRepository;

import eventdriven.models.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReviewRepository extends MongoRepository<Review, String> {
}
