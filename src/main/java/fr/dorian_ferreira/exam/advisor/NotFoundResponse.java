package fr.dorian_ferreira.exam.advisor;

import fr.dorian_ferreira.exam.custom_response.ResponseException;
import fr.dorian_ferreira.exam.exception.NotFoundCentralishException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NotFoundResponse {

    @ResponseBody
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(NotFoundCentralishException.class)
    ResponseException notFoundResponseHandler(NotFoundCentralishException e) {
        return new ResponseException(
            HttpStatus.UNPROCESSABLE_ENTITY.value(),
            e.getType(),
            e.getField(),
            e.getValue(),
            e.getMessage()
        );
    }

}
