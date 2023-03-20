package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.domain.exception.EntityException;
import com.algaworks.algalog.domain.model.Customer;
import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.model.DeliveryStatus;
import com.algaworks.algalog.domain.repository.DeliveryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {

    DeliveryRepository deliveryRepository;
    CustomerService customerService;
    DeliveryService(DeliveryRepository deliveryRepository, CustomerService customerService) {
        this.deliveryRepository = deliveryRepository;
        this.customerService = customerService;
    }
    
    public List<Delivery> get(){
        List<Delivery> deliveries = deliveryRepository.findAll();
        return deliveries;
    }

    public Delivery get(Long id){
        Optional<Delivery> deliveryFound = deliveryRepository.findById(id);

        if(!deliveryFound.isPresent()) {
            throw new EntityException("Entrega não encontrada");
        }

        return deliveryFound.get();
    }
    @Transactional
    public Delivery create(Delivery delivery){
        Customer customerFound = customerService.get(delivery.getCustomer().getId());

        delivery.setCustomer(customerFound);
        delivery.setStatus(DeliveryStatus.PENDENTE);
        delivery.setOrderDate(OffsetDateTime.now());
        Delivery deliveryCreated = deliveryRepository.save(delivery);
        return deliveryCreated;
    }
}
