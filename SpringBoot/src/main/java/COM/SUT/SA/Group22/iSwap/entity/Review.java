package COM.SUT.SA.Group22.iSwap.entity;

import javax.persistence.*;
import lombok.*;
import java.util.*;

@Entity //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Setter @Getter
@ToString

@EqualsAndHashCode
@Table(name="Review") //ชื่อตาราง

public class Review {

    @Id // Annotations @Id บอกว่าเป็น Primary key
    @SequenceGenerator(name="review_seq",sequenceName="review_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="review_seq")
    @Column(name="REVIEW_ID")

    private @NonNull Long review_id;
    private @NonNull String comments;
    private @NonNull int rating;
    private @NonNull Date reviewdate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
   @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "propos_id")
    private Proposal proposal;

  public Review() {}
   public Review(Long review_id, String comments, int rating,Date reviewdate) { //constructor
        this.review_id = review_id;
        this.rating = rating;
        this.reviewdate = reviewdate;
        this.comments = comments;
    }

    public Long getReview_id() {
        return this.review_id;
    }

    public String getComments() {
        return comments;
    }

    public int getRating() {
        return rating;
    }

    public Date getReviewdate() {
        return reviewdate;
    }

    public User getUser() {
        return user;
    }

    public Item getItem() {
        return item;
    }

    public Proposal getProposal() {
        return proposal;
    }
}