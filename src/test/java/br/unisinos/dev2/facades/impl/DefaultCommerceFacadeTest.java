package br.unisinos.dev2.facades.impl;

import br.unisinos.dev2.dto.CartDTO;
import br.unisinos.dev2.dto.ProductDTO;
import br.unisinos.dev2.facades.CommerceFacade;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DefaultCommerceFacadeTest {

    @Resource
    private CommerceFacade defaultCommerceFacade;

    private static final String PRODUCT_CODE = "PRODUCT_CODE";
    private static final String PRODUCT_DESCRIPTION = "PRODUCT_DESC";
    private static final String PRODUCT_NAME = "PRODUCT_NAME";
    private static final String PRODUCT_UPC = "123123123123";
    private static final double PRODUCT_PRICE = 123.12;

    @Test
    void addProductToCart() {
        ProductDTO productDTO = mockProductDTO();
        CartDTO cartDTO = defaultCommerceFacade.addProductToCart(productDTO);
        assertNotNull(cartDTO);
    }

    @Test
    void placeOrder() {
    }

    @Test
    void getCurrentCustomer() {
    }

    ProductDTO mockProductDTO(){
        ProductDTO product = new ProductDTO();
        product.setCode(PRODUCT_CODE);
        product.setDescription(PRODUCT_DESCRIPTION);
        product.setName(PRODUCT_NAME);
        product.setPrice(PRODUCT_PRICE);
        product.setUpc(PRODUCT_UPC);

        return product;
    }
}