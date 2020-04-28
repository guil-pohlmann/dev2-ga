package br.unisinos.dev2.service.impl;

import br.unisinos.dev2.factory.ModelFactory;
import br.unisinos.dev2.model.CartModel;
import br.unisinos.dev2.model.OrderModel;
import br.unisinos.dev2.service.CartService;
import br.unisinos.dev2.service.OrderService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class DefaultOrderService implements OrderService {
    @Resource
    private CartService cartService;

    @Resource
    private ModelFactory modelFactory;

    @Override
    public OrderModel placeOrder() {
        try {
            OrderModel orderModel = modelFactory.create(OrderModel.class);
            CartModel cart = cartService.getCurrentCart();

            orderModel.setCode("123412");
            orderModel.setCurrency("BRL");
            orderModel.setDeliveryAddress(cart.getUser().getAddress());
            orderModel.setOrderTotal(cart.getCartTotal());
            orderModel.setOwner(cart.getUser());
            orderModel.setPaymentInfo(cart.getPaymentInfo());
            orderModel.setProducts(cart.getProducts());
            return orderModel;
        } catch (Exception exception) {
            System.out.println("Error during place order");
        }
        return null;
    }
}
