package br.unisinos.dev2.strategy.impl;

import br.unisinos.dev2.context.ConverterContext;
import br.unisinos.dev2.dto.*;
import br.unisinos.dev2.model.CartModel;
import br.unisinos.dev2.strategy.PopulatorStrategy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class CartPopulatorStrategy implements PopulatorStrategy<CartModel, CartDTO> {

    @Resource
    private ConverterContext converterContext;

    @Override
    public void populate(CartModel source, CartDTO target) {
        target.setCartTotal(source.getCartTotal());

        converterContext.setPopulatorStrategy(new CustomerPopulatorStrategy());
        target.setUser(converterContext.convert(source.getUser(), target.getUser().getClass()));

        converterContext.setPopulatorStrategy(new PaymentInfoPopulatorStrategy());
        target.setPaymentInfo(converterContext.convert(source.getPaymentInfo(), target.getPaymentInfo().getClass()));

        converterContext.setPopulatorStrategy(new ProductPopulatorStrategy());
        target.setProducts(converterContext.convertAll(source.getProducts(), ProductDTO.class));
    }
}
