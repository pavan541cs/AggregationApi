package com.target.aggregation.controller;

import com.target.aggregation.model.Price;
import com.target.aggregation.model.PriceObject;
import com.target.aggregation.model.Product;
import com.target.aggregation.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/aggregated")
public class AggregationController {

    @Autowired
    ApiService apiService;

    @GetMapping("/{id}")
    public Product getAggregatedDetailsForProductId(@PathVariable String id) throws Throwable {
        Product product;
        try {
            CompletableFuture<Product> productCompletableFuture = apiService.getProductById(id);
            CompletableFuture<PriceObject> priceCompletableFuture = apiService.getPriceById(id);
            product = productCompletableFuture.get();
            Price price = priceCompletableFuture.get().getPrice();
            product.setPrice(price);
        } catch (Throwable e) {
            throw e.getCause();
        }
        return product;
    }
}
