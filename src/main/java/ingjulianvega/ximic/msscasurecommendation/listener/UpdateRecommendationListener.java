package ingjulianvega.ximic.msscasurecommendation.listener;

import ingjulianvega.ximic.events.UpdateRecommendationEvent;
import ingjulianvega.ximic.msscasurecommendation.configuration.JmsConfig;
import ingjulianvega.ximic.msscasurecommendation.services.RecommendationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class UpdateRecommendationListener {

    private final RecommendationService recommendationService;

    @JmsListener(destination = JmsConfig.UPDATE_RECOMMENDATION_QUEUE)
    public void listen(UpdateRecommendationEvent event){
        log.debug("Got updateRecommendation " + event.toString());
        //visitService.create(event.getVisit());
    }
}
