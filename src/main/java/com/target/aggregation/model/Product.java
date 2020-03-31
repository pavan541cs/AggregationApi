package com.target.aggregation.model;

import java.util.List;
import java.util.Map;

public class Product {
    private String product_id;
    private String sellerId;
    private String title;
    private String pageTitle;
    private String description;
    private String manufacturer;
    private Price price;
    private boolean isLowQuantity;
    private boolean isSoldOut;
    private boolean isBackorder;
    private List<Metafields> metafields;
    private boolean requiresShipping;
    private boolean isVisible;
    private Date publishedAt;
    private Date createdAt;
    private Date updatedAt;
    private Map<String, String> workflow;

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public boolean isLowQuantity() {
        return isLowQuantity;
    }

    public void setLowQuantity(boolean lowQuantity) {
        isLowQuantity = lowQuantity;
    }

    public boolean isSoldOut() {
        return isSoldOut;
    }

    public void setSoldOut(boolean soldOut) {
        isSoldOut = soldOut;
    }

    public boolean isBackorder() {
        return isBackorder;
    }

    public void setBackorder(boolean backorder) {
        isBackorder = backorder;
    }

    public List<Metafields> getMetafields() {
        return metafields;
    }

    public void setMetafields(List<Metafields> metafields) {
        this.metafields = metafields;
    }

    public boolean isRequiresShipping() {
        return requiresShipping;
    }

    public void setRequiresShipping(boolean requiresShipping) {
        this.requiresShipping = requiresShipping;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Map<String, String> getWorkflow() {
        return workflow;
    }

    public void setWorkflow(Map<String, String> workflow) {
        this.workflow = workflow;
    }
}
