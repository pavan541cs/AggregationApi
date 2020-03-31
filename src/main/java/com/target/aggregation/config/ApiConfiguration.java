package com.target.aggregation.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("api")
public class ApiConfiguration {
    private String PriceApi;
    private String ProductApi;

    public String getPriceApi() {
        return PriceApi;
    }

    public void setPriceApi(String priceApi) {
        PriceApi = priceApi;
    }

    public String getProductApi() {
        return ProductApi;
    }

    public void setProductApi(String productApi) {
        ProductApi = productApi;
    }
}
