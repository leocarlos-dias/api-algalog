package com.algaworks.algalog.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomError {
    private Integer status;
    private OffsetDateTime dateTime;
    private String title;
    private List<FieldsError> fieldsError;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public OffsetDateTime getDateTime(OffsetDateTime now) {
        return dateTime;
    }

    public void setDateTime(OffsetDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<FieldsError> getFieldError() {
        return fieldsError;
    }

    public void setFieldError(List<FieldsError> fieldError) {
        this.fieldsError = fieldError;
    }
}
