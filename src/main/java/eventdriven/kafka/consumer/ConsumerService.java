package eventdriven.kafka.consumer;

import eventdriven.models.Review;
import eventdriven.mongodbRepository.IReviewRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public final class ConsumerService {

  private final IReviewRepository reviewRepository;

  public ConsumerService(IReviewRepository reviewRepository) {
    this.reviewRepository = reviewRepository;
  }

  @KafkaListener(topics = "rest-spring-boot-integration", containerFactory = "kafkaListenerContainerFactory")
  public void consume(String message) {
    Review review = new Review();
    review.setContent(message);

    reviewRepository.insert(review);
  }
}
