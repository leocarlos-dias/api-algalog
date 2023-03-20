package com.algaworks.algalog.domain.model;

import com.algaworks.algalog.domain.exception.DomainException;
import com.algaworks.algalog.domain.validation.CustomerID;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "deliveries")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Valid
    @NotNull
    @ConvertGroup(from = Default.class, to = CustomerID.class)
    @ManyToOne
    private Customer customer;
    @Valid
    @NotNull
    @Embedded
    private Recipient recipient;
    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<Occurrence> occurrences;
    @NotNull
    private BigDecimal tax;
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
    @Column(name = "order_date")
    private OffsetDateTime orderDate;
    @Column(name = "delivered_date")
    private OffsetDateTime deliveredDate;

    public Occurrence registerOccurrence(String description){
        Occurrence occurrence = new Occurrence();

        occurrence.setDescription(description);
        occurrence.setRegisterDate(OffsetDateTime.now());
        occurrence.setDelivery(this);

        this.getOccurrences().add(occurrence);

        return occurrence;
    }

    public void finished(Delivery delivery, DeliveryStatus status){
        DeliveryStatus currentStatus = delivery.getStatus();
        boolean isPeding = currentStatus.equals(DeliveryStatus.PENDENTE);

        if (!isPeding) {
            throw new DomainException("A entrega não pode ser finalizada");
        }

        delivery.setStatus(status);
        delivery.setDeliveredDate(OffsetDateTime.now());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Delivery delivery)) return false;
        return id.equals(delivery.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public List<Occurrence> getOccurrences() {
        return occurrences;
    }

    public void setOccurrences(List<Occurrence> occurrences) {
        this.occurrences = occurrences;
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
