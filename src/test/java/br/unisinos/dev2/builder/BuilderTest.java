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
}
