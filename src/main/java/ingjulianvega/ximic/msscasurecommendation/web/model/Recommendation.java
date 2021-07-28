package ingjulianvega.ximic.msscasurecommendation.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recommendation implements Serializable {

    static final long serialVersionUID = 6001633709517906637L;

    @NotNull
    private UUID visitId;
    @NotNull
    private UUID recommendationTypeId;
    private String observations;

}
