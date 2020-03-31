package com.target.aggregation.service;

import com.target.aggregation.config.ApiConfiguration;
import com.target.aggregation.model.Price;
import com.target.aggregation.model.PriceObject;
import com.target.aggregation.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class ApiService {
    @Autowired
    ApiConfiguration apiConfiguration;

    RestTemplate restTemplate = new RestTemplate();

    @Async
    public CompletableFuture<Product> getProductById(String id) {
        String url = apiConfiguration.getProductApi() + "/api/v1/product/" + id;
        return CompletableFuture.completedFuture(restTemplate.getForObject(url, Product.class));
    }

    @Async
    public CompletableFuture<PriceObject> getPriceById(String id) {
        String url = apiConfiguration.getPriceApi() + "/api/v1/price/" + id;
        return CompletableFuture.completedFuture(restTemplate.getForObject(url, PriceObject.class));
    }
}
