package br.unisinos.dev2.model;

import br.unisinos.dev2.dto.CustomerDTO;
import br.unisinos.dev2.dto.PaymentInfoDTO;
import br.unisinos.dev2.dto.ProductDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "cart")
public class CartModel extends AbstractModel {

    public CartModel() {
        products = new ArrayList<>();
    }

    public CartModel(CustomerDTO user, double cartTotal, PaymentInfoDTO paymentInfo, List<ProductDTO> products) {
        CustomerModel customerModel = new CustomerModel();
        AddressModel addressModel = new AddressModel();
        addressModel.setCity(customerModel.getAddress().getCity());
        addressModel.setCountry(customerModel.getAddress().getCountry());
        addressModel.setPhoneNumber(customerModel.getAddress().getPhoneNumber());
        addressModel.setPostalCode(customerModel.getAddress().getPostalCode());
        addressModel.setCity(customerModel.getAddress().getCity());
        addressModel.setState(customerModel.getAddress().getState());
        addressModel.setStreet(customerModel.getAddress().getStreet());
        addressModel.setStreetNumber(customerModel.getAddress().getStreetNumber());
        customerModel.setAddress(addressModel);
        PaymentInfoModel paymentInfoModel = new PaymentInfoModel(paymentInfo);
        customerModel.setPaymentInfo(paymentInfoModel);
        customerModel.setEmail(customerModel.getEmail());
        customerModel.setName(customerModel.getName());
        customerModel.setId(customerModel.getId());
        List<ProductModel> productModels = new ArrayList<>();
        ProductModel productModel;
        for (ProductDTO productItem : products) {
            productModel = new ProductModel(productItem.getUpc(), productItem.getName(), productItem.getDescription(), productItem.getPrice());
            productModels.add(productModel);
        }
        this.cartTotal = cartTotal;
        this.paymentInfo = paymentInfoModel;
        this.user = customerModel;
        this.products = productModels;
    }

    public CartModel(CartBuilder cartBuilder) {
        this.cartTotal = cartBuilder.cartTotal;
        this.paymentInfo = cartBuilder.paymentInfo;
        this.user = cartBuilder.user;
        this.products = cartBuilder.products;
    }

    @Id
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

    public static class CartBuilder {
        private String sessionId;

        private CustomerModel user;

        private double cartTotal;

        private PaymentInfoModel paymentInfo;

        private List<ProductModel> products;

        public CartBuilder(String sessionId) {
            this.sessionId = sessionId;
            products = new ArrayList<>();
        }


        public CartModel.CartBuilder withPaymentIfo(PaymentInfoModel paymentInfo) {
            this.paymentInfo = paymentInfo;
            return this;
        }

        public CartModel.CartBuilder withProducts(List<ProductModel> products) {
            this.products = products;
            return this;
        }

        public CartModel.CartBuilder withUser(CustomerModel customerModel) {
            this.user = customerModel;
            return this;
        }

        public CartModel build() {
            return new CartModel(this);
        }

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
}
