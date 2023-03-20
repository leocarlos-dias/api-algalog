package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.model.DeliveryStatus;
import com.algaworks.algalog.domain.repository.DeliveryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeliveredService {

    DeliveryService deliveryService;
    DeliveryRepository deliveryRepository;

    DeliveredService(DeliveryService deliveryService, DeliveryRepository deliveryRepository) {
        this.deliveryService = deliveryService;
        this.deliveryRepository = deliveryRepository;
    }

    @Transactional
    public void delivered(Long id) {
        Delivery deliveryFound = deliveryService.get(id);
        deliveryFound.finished(deliveryFound, DeliveryStatus.ENTREGUE);
        deliveryRepository.save(deliveryFound);
    }

    @Transactional
    public void canceled(Long id) {
        Delivery deliveryFound = deliveryService.get(id);
        deliveryFound.finished(deliveryFound, DeliveryStatus.CANCELADO);
        deliveryRepository.save(deliveryFound);
    }
}
