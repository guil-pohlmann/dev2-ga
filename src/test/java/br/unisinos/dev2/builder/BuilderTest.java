package br.unisinos.dev2.builder;

import br.unisinos.dev2.dto.AddressDTO;
import br.unisinos.dev2.dto.PaymentInfoDTO;
import br.unisinos.dev2.model.CartModel;
import br.unisinos.dev2.model.CustomerModel;
import br.unisinos.dev2.model.PaymentInfoModel;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class BuilderTest {

    @Test
    void shouldBuildCartForAnonymousUser() {
        CartModel cartModel = new CartModel.CartBuilder("sessionID")
                .withPaymentIfo(new PaymentInfoModel(new PaymentInfoDTO()))
                .withProducts(new ArrayList<>())
                .withUser(new CustomerModel())
                .build();

        Assert.assertNotNull(cartModel);
        Assert.assertNotNull(cartModel.getPaymentInfo());
        Assert.assertNotNull(cartModel.getProducts());
        Assert.assertNotNull(cartModel.getUser());

    }

    @Test
    void shouldBuildCustomer() {
        CustomerModel customer = new CustomerModel.CustomerBuilder("testuser@mail.com", "myname")
                .withAddress(new AddressDTO())
                .withPaymentIfo(new PaymentInfoDTO())
                .build();
        Assert.assertNotNull(customer);
        Assert.assertNotNull(customer.getAddress());
        Assert.assertNotNull(customer.getPaymentInfo());
    }

    @Test
    void shouldBuildCustomerWithNoAddress(){
        CustomerModel customer = new CustomerModel.CustomerBuilder("test@mail.com", "test name")
                .withPaymentIfo(new PaymentInfoDTO())
                .build();
        Assert.assertNotNull(customer);
        Assert.assertNotNull(customer.getPaymentInfo());
        Assert.assertNull(customer.getAddress());
    }

    @Test
    void shouldBuildCustomerWithNoPaymentInfo(){
        CustomerModel customer = new CustomerModel.CustomerBuilder("test@mail.com", "test name")
                .withAddress(new AddressDTO())
                .build();
        Assert.assertNotNull(customer);
        Assert.assertNotNull(customer.getAddress());
        Assert.assertNull(customer.getPaymentInfo());
    }

    @Test
    void shouldBuildCustomerWithNoPaymentInfoAndNoAddress(){
        String email = "test@mail.com";
        String name = "test name";
        CustomerModel customer = new CustomerModel.CustomerBuilder(email, name)
                .build();
        Assert.assertNotNull(customer);
        Assert.assertNull(customer.getAddress());
        Assert.assertNull(customer.getPaymentInfo());
        Assert.assertEquals(customer.getEmail(), email);
        Assert.assertEquals(customer.getName(), name);
    }
}
