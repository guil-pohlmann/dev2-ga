package br.unisinos.dev2.model;

public class CustomerModel {

    private String email;

    private String name;

    private PaymentInfoModel paymentInfo;

    private AddressModel address;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PaymentInfoModel getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(PaymentInfoModel paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public AddressModel getAddress() {
        return address;
    }

    public void setAddress(AddressModel address) {
        this.address = address;
    }
}
