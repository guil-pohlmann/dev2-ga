package br.unisinos.dev2.dto;

import java.util.List;

public class CartDTO extends AbstractDTO {

    private CustomerDTO user;

    private double cartTotal;

    private PaymentInfoDTO paymentInfo;

    private List<ProductDTO> products;

    public CustomerDTO getUser() {
        return user;
    }

    public void setUser(CustomerDTO user) {
        this.user = user;
    }

    public double getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(double cartTotal) {
        this.cartTotal = cartTotal;
    }

    public PaymentInfoDTO getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(PaymentInfoDTO paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
}
