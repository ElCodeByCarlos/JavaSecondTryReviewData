package sheridan.carlos.midtermcarlos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Review {
    @Id
    private String itemId;

    private String reviewerName;
    private long starRating;
    private boolean isVerified;
    private String commentText;
    private int helpfulVotes;

    public Review() {}

    public String getReviewId() { return itemId; }
    public String getName() { return reviewerName; }
    public long getRating() { return starRating; }
    public boolean isVerified() { return isVerified; }
    public String getCommentText() { return commentText; }
    public int getHelpfulVotes() { return helpfulVotes; }

    public void setReviewId(String itemId) { this.itemId = itemId; }

    public void setName(String name) { this.reviewerName = name; }

    public void setRating(long starRating) { this.starRating = starRating; }

    public void setIsVerified(boolean verified) { this.isVerified = verified; }

    public void setArea(String commentText) { this.commentText = commentText; }

    public void setHelpfulVotes(int votes) { this.helpfulVotes = votes; }
}
