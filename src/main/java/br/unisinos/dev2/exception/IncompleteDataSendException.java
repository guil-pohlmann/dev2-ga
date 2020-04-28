package br.unisinos.dev2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class IncompleteDataSendException extends RuntimeException {
    public IncompleteDataSendException() {
        super("Incomplete data sent to server");
    }
}