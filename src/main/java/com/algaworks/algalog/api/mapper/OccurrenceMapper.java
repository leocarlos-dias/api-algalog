package com.algaworks.algalog.api.mapper;

import com.algaworks.algalog.api.model.input.CustomerInputModel;
import com.algaworks.algalog.api.model.input.OccurrenceInputModel;
import com.algaworks.algalog.api.model.output.CustomerOutputModel;
import com.algaworks.algalog.api.model.output.OccurrenceOutputModel;
import com.algaworks.algalog.domain.model.Customer;
import com.algaworks.algalog.domain.model.Occurrence;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OccurrenceMapper {
    private ModelMapper modelMapper;

    public OccurrenceMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public OccurrenceOutputModel model(Occurrence occurrence){
        return modelMapper.map(occurrence, OccurrenceOutputModel.class);
    }

    public List<OccurrenceOutputModel> model(List<Occurrence> occurrences){
        return occurrences.stream().map(occurrence -> modelMapper.map(occurrence, OccurrenceOutputModel.class)).toList();
    }

    public Occurrence entity(OccurrenceInputModel occurrenceInputModel) {
        return modelMapper.map(occurrenceInputModel, Occurrence.class);
    }
}
