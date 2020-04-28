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
    private ConverterContext defaultConverterContext;

    @Resource
    private CustomerService customerService;

    @Override
    public CartDTO addProductToCart(ProductDTO productDTO){
        cartService.addToCart(productDTO);
        defaultConverterContext.setPopulatorStrategy(new ModelToDTOCartPopulatorStrategy());
        return defaultConverterContext.convert(cartService.getCurrentCart(), CartDTO.class);
    }

    @Override
    public OrderDTO placeOrder(){
        defaultConverterContext.setPopulatorStrategy(new ModelToDTOOrderPopulatorStrategy());
        return defaultConverterContext.convert(orderService.placeOrder(), OrderDTO.class);
    }

    public CustomerDTO getCurrentCustomer(){
        defaultConverterContext.setPopulatorStrategy(new ModelToDTOCustomerPopulatorStrategy());
        return defaultConverterContext.convert(customerService.getCurrentUser(), CustomerDTO.class);
    }

}
