package br.unisinos.dev2.model;

import java.util.List;

public class OrderModel {

    private String code;

    private CustomerModel owner;

    private double orderTotal;

    private String currency;

    private PaymentInfoModel paymentInfo;

    private AddressModel deliveryAddress;

    private List<ProductModel> products;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CustomerModel getOwner() {
        return owner;
    }

    public void setOwner(CustomerModel owner) {
        this.owner = owner;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public PaymentInfoModel getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(PaymentInfoModel paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public AddressModel getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(AddressModel deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public List<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductModel> products) {
        this.products = products;
    }
}
