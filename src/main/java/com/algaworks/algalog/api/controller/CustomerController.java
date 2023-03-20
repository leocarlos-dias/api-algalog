package com.algaworks.algalog.api.controller;

import com.algaworks.algalog.api.mapper.CustomerMapper;
import com.algaworks.algalog.api.model.input.CustomerInputModel;
import com.algaworks.algalog.api.model.output.CustomerOutputModel;
import com.algaworks.algalog.domain.model.Customer;
import com.algaworks.algalog.domain.repository.CustomerRepository;
import com.algaworks.algalog.domain.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private CustomerService customerService;
    private CustomerMapper customerMapper;
    public CustomerController(CustomerService customerService, CustomerMapper customerMapper){
        super();
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    };

    @GetMapping("/customers")
    public List<CustomerOutputModel> getAll() {
        List<Customer> customers = customerService.get();
        List<CustomerOutputModel> customersModels = customerMapper.model(customers);
        return customersModels;
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<CustomerOutputModel> getOne(@PathVariable Long id) {
        Customer customerFound = customerService.get(id);
        CustomerOutputModel customerOutputModel = customerMapper.model(customerFound);
        return ResponseEntity.ok(customerOutputModel);
    }

    @PostMapping("/customers")
    public ResponseEntity<CustomerOutputModel> create(@Valid @RequestBody CustomerInputModel customer) {
        Customer customerEntity = customerMapper.entity(customer);
        Customer customerCreated = customerService.save(customerEntity);
        CustomerOutputModel customerOutputModel = customerMapper.model(customerCreated);
        return ResponseEntity.status(201).body(customerOutputModel);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<CustomerOutputModel> update(@PathVariable Long id,@Valid @RequestBody CustomerInputModel customer) {
        Customer customerEntity = customerMapper.entity(customer);
        Customer customerUpdated = customerService.save(customerEntity, id);
        CustomerOutputModel customerOutputModel = customerMapper.model(customerUpdated);
        return ResponseEntity.ok(customerOutputModel);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
