package sheridan.carlos.midtermcarlos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "reviews")
public interface ReviewRepository extends JpaRepository<Review, String> {

    List<Review> findByReviewerNameContainingIgnoreCase(@Param("name") String name);

    List<Review> findByStarRating(@Param("rating") long rating);

    List<Review> findByStarRatingGreaterThan(@Param("min") long min);
    List<Review> findByStarRatingLessThan(@Param("max") long max);
    List<Review> findByStarRatingBetween(@Param("min") long min, @Param("max") long max);
}

