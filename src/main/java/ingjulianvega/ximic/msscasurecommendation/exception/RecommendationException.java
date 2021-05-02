package ingjulianvega.ximic.msscasurecommendation.exception;

import lombok.Getter;

@Getter
public class RecommendationException extends RuntimeException {

    private final String code;

    public RecommendationException(final String code, final String message) {
        super(message);
        this.code = code;
    }
}

