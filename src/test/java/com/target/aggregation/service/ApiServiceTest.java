package com.target.aggregation.service;

import com.target.aggregation.config.ApiConfiguration;
import com.target.aggregation.model.Price;
import com.target.aggregation.model.PriceObject;
import com.target.aggregation.model.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ApiServiceTest {
    private ApiService apiService;
    private RestTemplate restTemplate;
    private Product product;
    private PriceObject price;

    @Before
    public void setUp() {
        ApiConfiguration apiConfiguration = new ApiConfiguration();
        apiConfiguration.setPriceApi("a");
        apiConfiguration.setProductApi("b");
        apiService = Mockito.spy(new ApiService());
        restTemplate = Mockito.mock(RestTemplate.class);
        apiService.restTemplate = restTemplate;
        apiService.apiConfiguration = apiConfiguration;
    }

    @Test
    public void getProduct() throws ExecutionException, InterruptedException {
        this.resetProductData();
        when(restTemplate.getForObject("b/api/v1/product/12345678", Product.class)).thenReturn(product);

        Product product = apiService.getProductById("12345678").get();
        assertNotNull(product);
        assertEquals("12345", product.getSellerId());
    }

    @Test
    public void getPrice() throws ExecutionException, InterruptedException {
        this.resetPriceData();
        when(restTemplate.getForObject("a/api/v1/price/12345678", PriceObject.class)).thenReturn(price);

        PriceObject pr = apiService.getPriceById("12345678").get();
        assertNotNull(pr);
        assertEquals("4-5", pr.getPrice().getRange());
    }

    private void resetProductData() {
        product = new Product();
        product.setProduct_id("12345678");
        product.setSellerId("12345");
    }

    private void resetPriceData() {
        price = new PriceObject();
        price.setProduct_id("12345678");
        Price price1 = new Price();
        price1.setMax(5);
        price1.setMin(4);
        price1.setRange("4-5");
        price.setPrice(price1);
    }
}
