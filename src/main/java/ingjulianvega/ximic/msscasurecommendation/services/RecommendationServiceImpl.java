package ingjulianvega.ximic.msscasurecommendation.services;


import ingjulianvega.ximic.msscasurecommendation.configuration.ErrorCodeMessages;
import ingjulianvega.ximic.msscasurecommendation.domain.RecommendationEntity;
import ingjulianvega.ximic.msscasurecommendation.domain.repositories.RecommendationRepository;
import ingjulianvega.ximic.msscasurecommendation.exception.RecommendationException;
import ingjulianvega.ximic.msscasurecommendation.web.Mappers.RecommendationMapper;
import ingjulianvega.ximic.msscasurecommendation.web.model.Recommendation;
import ingjulianvega.ximic.msscasurecommendation.web.model.RecommendationDto;
import ingjulianvega.ximic.msscasurecommendation.web.model.RecommendationList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final RecommendationRepository recommendationRepository;
    private final RecommendationMapper recommendationMapper;

    @Cacheable(cacheNames = "recommendationListCache")
    @Override
    public RecommendationList get() {
        log.debug("get()...");
        return RecommendationList
                .builder()
                .recommendationDtoList(recommendationMapper.recommendationEntityListToRecommendationDtoList(recommendationRepository.findAll()))
                .build();
    }

    @Cacheable(cacheNames = "recommendationCache")
    @Override
    public RecommendationDto getById(UUID id) {
        log.debug("getById()...");
        return recommendationMapper.recommendationEntityToRecommendationDto(
                recommendationRepository.findById(id)
                        .orElseThrow(() -> new RecommendationException(ErrorCodeMessages.RECOMMENDATION_NOT_FOUND, "")));
    }

    @Override
    public RecommendationList getByVisitId(UUID visitId) {
        log.debug("getByVisitId()...");
        return RecommendationList
                .builder()
                .recommendationDtoList(recommendationMapper.recommendationEntityListToRecommendationDtoList(recommendationRepository.findByVisitId(visitId)))
                .build();
    }

    @Override
    public void create(Recommendation recommendation) {
        log.debug("create()...");
        recommendationMapper.recommendationEntityToRecommendationDto(
                recommendationRepository.save(
                        recommendationMapper.recommendationDtoToRecommendationEntity(
                                RecommendationDto
                                        .builder()
                                        .visitId(recommendation.getVisitId())
                                        .recommendationTypeId(recommendation.getRecommendationTypeId())
                                        .observations(recommendation.getObservations())
                                        .build())));
    }

    @Override
    public void updateById(UUID id, Recommendation recommendation) {
        log.debug("updateById...");
        RecommendationEntity recommendationEntity = recommendationRepository.findById(id)
                .orElseThrow(() -> new RecommendationException(ErrorCodeMessages.RECOMMENDATION_NOT_FOUND, ""));

        recommendationEntity.setVisitId(recommendation.getVisitId());
        recommendationEntity.setRecommendationTypeId(recommendation.getRecommendationTypeId());
        recommendationEntity.setObservations(recommendation.getObservations());

        recommendationRepository.save(recommendationEntity);
    }

    @Override
    public void deleteById(UUID id) {
        log.debug("deleteById...");
        recommendationRepository.deleteById(id);
    }
}
