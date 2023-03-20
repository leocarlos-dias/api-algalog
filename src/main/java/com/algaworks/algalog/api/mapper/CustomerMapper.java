package com.algaworks.algalog.api.mapper;

import com.algaworks.algalog.api.model.input.CustomerInputModel;
import com.algaworks.algalog.api.model.output.CustomerOutputModel;
import com.algaworks.algalog.domain.model.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerMapper {

    private ModelMapper modelMapper;

    public CustomerMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CustomerOutputModel model(Customer customer){
        return modelMapper.map(customer, CustomerOutputModel.class);
    }

    public List<CustomerOutputModel> model(List<Customer> customers){
        return customers.stream().map(customer -> modelMapper.map(customer, CustomerOutputModel.class)).toList();
    }

    public Customer entity(CustomerInputModel customerInputModel) {
        return modelMapper.map(customerInputModel, Customer.class);
    }

}
