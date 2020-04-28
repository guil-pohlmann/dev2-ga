package br.unisinos.dev2.strategy.impl;

import br.unisinos.dev2.context.ConverterContext;
import br.unisinos.dev2.context.impl.DefaultConverterContext;
import br.unisinos.dev2.dto.*;
import br.unisinos.dev2.model.CartModel;
import br.unisinos.dev2.strategy.PopulatorStrategy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static java.util.Objects.isNull;

@Component
public class ModelToDTOCartPopulatorStrategy implements PopulatorStrategy<CartModel, CartDTO> {

    @Resource
    private ConverterContext defaultConverterContext;

    @Override
    public void populate(CartModel source, CartDTO target) {
        target.setCartTotal(source.getCartTotal());
        createContextIfNull();

        defaultConverterContext.setPopulatorStrategy(new ModelToDTOCustomerPopulatorStrategy());
        target.setUser(defaultConverterContext.convert(source.getUser(), CustomerDTO.class));

        defaultConverterContext.setPopulatorStrategy(new ModelToDTOPaymentInfoPopulatorStrategy());
        target.setPaymentInfo(defaultConverterContext.convert(source.getPaymentInfo(), PaymentInfoDTO.class));

        defaultConverterContext.setPopulatorStrategy(new ModelToDTOProductPopulatorStrategy());
        target.setProducts(defaultConverterContext.convertAll(source.getProducts(), ProductDTO.class));
    }

    protected void createContextIfNull(){
        if (isNull(defaultConverterContext)){
            defaultConverterContext = new DefaultConverterContext();
        }
    }
}
