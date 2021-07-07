package com.example.demo.controller;

import com.example.demo.feignclient.*;
import com.example.demo.model.*;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {
    private final CustomerClient customerClient;

    @GetMapping(value = "/customers")
    public List<Customer> getCustomers(){
        return customerClient.getCustomers();
    }

    @PostMapping(value = "/customers/{id}")
    public Customer getById(@PathVariable Integer id){
        return customerClient.getById(id);
    }

    @GetMapping(value = "/customers/errors")
    public List<Customer> errors(){
        return customerClient.getErrors();
    }
}
