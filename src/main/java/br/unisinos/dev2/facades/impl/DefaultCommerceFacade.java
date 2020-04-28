package br.unisinos.dev2.facades;

import br.unisinos.dev2.context.ConverterContext;
import br.unisinos.dev2.dto.CartDTO;
import br.unisinos.dev2.dto.OrderDTO;
import br.unisinos.dev2.dto.ProductDTO;
import br.unisinos.dev2.service.CartService;
import br.unisinos.dev2.service.OrderService;
import br.unisinos.dev2.strategy.impl.ModelToDTOCartPopulatorStrategy;
import br.unisinos.dev2.strategy.impl.ModelToDTOOrderPopulatorStrategy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class DefaultCommerceFacade implements CommerceFacade{

    @Resource
    private CartService cartService;

    @Resource
    private OrderService orderService;

    @Resource
    private ConverterContext converterContext;

    @Override
    public CartDTO addProductToCart(ProductDTO productDTO){
        cartService.addToCart(productDTO);
        converterContext.setPopulatorStrategy(new ModelToDTOCartPopulatorStrategy());
        return converterContext.convert(cartService.getCurrentCart(), CartDTO.class);
    }

    @Override
    public OrderDTO placeOrder(){
        converterContext.setPopulatorStrategy(new ModelToDTOOrderPopulatorStrategy());
        return converterContext.convert(orderService.placeOrder(), OrderDTO.class);
    }

}
