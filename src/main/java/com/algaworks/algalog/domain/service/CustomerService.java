package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.domain.exception.DomainException;
import com.algaworks.algalog.domain.exception.EntityException;
import com.algaworks.algalog.domain.model.Customer;
import com.algaworks.algalog.domain.repository.CustomerRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        super();
        this.customerRepository = customerRepository;
    };

    public List<Customer> get(){
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }

    public Customer get(Long id){
        Optional<Customer> customerFound = customerRepository.findById(id);

        if(!customerFound.isPresent()) {
            throw new EntityException("Usuário não encontrado");
        }

        return customerFound.get();
    }

    @Transactional
    public Customer save(Customer customer) {
        boolean customerAlreadyExists = customerRepository.findByEmail(customer.getEmail())
                .stream()
                .anyMatch(customerExists -> !customerExists.equals(customer));

        if(customerAlreadyExists) {
            throw new DomainException("E-mail já está sendo utilizado");
        }

        Customer customerCreated = customerRepository.save(customer);
        return customerCreated;
    }

    @Transactional
    public Customer save(Customer customer, Long id) {
        boolean customerExists = customerRepository.existsById(id);

        if (!customerExists) {
            throw new DomainException("Usuário não encontrado");
        }

        customer.setId(id);
        Customer customerUpdated = customerRepository.save(customer);
        return customerUpdated;
    }

    @Transactional
    public void delete(Long id){
        boolean customerExists = customerRepository.existsById(id);

        if (!customerExists) {
            throw new DomainException("Usuário não encontrado");
        }

        customerRepository.deleteById(id);
    }


}
