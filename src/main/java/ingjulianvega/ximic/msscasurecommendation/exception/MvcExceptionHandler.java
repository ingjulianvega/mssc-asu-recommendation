package ingjulianvega.ximic.msscasurecommendation.exception;

import ingjulianvega.ximic.msscasurecommendation.configuration.ErrorCodeMessages;
import ingjulianvega.ximic.msscasurecommendation.configuration.RecommendationParameters;
import ingjulianvega.ximic.msscasurecommendation.web.model.ApiError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MvcExceptionHandler extends ResponseEntityExceptionHandler {
    public MvcExceptionHandler(RecommendationParameters recommendationParameters) {
        this.recommendationParameters = recommendationParameters;
    }

    RecommendationParameters recommendationParameters;


    @ExceptionHandler(RecommendationException.class)
    public ResponseEntity<ApiError> validationErrorHandler(RecommendationException ame) {
        ApiError apiError = ApiError
                .builder()
                .timestamp(LocalDateTime.now())
                .api(recommendationParameters.getApi())
                .apiCode(ame.getApiCode())
                .error(ame.getError())
                .message(ame.getMessage())
                .solution(ame.getSolution())
                .build();
         return new ResponseEntity<>(apiError, ame.getHttpStatus());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        ApiError apiError = ApiError
                .builder()
                .timestamp(LocalDateTime.now())
                .api(recommendationParameters.getApi())
                .apiCode(ErrorCodeMessages.ARGUMENT_NOT_VALID_API_CODE)
                .error(ErrorCodeMessages.ARGUMENT_NOT_VALID_ERROR)
                .message(errors.toString())
                .solution(ErrorCodeMessages.ARGUMENT_NOT_VALID_SOLUTION)
                .build();

        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
}