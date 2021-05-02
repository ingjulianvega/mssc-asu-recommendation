package ingjulianvega.ximic.msscasurecommendation.domain.repositories;

import ingjulianvega.ximic.msscasurecommendation.domain.RecommendationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.UUID;

public interface RecommendationRepository extends JpaRepository<RecommendationEntity, UUID>, JpaSpecificationExecutor<RecommendationEntity> {
    List<RecommendationEntity> findByVisitId(UUID visitId);
}
