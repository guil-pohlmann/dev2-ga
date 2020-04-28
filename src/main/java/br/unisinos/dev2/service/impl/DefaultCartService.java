package br.unisinos.dev2.service.impl;

import br.unisinos.dev2.context.ConverterContext;
import br.unisinos.dev2.dto.ProductDTO;
import br.unisinos.dev2.factory.ModelFactory;
import br.unisinos.dev2.model.CartModel;
import br.unisinos.dev2.model.ProductModel;
import br.unisinos.dev2.service.CartService;
import br.unisinos.dev2.strategy.impl.DtoToModelProductPopulatorStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Component
public class DefaultCartService implements CartService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultCartService.class);

    private CartModel cartModel;

    @Resource
    private ModelFactory modelFactory;

    @Resource
    private ConverterContext converterContext;

    @Override
    public CartModel getCurrentCart() {
        if (nonNull(cartModel))
            return cartModel;
        try {
            cartModel = modelFactory.create(CartModel.class);
            return cartModel;
        } catch (Exception exception) {
            System.out.println("Error while returning current cart");
            return null;
        }
    }

    @Override
    public void calculateCart(CartModel cartModel) {
        if (nonNull(cartModel.getProducts())) {
            double cartTotal = cartModel.getProducts()
                    .stream()
                    .map(ProductModel::getPrice)
                    .collect(Collectors.summarizingDouble(Double::doubleValue))
                    .getSum();

            cartModel.setCartTotal(cartTotal);
        }
    }

    @Override
    public void addToCart(ProductModel productModel) {
        if (nonNull(cartModel)) {
            cartModel.getProducts().add(productModel);
            calculateCart(cartModel);
        }
    }

    public void addToCart(ProductDTO productDTO){
        try {
            converterContext.setPopulatorStrategy(new DtoToModelProductPopulatorStrategy());
            ProductModel productModel = converterContext.convert(productDTO, ProductModel.class);
            addToCart(productModel);
        } catch (Exception e){
            LOGGER.error("Error creating model using {}", ModelFactory.class);
        }
    }

    @Override
    public void addToCart(List<ProductModel> products) {
        products.forEach(this::addToCart);
    }
}
