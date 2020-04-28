package br.unisinos.dev2.strategy.impl;

import br.unisinos.dev2.context.ConverterContext;
import br.unisinos.dev2.context.impl.DefaultConverterContext;
import br.unisinos.dev2.dto.AddressDTO;
import br.unisinos.dev2.dto.CustomerDTO;
import br.unisinos.dev2.dto.PaymentInfoDTO;
import br.unisinos.dev2.model.CustomerModel;
import br.unisinos.dev2.strategy.PopulatorStrategy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static java.util.Objects.isNull;

@Component
public class ModelToDTOCustomerPopulatorStrategy implements PopulatorStrategy<CustomerModel, CustomerDTO> {

    @Resource
    private ConverterContext defaultConverterContext;

    @Override
    public void populate(CustomerModel source, CustomerDTO target) {
        target.setId(source.getId());
        target.setEmail(source.getEmail());
        target.setName(source.getEmail());
        createContextIfNull();

        defaultConverterContext.setPopulatorStrategy(new ModelToDTOPaymentInfoPopulatorStrategy());
        target.setPaymentInfo(defaultConverterContext.convert(source.getPaymentInfo(), PaymentInfoDTO.class));

        defaultConverterContext.setPopulatorStrategy(new ModelToDTODeliveryAddressPopulatorStrategy());
        target.setAddress(defaultConverterContext.convert(source.getAddress(), AddressDTO.class));

    }

    protected void createContextIfNull(){
        if (isNull(defaultConverterContext)){
            defaultConverterContext = new DefaultConverterContext();
        }
    }
}
