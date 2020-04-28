package br.unisinos.dev2.facades.impl;

import br.unisinos.dev2.context.ConverterContext;
import br.unisinos.dev2.dto.CartDTO;
import br.unisinos.dev2.dto.CustomerDTO;
import br.unisinos.dev2.dto.OrderDTO;
import br.unisinos.dev2.dto.ProductDTO;
import br.unisinos.dev2.facades.CommerceFacade;
import br.unisinos.dev2.service.CartService;
import br.unisinos.dev2.service.CustomerService;
import br.unisinos.dev2.service.OrderService;
import br.unisinos.dev2.strategy.impl.ModelToDTOCartPopulatorStrategy;
import br.unisinos.dev2.strategy.impl.ModelToDTOCustomerPopulatorStrategy;
import br.unisinos.dev2.strategy.impl.ModelToDTOOrderPopulatorStrategy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class DefaultCommerceFacade implements CommerceFacade {

    @Resource
    private CartService cartService;

    @Resource
    private OrderService orderService;

    @Resource
    private ConverterContext converterContext;

    @Resource
    private CustomerService customerService;

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

    public CustomerDTO getCurrentCustomer(){
        converterContext.setPopulatorStrategy(new ModelToDTOCustomerPopulatorStrategy());
        return converterContext.convert(customerService.getCurrentUser(), CustomerDTO.class);
    }

}
