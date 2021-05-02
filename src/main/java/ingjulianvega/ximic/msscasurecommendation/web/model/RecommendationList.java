package ingjulianvega.ximic.msscasurecommendation.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecommendationList implements Serializable {

    static final long serialVersionUID = -6556668646011706157L;

    public ArrayList<RecommendationDto> recommendationDtoList;
}
