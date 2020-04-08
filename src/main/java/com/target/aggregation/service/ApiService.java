package com.target.aggregation.service;

import com.target.aggregation.config.ApiConfiguration;
import com.target.aggregation.model.Price;
import com.target.aggregation.model.PriceObject;
import com.target.aggregation.model.Product;
import com.target.aggregation.utils.PriceApiClient;
import com.target.aggregation.utils.ProductApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class ApiService {
    @Autowired
    ApiConfiguration apiConfiguration;

    @Autowired
    ProductApiClient productApiClient;

    @Autowired
    PriceApiClient priceApiClient;

    @Async
    public CompletableFuture<Product> getProductById(String id) {
        return CompletableFuture.completedFuture(productApiClient.findProductById(id));
    }

    @Async
    public CompletableFuture<PriceObject> getPriceById(String id) {
        return CompletableFuture.completedFuture(priceApiClient.findPriceById(id));
    }
}
