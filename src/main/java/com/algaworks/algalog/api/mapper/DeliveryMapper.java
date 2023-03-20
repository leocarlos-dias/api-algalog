package com.algaworks.algalog.api.mapper;

import com.algaworks.algalog.api.model.input.DeliveryInputModel;
import com.algaworks.algalog.api.model.output.DeliveryOutputModel;
import com.algaworks.algalog.domain.model.Delivery;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeliveryMapper {
    private ModelMapper modelMapper;

    public DeliveryMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public DeliveryOutputModel model(Delivery delivery){
        return modelMapper.map(delivery, DeliveryOutputModel.class);
    }

    public List<DeliveryOutputModel> model(List<Delivery> deliveries){
        return deliveries.stream().map(delivery -> modelMapper.map(delivery, DeliveryOutputModel.class)).toList();
    }

    public Delivery entity(DeliveryInputModel deliveryInputModel) {
        return modelMapper.map(deliveryInputModel, Delivery.class);
    }
}
