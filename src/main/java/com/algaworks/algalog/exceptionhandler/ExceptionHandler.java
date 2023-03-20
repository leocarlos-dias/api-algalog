package com.algaworks.algalog.exceptionhandler;

import com.algaworks.algalog.domain.exception.DomainException;
import com.algaworks.algalog.domain.exception.EntityException;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    private MessageSource messageSource;

    public ExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        List<FieldsError> fields = new ArrayList<>();

        ex.getBindingResult().getAllErrors().forEach(error -> {
            String name = ((FieldError) error).getField();
            String description = messageSource.getMessage(error, LocaleContextHolder.getLocale());

            fields.add(new FieldsError(name, description));
        });

        CustomError customError = new CustomError();
        customError.setStatus(status.value());
        customError.setDateTime(OffsetDateTime.now());
        customError.setFieldError(fields);
        customError.setTitle("Campos inválidos");

        return handleExceptionInternal(ex, customError, headers, status, request);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(EntityException.class)
    protected ResponseEntity<Object> handleEntityException(EntityException ex, WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        CustomError customError = new CustomError();
        customError.setStatus(status.value());
        customError.setDateTime(OffsetDateTime.now());
        customError.setTitle(ex.getMessage());

        return handleExceptionInternal(ex, customError, new HttpHeaders(), status, request);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(DomainException.class)
    protected ResponseEntity<Object> handleDomainException(DomainException ex, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        CustomError customError = new CustomError();
        customError.setStatus(status.value());
        customError.setDateTime(OffsetDateTime.now());
        customError.setTitle(ex.getMessage());

        return handleExceptionInternal(ex, customError, new HttpHeaders(), status, request);
    }
}
