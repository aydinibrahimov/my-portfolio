package com.hibernate;


import com.hibernate.entity.Customer;
import com.hibernate.requests.CustomerRequest;
import com.hibernate.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/hibernate/")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save( @RequestBody CustomerRequest customer) {
          customerService.save(customer);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Customer> getAll(@RequestBody CustomerRequest customer) {
        return customerService.getAllCustomers();
}
}
