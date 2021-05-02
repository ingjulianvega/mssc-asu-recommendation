package ingjulianvega.ximic.msscasurecommendation.bootstrap;

import ingjulianvega.ximic.msscasurecommendation.domain.RecommendationEntity;
import ingjulianvega.ximic.msscasurecommendation.domain.repositories.RecommendationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class RecommendationLoader implements CommandLineRunner {

    private final RecommendationRepository recommendationRepository;

    @Override
    public void run(String... args) throws Exception {
        if (recommendationRepository.count() == 0) {
            loadRecommendationObjects();
        }
    }

    private void loadRecommendationObjects() {
        recommendationRepository.saveAll(Arrays.asList(
                RecommendationEntity.builder()
                        .visitId(UUID.randomUUID())
                        .recommendationTypeId(UUID.randomUUID())
                        .observations("observación 1").build(),
                RecommendationEntity.builder()
                        .visitId(UUID.randomUUID())
                        .recommendationTypeId(UUID.randomUUID())
                        .observations("observación 2").build(),
                RecommendationEntity.builder()
                        .visitId(UUID.randomUUID())
                        .recommendationTypeId(UUID.randomUUID())
                        .observations("observación 3").build(),
                RecommendationEntity.builder()
                        .visitId(UUID.randomUUID())
                        .recommendationTypeId(UUID.randomUUID())
                        .observations("observación 4").build(),
                RecommendationEntity.builder()
                        .visitId(UUID.randomUUID())
                        .recommendationTypeId(UUID.randomUUID())
                        .observations("observación 5").build()

        ));
    }
}