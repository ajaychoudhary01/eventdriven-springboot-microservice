package eventdriven.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "reviews")
public class Review {
  @Id
  private String id;

  @Field("Content")
  private String content;

  public String getId() {
    return id;
  }

  public void setUserId(String id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
