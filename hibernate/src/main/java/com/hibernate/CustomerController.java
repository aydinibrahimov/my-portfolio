package com.hibernate;


import com.hibernate.entity.Customer;
import com.hibernate.requests.CustomerRequest;
import com.hibernate.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/hibernate/")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save( @RequestBody CustomerRequest customer) {
      try {
          customerService.save(customer);
      }catch (Exception e){
          e.printStackTrace();
          System.err.println("MY Messagesss"+e.getMessage());
      }
    }
}
