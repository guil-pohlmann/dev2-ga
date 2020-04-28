package br.unisinos.dev2.context.impl;

import br.unisinos.dev2.dto.OrderDTO;
import br.unisinos.dev2.factory.DTOFactory;
import br.unisinos.dev2.model.OrderModel;
import br.unisinos.dev2.strategy.impl.OrderPopulatorStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultConverterContextTest {

    @Test
    void convert() throws Exception{

        DTOFactory factory = new DTOFactory();
        OrderDTO orderDTO = factory.create(OrderDTO.class);

        DefaultConverterContext defaultConverterContext = new DefaultConverterContext(orderDTO);
        defaultConverterContext.setPopulatorStrategy(new OrderPopulatorStrategy());

        defaultConverterContext.convert(new OrderModel());

    }
}