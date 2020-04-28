package br.unisinos.dev2.factory;

import br.unisinos.dev2.dto.*;
import br.unisinos.dev2.model.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class AbstractModelFactoryTest {

    @Resource
    private ModelFactory modelFactory;

    @Resource
    private DTOFactory dtoFactory;

    @Test
    void shouldCreateInstanceForCart() throws Exception {
        CartModel cartModel = modelFactory.create(CartModel.class);
        Assert.assertNotNull(cartModel);
    }

    @Test
    void shouldCreateInstanceForCustomer() throws Exception {
        CustomerModel customerModel = modelFactory.create(CustomerModel.class);
        Assert.assertNotNull(customerModel);
    }

    @Test
    void shouldCreateInstanceForAddress() throws Exception {
        AddressModel addressModel = modelFactory.create(AddressModel.class);
        Assert.assertNotNull(addressModel);
    }

    @Test
    void shouldCreateInstanceForOrder() throws Exception {
        OrderModel orderModel = modelFactory.create(OrderModel.class);
        Assert.assertNotNull(orderModel);
    }

    @Test
    void shouldCreateInstanceForProduct() throws Exception {
        ProductModel productModel = modelFactory.create(ProductModel.class);
        Assert.assertNotNull(productModel);
    }

    @Test
    void shouldCreateInstanceForAddressDTO() throws Exception {
        AddressDTO addressDTO = dtoFactory.create(AddressDTO.class);
        Assert.assertNotNull(addressDTO);
    }

    @Test
    void shouldCreateInstanceForCartDTO() throws Exception {
        CartDTO cartDTO = dtoFactory.create(CartDTO.class);
        Assert.assertNotNull(cartDTO);
    }

    @Test
    void shouldCreateInstanceForCustomerDTO() throws Exception {
        CustomerDTO customerDTO = dtoFactory.create(CustomerDTO.class);
        Assert.assertNotNull(customerDTO);
    }

    @Test
    void shouldCreateInstanceForOrderDTO() throws Exception {
        OrderDTO orderDTO = dtoFactory.create(OrderDTO.class);
        Assert.assertNotNull(orderDTO);
    }

    @Test
    void shouldCreateInstanceForPaymentInfoDTO() throws Exception {
        PaymentInfoDTO paymentInfoDTO = dtoFactory.create(PaymentInfoDTO.class);
        Assert.assertNotNull(paymentInfoDTO);
    }

    @Test
    void shouldCreateInstanceForProductDTO() throws Exception {
        ProductDTO productDTO = dtoFactory.create(ProductDTO.class);
        Assert.assertNotNull(productDTO);
    }
}
