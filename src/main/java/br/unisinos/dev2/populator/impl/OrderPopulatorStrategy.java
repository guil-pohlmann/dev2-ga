package br.unisinos.dev2.populator.impl;

import br.unisinos.dev2.dto.OrderDTO;
import br.unisinos.dev2.model.OrderModel;
import br.unisinos.dev2.populator.PopulatorStrategy;

public class OrderPopulatorStrategy implements PopulatorStrategy<OrderModel, OrderDTO> {

    @Override
    public void populate(OrderModel source, OrderDTO target) {

        target.setCode(source.getCode());
        target.setCurrency(source.getCurrency());
        target.setOrderTotal(source.getOrderTotal());

        //TODO populate remaining attributes

    }
}
