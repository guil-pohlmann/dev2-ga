package br.unisinos.dev2.model;

import br.unisinos.dev2.dto.AddressDTO;
import br.unisinos.dev2.dto.PaymentInfoDTO;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;


@Document(collection = "customer")
public class CustomerModel extends AbstractModel {

    @Id
    private String id;

    private String email;

    private String name;

    private PaymentInfoModel paymentInfo;

    private AddressModel address;

    public CustomerModel(){}

    private CustomerModel(CustomerBuilder builder){
        this.email = builder.email;
        this.address = builder.address;
        this.name = builder.name;
        this.paymentInfo = builder.paymentInfo;
    }

    public static class CustomerBuilder{
        private String email;
        private String name;
        private PaymentInfoModel paymentInfo;
        private AddressModel address;

        public CustomerBuilder(String email, String name){
            this.name = name;
            this.email = email;
        }

        public CustomerBuilder withPaymentIfo(PaymentInfoDTO paymentIfo){
            this.paymentInfo = new PaymentInfoModel(paymentIfo);
            return this;
        }

        public CustomerBuilder withAddress(AddressDTO address){
            this.address = new AddressModel(address);
            return this;
        }

        public CustomerModel build(){
            return new CustomerModel(this);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
