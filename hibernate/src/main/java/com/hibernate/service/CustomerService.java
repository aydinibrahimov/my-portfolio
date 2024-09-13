package com.hibernate.service;

import com.hibernate.entity.Customer;
import com.hibernate.entity.CustomerType;
import com.hibernate.entity.Metadata;
import com.hibernate.entity.Product;
import com.hibernate.repository.CustomerRepository;
import com.hibernate.requests.CustomerRequest;
import com.hibernate.utils.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final Util util;

    public void save(CustomerRequest customerRequest) {
        Metadata metadata = new Metadata();


        metadata.setCreateDate(util.currentDateTime());
        Customer customer = new Customer();
        customer.setMetadata(metadata);
        customer.setCustomerType(CustomerType.REGULAR);
        customer.setName(customerRequest.name);
        List<Product> products = customerRequest.getProduct().stream()
                .map(req -> Product.builder()
                        .title(req.getTitle())
                        .customer(customer)
                        .build())
                .collect(Collectors.toList());
        customer.setProducts(products);
        customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

}
