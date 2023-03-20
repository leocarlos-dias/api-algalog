package com.algaworks.algalog.api.model.input;

import com.algaworks.algalog.api.model.output.RecipientOutputModel;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class DeliveryInputModel {

    @Valid
    @NotNull
    private CustomerInfoInputModel customer;

    @Valid
    @NotNull
    private RecipientOutputModel recipient;

    @NotNull
    private BigDecimal tax;

    public CustomerInfoInputModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerInfoInputModel customer) {
        this.customer = customer;
    }

    public RecipientOutputModel getRecipient() {
        return recipient;
    }

    public void setRecipient(RecipientOutputModel recipient) {
        this.recipient = recipient;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }
}

