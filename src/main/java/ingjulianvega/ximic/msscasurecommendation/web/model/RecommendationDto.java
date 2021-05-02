package ingjulianvega.ximic.msscasurecommendation.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecommendationDto implements Serializable {

    static final long serialVersionUID = 2681878804702720671L;

    private UUID id;
    private UUID visitId;
    private UUID recommendationTypeId;
    private String observations;

}
