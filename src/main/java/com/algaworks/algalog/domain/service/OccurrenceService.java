package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.model.Occurrence;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OccurrenceService {

    DeliveryService deliveryService;

    OccurrenceService(DeliveryService deliveryService){
        this.deliveryService = deliveryService;
    }

    @Transactional
    public Occurrence create(Long id, Occurrence occurrence){
        Delivery deliveryFound = deliveryService.get(id);
        Occurrence occurrenceCreated = deliveryFound.registerOccurrence(occurrence.getDescription());

        return occurrenceCreated;
    }

    public List<Occurrence> getAll(Long id) {
        Delivery deliveryFound = deliveryService.get(id);
        List<Occurrence> occurrences = deliveryFound.getOccurrences();
        return occurrences;
    }

}
