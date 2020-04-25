package br.unisinos.dev2.model;

import java.util.List;

public class CartModel {

    private String sessionId;

    private CustomerModel user;

    private double cartTotal;

    private PaymentInfoModel paymentInfo;

    private List<ProductModel> products;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public CustomerModel getUser() {
        return user;
    }

    public void setUser(CustomerModel user) {
        this.user = user;
    }

    public double getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(double cartTotal) {
        this.cartTotal = cartTotal;
    }

    public PaymentInfoModel getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(PaymentInfoModel paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public List<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductModel> products) {
        this.products = products;
    }
}
