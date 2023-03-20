package com.algaworks.algalog.api.controller;

import com.algaworks.algalog.api.mapper.OccurrenceMapper;
import com.algaworks.algalog.api.model.input.OccurrenceInputModel;
import com.algaworks.algalog.api.model.output.OccurrenceOutputModel;
import com.algaworks.algalog.domain.model.Occurrence;
import com.algaworks.algalog.domain.service.OccurrenceService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OccurrenceController {

    OccurrenceMapper occurrenceMapper;
    OccurrenceService occurrenceService;

    OccurrenceController(OccurrenceMapper occurrenceMapper, OccurrenceService occurrenceService) {
        this.occurrenceMapper = occurrenceMapper;
        this.occurrenceService = occurrenceService;
    }

    @GetMapping("/deliveries/{id}/occurrences")
    public List<OccurrenceOutputModel> getAllInDelivery(@PathVariable Long id){
        List<Occurrence> occurrences = occurrenceService.getAll(id);
        List<OccurrenceOutputModel> occurrenceOutputModels = occurrenceMapper.model(occurrences);
        return occurrenceOutputModels;
    }

    @PostMapping("/deliveries/{id}/occurrences")
    public ResponseEntity<OccurrenceOutputModel> create(@PathVariable Long id, @Valid @RequestBody OccurrenceInputModel occurrence){
        Occurrence occurrenceEntity = occurrenceMapper.entity(occurrence);
        Occurrence occurrenceCreated = occurrenceService.create(id, occurrenceEntity);
        OccurrenceOutputModel occurrenceOutputModel = occurrenceMapper.model(occurrenceCreated);
        return ResponseEntity.status(201).body(occurrenceOutputModel);
    }
}
