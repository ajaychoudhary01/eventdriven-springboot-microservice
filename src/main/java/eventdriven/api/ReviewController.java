package eventdriven.api;

import eventdriven.kafka.producer.Producer;
import eventdriven.models.Review;
import eventdriven.mongodbRepository.IReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReviewController {

  @Autowired
  private final IReviewRepository reviewRepository;
  private final Producer producer;

  public ReviewController(IReviewRepository reviewRepository, Producer producer) {
    this.reviewRepository = reviewRepository;
    this.producer = producer;
  }

  @RequestMapping(value = "/reviews", method = RequestMethod.GET)
  public List<Review> getReviews() {
    return reviewRepository.findAll();
  }

  @RequestMapping(value = "/review", method = RequestMethod.POST)
  public void insertReview(@RequestBody String review) {
      producer.sendMessage(review);
  }
}
