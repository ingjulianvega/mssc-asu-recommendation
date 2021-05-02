package ingjulianvega.ximic.msscasurecommendation.web.controller;


import ingjulianvega.ximic.msscasurecommendation.services.RecommendationService;
import ingjulianvega.ximic.msscasurecommendation.web.model.Recommendation;
import ingjulianvega.ximic.msscasurecommendation.web.model.RecommendationDto;
import ingjulianvega.ximic.msscasurecommendation.web.model.RecommendationList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class RecommendationController implements RecommendationI {

    private final RecommendationService recommendationService;

    @Override
    public ResponseEntity<RecommendationList> get() {
        return new ResponseEntity<>(recommendationService.get(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RecommendationDto> getById(@NotNull UUID id) {
        return new ResponseEntity<>(recommendationService.getById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RecommendationList> getByVisittId(UUID visitId) {
        return new ResponseEntity<>(recommendationService.getByVisitId(visitId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> create(@NotNull @Valid Recommendation recommendation) {
        recommendationService.create(recommendation);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> updateById(@NotNull UUID id, @NotNull @Valid Recommendation recommendation) {
        recommendationService.updateById(id, recommendation);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> deleteById(@NotNull UUID id) {
        recommendationService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
