package com.algaworks.algalog.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Embeddable
public class Recipient {

    @NotBlank
    @Column(name = "recipient_name")
    private String name;

    @NotBlank
    @Column(name = "recipient_street")
    private String street;

    @NotBlank
    @Column(name = "recipient_number")
    private String number;

    @Column(name = "recipient_complement")
    private String complement;

    @NotBlank
    @Column(name = "recipient_neighborhood")
    private String neighborhood;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
}
