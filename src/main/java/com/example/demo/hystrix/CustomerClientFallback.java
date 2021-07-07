package com.example.demo.hystrix;

import com.example.demo.feignclient.*;
import com.example.demo.model.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class CustomerClientFallback implements CustomerClient {
    @Override
    public List<Customer> getCustomers() {
        return Collections.emptyList();
    }

    @Override
    public Customer getById(Integer id) {
        return null;
    }

    @Override
    public List<Customer> getErrors() {
        return null;
    }
}
