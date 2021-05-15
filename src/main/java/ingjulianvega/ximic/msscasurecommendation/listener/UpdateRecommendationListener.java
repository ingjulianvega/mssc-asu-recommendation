package ingjulianvega.ximic.msscasurecommendation.listener;

import ingjulianvega.ximic.events.UpdateRecommendationEvent;
import ingjulianvega.ximic.msscasurecommendation.configuration.JmsConfig;
import ingjulianvega.ximic.msscasurecommendation.services.RecommendationService;
import ingjulianvega.ximic.msscasurecommendation.web.Mappers.RecommendationMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class UpdateRecommendationListener {

    private final RecommendationService recommendationService;
    private final RecommendationMapper recommendationMapper;

    @JmsListener(destination = JmsConfig.UPDATE_RECOMMENDATION_QUEUE)
    public void listen(UpdateRecommendationEvent updateRecommendationEvent){
        log.debug("Got UpdateRecommendationEvent " + updateRecommendationEvent.toString());
        recommendationService.create(recommendationMapper.
                updateRecommendationEventToRecommendation(updateRecommendationEvent));
    }
}
