package br.com.saitodev.financetracker.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.saitodev.financetracker.dto.ErroResponse;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErroResponse> tratarDadosInvalidos(IllegalArgumentException ex) {
        ErroResponse erro = new ErroResponse(400, ex.getMessage());
        return ResponseEntity.badRequest().body(erro);
    }
}
