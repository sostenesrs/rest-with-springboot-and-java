package br.com.erudio.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST) //para retornar statusCode, deve ter o mesmo codigo de statusCode de onde é chamada na response entity
public class UnsupportedMathOperationException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public UnsupportedMathOperationException(String message) {
        super(message);
    }
}
