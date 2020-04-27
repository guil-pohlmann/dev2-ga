package br.unisinos.dev2.dto;

import java.util.List;

public class OrderDTO implements java.io.Serializable {
    private String code;

    private CustomerDTO owner;

    private double orderTotal;

    private String currency;

    private PaymentInfoDTO paymentInfo;

    private AddressDTO deliveryAddress;

    private List<ProductDTO> products;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CustomerDTO getOwner() {
        return owner;
    }

    public void setOwner(CustomerDTO owner) {
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

    public PaymentInfoDTO getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(PaymentInfoDTO paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public AddressDTO getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(AddressDTO deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
}
