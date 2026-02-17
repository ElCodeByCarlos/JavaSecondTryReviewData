package sheridan.carlos.midtermcarlos;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class ReviewDataLoader implements CommandLineRunner {
    private final ReviewRepository repo;
    private final ObjectMapper mapper = new ObjectMapper();

    public ReviewDataLoader(ReviewRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repo.count() > 0) return;

        try (InputStream in = new ClassPathResource("reviews.json").getInputStream()) {

            JsonNode root = mapper.readTree(in);
            JsonNode reviewsNode = root.get("reviews");

            if (reviewsNode == null || !reviewsNode.isArray()) {
                throw new IllegalStateException("reviews.json must contain a top-level field named 'nameId' that is an array");
            }

            for (JsonNode node : reviewsNode) {
                Review city = mapper.treeToValue(node, Review.class);
                repo.save(city);
            }
        }
    }

}
