package com.example.demo.controller;

import com.example.demo.model.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import java.util.*;

@RestController
public class MainController {

    @GetMapping
    public String index(){
        return "INDEX";
    }

    @GetMapping(value = "/customers")
    public List<Customer> getCustomers(HttpServletRequest request){
        String token = request.getHeader("token");
        System.out.println(token);
        return Arrays.asList(new Customer(1, "ABC"), new Customer(2, "CDF"));
    }

    @PostMapping(value = "/customers/{id}")
    public Customer getById(@PathVariable Integer id){
        return new Customer(id, "ABC");
    }

    @GetMapping(value = "/customers/errors")
    public List<Customer> errors(){
        throw new IllegalArgumentException();
    }
}
