package ingjulianvega.ximic.msscasurecommendation.services;


import ingjulianvega.ximic.msscasurecommendation.web.model.Recommendation;
import ingjulianvega.ximic.msscasurecommendation.web.model.RecommendationDto;
import ingjulianvega.ximic.msscasurecommendation.web.model.RecommendationList;

import java.util.UUID;

public interface RecommendationService {
    RecommendationList get();

    RecommendationDto getById(UUID id);

    RecommendationList getByVisitId(UUID patientId);

    void create(Recommendation recommendation);

    void updateById(UUID id, Recommendation recommendation);

    void deleteById(UUID id);


}
