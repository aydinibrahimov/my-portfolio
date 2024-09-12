package com.hibernate.service;

import com.hibernate.entity.Customer;
import com.hibernate.entity.Metadata;
import com.hibernate.repository.CustomerRepository;
import com.hibernate.requests.CustomerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void save(CustomerRequest customerRequest) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        LocalDateTime ldt = LocalDateTime.now();
        Metadata metadata = new Metadata();
        metadata.setCreateDate(ldt.format(formatter));
        Customer customer = new Customer();
        customer.setMetadata(metadata);
        customer.setName(customerRequest.name);

        customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

}
