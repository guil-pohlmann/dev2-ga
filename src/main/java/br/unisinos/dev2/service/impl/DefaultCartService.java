package br.unisinos.dev2.service.impl;

import br.unisinos.dev2.factory.ModelFactory;
import br.unisinos.dev2.model.CartModel;
import br.unisinos.dev2.model.ProductModel;
import br.unisinos.dev2.service.CartService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Component
public class DefaultCartService implements CartService {
    private CartModel cartModel;
    @Resource
    private ModelFactory modelFactory;

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

    @Override
    public void addToCart(List<ProductModel> products) {
        products.forEach(this::addToCart);
    }
}
