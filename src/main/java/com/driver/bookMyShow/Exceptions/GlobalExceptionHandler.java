package com.driver.bookMyShow.Exceptions;

import com.driver.bookMyShow.ResponseAPI.ResonponseAPI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AlreadyPresentException.class)
    public ResponseEntity<ResonponseAPI<Object>> handleAllExceptions(AlreadyPresentException ex) {
        System.out.println("--------------------------this is inside the gloable execption handler");
        ResonponseAPI<Object> response = ResonponseAPI.<Object>builder()
                .message(ex.getMessage())
                .status(HttpStatus.CONFLICT.value())
                .build();
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(RequestFailedException.class)
    public ResponseEntity<ResonponseAPI<Object>> handleAllExceptions(RequestFailedException ex) {
        System.out.println("--------------------------this is inside the gloable execption handler");
        ResonponseAPI<Object> response = ResonponseAPI.<Object>builder()
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotActiveException.class)
    public ResponseEntity<ResonponseAPI<Object>> handleAllExceptions(NotActiveException ex) {
        System.out.println("--------------------------this is inside the gloable execption handler");
        ResonponseAPI<Object> response = ResonponseAPI.<Object>builder()
                .message(ex.getMessage())
                .status(HttpStatus.FORBIDDEN.value())
                .build();
        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(NotFoundExecption.class)
    public ResponseEntity<ResonponseAPI<Object>> handleAllExceptions(NotFoundExecption ex) {
        System.out.println("--------------------------this is inside the gloable execption handler");
        ResonponseAPI<Object> response = ResonponseAPI.<Object>builder()
                .message(ex.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotValidExecption.class)
    public ResponseEntity<ResonponseAPI<Object>> handleAllExceptions(NotValidExecption ex) {
        System.out.println("--------------------------this is inside the gloable execption handler");
        ResonponseAPI<Object> response = ResonponseAPI.<Object>builder()
                .message(ex.getMessage())
                .status(HttpStatus.UNPROCESSABLE_ENTITY.value())
                .build();
        return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(InvalidType.class)
    public ResponseEntity<ResonponseAPI<Object>> hadleAllException(InvalidType ex) {
        ResonponseAPI<Object> resonpons = ResonponseAPI.<Object>builder()
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .build();
        return new ResponseEntity<>(resonpons, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResonponseAPI<Object>> handleAllExceptions(Exception ex) {

        ResonponseAPI<Object> response = ResonponseAPI.<Object>builder()
                .message(ex.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
