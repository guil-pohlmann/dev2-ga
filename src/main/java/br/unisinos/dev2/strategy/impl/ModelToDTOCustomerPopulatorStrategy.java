package br.unisinos.dev2.strategy.impl;

import br.unisinos.dev2.context.ConverterContext;
import br.unisinos.dev2.dto.CustomerDTO;
import br.unisinos.dev2.model.CustomerModel;
import br.unisinos.dev2.strategy.PopulatorStrategy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ModelToDTOCustomerPopulatorStrategy implements PopulatorStrategy<CustomerModel, CustomerDTO> {

    @Resource
    private ConverterContext converterContext;

    @Override
    public void populate(CustomerModel source, CustomerDTO target) {
        target.setId(source.getId());
        target.setEmail(source.getEmail());
        target.setName(source.getEmail());

        converterContext.setPopulatorStrategy(new ModelToDTOPaymentInfoPopulatorStrategy());
        target.setPaymentInfo(converterContext.convert(source.getPaymentInfo(), target.getPaymentInfo().getClass()));

        converterContext.setPopulatorStrategy(new ModelToDTODeliveryAddressPopulatorStrategy());
        target.setAddress(converterContext.convert(source.getAddress(), target.getAddress().getClass()));

    }
}
