package ingjulianvega.ximic.msscasurecommendation.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class RecommendationEntity extends BaseEntity {

    private UUID visitId;
    private UUID recommendationTypeId;
    private String observations;
}
