package br.unisinos.dev2.populator.impl;

import br.unisinos.dev2.dto.CustomerDTO;
import br.unisinos.dev2.dto.OrderDTO;
import br.unisinos.dev2.model.OrderModel;
import br.unisinos.dev2.populator.PopulatorStrategy;
import org.springframework.stereotype.Component;

@Component
public class OrderPopulatorStrategy implements PopulatorStrategy<OrderModel, OrderDTO> {

    @Override
    public void populate(OrderModel source, OrderDTO target) {

        CustomerPopulatorStrategy customerPopulatorStrategy = new CustomerPopulatorStrategy();

        target.setCode(source.getCode());
        target.setCurrency(source.getCurrency());
        target.setOrderTotal(source.getOrderTotal());
        CustomerDTO owner = new CustomerDTO();
        customerPopulatorStrategy.populate(source.getOwner(), owner);
        target.setOwner(owner);

        //TODO populate remaining attributes

    }
}
