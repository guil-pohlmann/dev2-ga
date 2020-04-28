package br.unisinos.dev2.strategy.impl;

import br.unisinos.dev2.context.ConverterContext;
import br.unisinos.dev2.context.impl.DefaultConverterContext;
import br.unisinos.dev2.dto.*;
import br.unisinos.dev2.model.OrderModel;
import br.unisinos.dev2.strategy.PopulatorStrategy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static java.util.Objects.isNull;

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
        createContextIfNull();

        defaultConverterContext.setPopulatorStrategy(new ModelToDTODeliveryAddressPopulatorStrategy());
        target.setDeliveryAddress(defaultConverterContext.convert(source.getDeliveryAddress(), AddressDTO.class));

        defaultConverterContext.setPopulatorStrategy(new ModelToDTOCustomerPopulatorStrategy());
        target.setOwner(defaultConverterContext.convert(source.getOwner(), CustomerDTO.class));

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
