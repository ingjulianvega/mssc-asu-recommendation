package ingjulianvega.ximic.msscasurecommendation.web.Mappers;


import ingjulianvega.ximic.events.UpdateRecommendationEvent;
import ingjulianvega.ximic.msscasurecommendation.domain.RecommendationEntity;
import ingjulianvega.ximic.msscasurecommendation.web.model.Recommendation;
import ingjulianvega.ximic.msscasurecommendation.web.model.RecommendationDto;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(uses = DateMapper.class)
public interface RecommendationMapper {
    RecommendationDto recommendationEntityToRecommendationDto(RecommendationEntity recommendationEntity);

    RecommendationEntity recommendationDtoToRecommendationEntity(RecommendationDto recommendationDto);

    ArrayList<RecommendationDto> recommendationEntityListToRecommendationDtoList(List<RecommendationEntity> recommendationEntityList);

    Recommendation updateRecommendationEventToRecommendation(UpdateRecommendationEvent updateRecommendationEvent);
}
