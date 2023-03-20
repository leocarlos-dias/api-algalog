package com.algaworks.algalog.api.model.output;

import com.algaworks.algalog.domain.model.DeliveryStatus;


import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class DeliveryOutputModel {
    private Long id;
    private CustomerInfoOutputModel customer;
    private RecipientOutputModel recipient;
    private BigDecimal tax;
    private DeliveryStatus status;
    private OffsetDateTime orderDate;
    private OffsetDateTime deliveredDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerInfoOutputModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerInfoOutputModel customer) {
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

    public DeliveryStatus getStatus() {
        return status;
    }

    public void setStatus(DeliveryStatus status) {
        this.status = status;
    }

    public OffsetDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(OffsetDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OffsetDateTime getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(OffsetDateTime deliveredDate) {
        this.deliveredDate = deliveredDate;
    }
}

