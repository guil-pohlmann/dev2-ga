package br.unisinos.dev2.context.impl;

import br.unisinos.dev2.dto.OrderDTO;
import br.unisinos.dev2.model.OrderModel;
import br.unisinos.dev2.strategy.impl.OrderPopulatorStrategy;
import org.junit.jupiter.api.Test;

class DefaultConverterContextTest {

    @Test
    void convert() {
        DefaultConverterContext defaultConverterContext = new DefaultConverterContext();
        defaultConverterContext.setPopulatorStrategy(new OrderPopulatorStrategy());
        defaultConverterContext.convert(new OrderModel(), OrderDTO.class);
    }
}