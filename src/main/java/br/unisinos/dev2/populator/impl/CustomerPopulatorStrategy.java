package br.unisinos.dev2.populator.impl;

import br.unisinos.dev2.dto.CustomerDTO;
import br.unisinos.dev2.model.CustomerModel;
import br.unisinos.dev2.populator.PopulatorStrategy;
import org.springframework.stereotype.Component;

@Component
public class CustomerPopulatorStrategy implements PopulatorStrategy<CustomerModel, CustomerDTO> {

    @Override
    public void populate(CustomerModel source, CustomerDTO target) {
        target.setEmail(source.getEmail());
        target.setName(source.getEmail());

    }
}
