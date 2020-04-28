package br.unisinos.dev2.strategy.impl;

import br.unisinos.dev2.context.ConverterContext;
import br.unisinos.dev2.dto.OrderDTO;
import br.unisinos.dev2.dto.ProductDTO;
import br.unisinos.dev2.model.OrderModel;
import br.unisinos.dev2.strategy.PopulatorStrategy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ModelToDTOOrderPopulatorStrategy implements PopulatorStrategy<OrderModel, OrderDTO> {

    @Resource
    private ConverterContext converterContext;

    @Override
    public void populate(OrderModel source, OrderDTO target) {
        target.setCode(source.getCode());
        target.setCurrency(source.getCurrency());
        target.setOrderTotal(source.getOrderTotal());
        target.setOrderState(source.getState());

        converterContext.setPopulatorStrategy(new ModelToDTODeliveryAddressPopulatorStrategy());
        target.setDeliveryAddress(converterContext.convert(source.getDeliveryAddress(), target.getDeliveryAddress().getClass()));

        converterContext.setPopulatorStrategy(new ModelToDTOCustomerPopulatorStrategy());
        target.setOwner(converterContext.convert(source.getOwner(), target.getOwner().getClass()));

        converterContext.setPopulatorStrategy(new ModelToDTOPaymentInfoPopulatorStrategy());
        target.setPaymentInfo(converterContext.convert(source.getPaymentInfo(), target.getPaymentInfo().getClass()));

        converterContext.setPopulatorStrategy(new ModelToDTOProductPopulatorStrategy());
        target.setProducts(converterContext.convertAll(source.getProducts(), ProductDTO.class));
    }
}
