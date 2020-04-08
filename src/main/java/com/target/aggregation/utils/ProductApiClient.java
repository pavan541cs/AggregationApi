package com.target.aggregation.utils;

import com.target.aggregation.config.CustomFeignConfig;
import com.target.aggregation.model.Product;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "product", url = "http://localhost:8081", configuration = CustomFeignConfig.class)
public interface ProductApiClient {
    @RequestLine("GET /api/v1/product/{id}")
    Product findProductById(@Param("id") String id);
}
