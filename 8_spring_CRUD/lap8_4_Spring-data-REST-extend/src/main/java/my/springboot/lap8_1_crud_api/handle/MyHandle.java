package my.springboot.lap8_1_crud_api.handle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyHandle {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> checkAll(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());

        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

}
