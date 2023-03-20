package com.algaworks.algalog.api.controller;

import com.algaworks.algalog.api.mapper.DeliveryMapper;
import com.algaworks.algalog.api.model.input.DeliveryInputModel;
import com.algaworks.algalog.api.model.output.DeliveryOutputModel;
import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.service.DeliveredService;
import com.algaworks.algalog.domain.service.DeliveryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeliveryController {

    private DeliveryService deliveryService;
    private DeliveredService deliveredService;
    private DeliveryMapper deliveryMapper;

    DeliveryController(DeliveryService deliveryService, DeliveryMapper deliveryMapper, DeliveredService deliveredService) {
        this.deliveryService = deliveryService;
        this.deliveryMapper = deliveryMapper;
        this.deliveredService = deliveredService;
    }

    @PostMapping("/deliveries")
    public ResponseEntity<DeliveryOutputModel> create(@Valid @RequestBody DeliveryInputModel delivery) {
        Delivery deliveryEntity = deliveryMapper.entity(delivery);
        Delivery deliveryCreated = deliveryService.create(deliveryEntity);
        DeliveryOutputModel deliveryOutputModel = deliveryMapper.model(deliveryCreated);
        return ResponseEntity.status(201).body(deliveryOutputModel);
    }

    @GetMapping("/deliveries")
    public List<DeliveryOutputModel> getAll() {
        List<Delivery> deliveries = deliveryService.get();
        List<DeliveryOutputModel> deliveriesModels = deliveryMapper.model(deliveries);
        return deliveriesModels;
    }

    @GetMapping("/deliveries/{id}")
    public DeliveryOutputModel getOne(@PathVariable Long id) {
        Delivery deliveryFound = deliveryService.get(id);
        DeliveryOutputModel deliveryOutputModel = deliveryMapper.model(deliveryFound);
        return deliveryOutputModel;
    }

    @PostMapping("/deliveries/{id}/delivered")
    public ResponseEntity<Void> delivered(@PathVariable Long id) {
        deliveredService.delivered(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/deliveries/{id}/canceled")
    public ResponseEntity<Void> canceled(@PathVariable Long id) {
        deliveredService.canceled(id);
        return ResponseEntity.noContent().build();
    }

}
