package br.unisinos.dev2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CartNotFoundException extends RuntimeException{
    public CartNotFoundException(){super("Not found any customer for give parameters");}
}
