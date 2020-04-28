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
    private ConverterContext defaultConverterContext;

    @Override
    public void populate(OrderModel source, OrderDTO target) {
        target.setCode(source.getCode());
        target.setCurrency(source.getCurrency());
        target.setOrderTotal(source.getOrderTotal());
        target.setOrderState(source.getState());

        defaultConverterContext.setPopulatorStrategy(new ModelToDTODeliveryAddressPopulatorStrategy());
        target.setDeliveryAddress(defaultConverterContext.convert(source.getDeliveryAddress(), target.getDeliveryAddress().getClass()));

        defaultConverterContext.setPopulatorStrategy(new ModelToDTOCustomerPopulatorStrategy());
        target.setOwner(defaultConverterContext.convert(source.getOwner(), target.getOwner().getClass()));

        defaultConverterContext.setPopulatorStrategy(new ModelToDTOPaymentInfoPopulatorStrategy());
        target.setPaymentInfo(defaultConverterContext.convert(source.getPaymentInfo(), target.getPaymentInfo().getClass()));

        defaultConverterContext.setPopulatorStrategy(new ModelToDTOProductPopulatorStrategy());
        target.setProducts(defaultConverterContext.convertAll(source.getProducts(), ProductDTO.class));
    }
}
