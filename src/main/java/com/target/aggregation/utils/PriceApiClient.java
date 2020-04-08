package com.target.aggregation.utils;

import com.target.aggregation.config.CustomFeignConfig;
import com.target.aggregation.model.PriceObject;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "price", url = "http://localhost:8080", configuration = CustomFeignConfig.class)
public interface PriceApiClient {
    @RequestLine("GET /api/v1/price/{id}")
    PriceObject findPriceById(@Param("id") String id);
}
