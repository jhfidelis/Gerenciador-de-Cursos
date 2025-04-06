package com.henriquefidelis.gerenciadordecursos.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHendlerController {

    private MessageSource messageSource;

    public ExceptionHendlerController (MessageSource message) {
        this.messageSource = message;
    }

    // Método que trata especificamente erros de validação dos @Valid
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorMessageDTO>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        // Lista que armazenará os objetos de erro personalizados
        List <ErrorMessageDTO> dto = new ArrayList<>();

        // Itera por cada erro de campo encontrado na validação
        e.getBindingResult().getFieldErrors().forEach(err -> {
            String message = messageSource.getMessage(err, LocaleContextHolder.getLocale()); // Pega a mensagem traduzida/localizada para o erro
            ErrorMessageDTO error = new ErrorMessageDTO(message, err.getField()); // Cria o DTO com a mensagem e o nome do campo com erro
            dto.add(error);
        });

        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }
    
}
