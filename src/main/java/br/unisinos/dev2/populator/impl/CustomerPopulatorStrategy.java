package br.unisinos.dev2.populator.impl;

import br.unisinos.dev2.dto.AddressDTO;
import br.unisinos.dev2.dto.CustomerDTO;
import br.unisinos.dev2.dto.PaymentInfoDTO;
import br.unisinos.dev2.model.CustomerModel;
import br.unisinos.dev2.populator.PopulatorStrategy;

public class CustomerPopulatorStrategy implements PopulatorStrategy<CustomerModel, CustomerDTO> {

    @Override
    public void populate(CustomerModel source, CustomerDTO target) {

        PaymentInfoPopulatorStrategy paymentInfoPopulatorStrategy = new PaymentInfoPopulatorStrategy();
        DeliveryAddressPopulatorStrategy deliveryAddressPopulatorStrategy = new DeliveryAddressPopulatorStrategy();
        target.setId(source.getId());
        target.setEmail(source.getEmail());
        target.setName(source.getEmail());
        PaymentInfoDTO paymentInfo = new PaymentInfoDTO();
        paymentInfoPopulatorStrategy.populate(source.getPaymentInfo(), paymentInfo);
        target.setPaymentInfo(paymentInfo);
        AddressDTO address = new AddressDTO();
        deliveryAddressPopulatorStrategy.populate(source.getAddress(), address);
        target.setAddress(address);
    }
}
