package com.example.demo.feignclient;

import com.example.demo.model.*;
import org.springframework.cloud.openfeign.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@FeignClient(
        value = "customer",
        url = "http://localhost:8080/customers",
        configuration = CustomerClientConfiguration.class)
public interface CustomerClient {

    @GetMapping(value = "/")
    List<Customer> getCustomers();

    @PostMapping(value = "/{id}")
    Customer getById(@PathVariable Integer id);

    @GetMapping(value = "/errors")
    List<Customer> getErrors();
}
