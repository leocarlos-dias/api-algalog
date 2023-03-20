package com.algaworks.algalog.api.model.input;

import jakarta.validation.constraints.NotBlank;

public class OccurrenceInputModel {

    @NotBlank
    String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
