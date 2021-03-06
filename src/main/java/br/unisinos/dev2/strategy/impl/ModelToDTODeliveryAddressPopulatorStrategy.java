package br.unisinos.dev2.strategy.impl;

import br.unisinos.dev2.dto.AddressDTO;
import br.unisinos.dev2.model.AddressModel;
import br.unisinos.dev2.strategy.PopulatorStrategy;
import org.springframework.stereotype.Component;

@Component
public class ModelToDTODeliveryAddressPopulatorStrategy implements PopulatorStrategy<AddressModel, AddressDTO> {

    @Override
    public void populate(AddressModel source, AddressDTO target) {
        target.setCity(source.getCity());
        target.setCountry(source.getCountry());
        target.setPhoneNumber(source.getPhoneNumber());
        target.setPostalCode(source.getPostalCode());
        target.setState(source.getState());
        target.setStreet(source.getStreet());
        target.setStreetNumber(source.getStreetNumber());
    }
}
