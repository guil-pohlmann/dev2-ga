package br.unisinos.dev2.context.impl;

import br.unisinos.dev2.context.ConverterContext;
import br.unisinos.dev2.dto.OrderDTO;
import br.unisinos.dev2.dto.ProductDTO;
import br.unisinos.dev2.factory.DTOFactory;
import br.unisinos.dev2.model.OrderModel;
import br.unisinos.dev2.model.ProductModel;
import br.unisinos.dev2.strategy.PopulatorStrategy;
import br.unisinos.dev2.strategy.impl.ModelToDTOOrderPopulatorStrategy;
import br.unisinos.dev2.strategy.impl.ModelToDTOProductPopulatorStrategy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestExecution;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;

@SpringBootTest
class DefaultConverterContextTest {

    @Resource
    private ConverterContext defaultConverterContext;

    private static final String PRODUCT_CODE = "PRODUCT_CODE";
    private static final String PRODUCT_DESCRIPTION = "PRODUCT_DESC";
    private static final String PRODUCT_NAME = "PRODUCT_NAME";
    private static final String PRODUCT_UPC = "123123123123";
    private static final double PRODUCT_PRICE = 123.12;

    @Test
    void shouldConvertProductModelToProductDtoWhenUsingProductPopulatorStrategy() {
        defaultConverterContext.setPopulatorStrategy(new ModelToDTOProductPopulatorStrategy());
        ProductModel productModel = mockProductModel();
        ProductDTO productDTO = defaultConverterContext.convert(productModel, ProductDTO.class);

        assertEquals(productModel.getCode(), productDTO.getCode());
        assertEquals(productModel.getDescription(), productDTO.getDescription());
        assertEquals(productModel.getName(), productDTO.getName());
        assertEquals(productModel.getUpc(), productDTO.getUpc());
        assertEquals(productModel.getPrice(), productDTO.getPrice(), 0.0);
    }

    ProductModel mockProductModel(){
        ProductModel productModel = new ProductModel();
        productModel.setCode(PRODUCT_CODE);
        productModel.setDescription(PRODUCT_DESCRIPTION);
        productModel.setName(PRODUCT_NAME);
        productModel.setPrice(PRODUCT_PRICE);
        productModel.setUpc(PRODUCT_UPC);

        return productModel;
    }
}
