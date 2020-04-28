package br.unisinos.dev2.service.impl;

import br.unisinos.dev2.factory.ModelFactory;
import br.unisinos.dev2.model.CartModel;
import br.unisinos.dev2.model.OrderModel;
import br.unisinos.dev2.service.CartService;
import br.unisinos.dev2.service.OrderService;
import br.unisinos.dev2.states.order.OpenOrder;
import br.unisinos.dev2.states.order.OrderState;
import br.unisinos.dev2.states.order.SentOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class DefaultOrderService implements OrderService {
    @Resource
    private CartService cartService;

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultOrderService.class);

    @Resource
    private ModelFactory modelFactory;

    private OrderState orderState;

    protected OrderModel createOrder() {
        try {
            OrderModel orderModel = modelFactory.create(OrderModel.class);
            orderState = new OpenOrder(orderModel);
            return orderModel;
        } catch (Exception e) {
            LOGGER.error("Error creating order. Returning null");
        }
        return null;
    }

    @Override
    public OrderModel placeOrder() {
        OrderModel orderModel = createOrder();
        try {
            CartModel cart = cartService.getCurrentCart();
            orderModel.setCode("123412");
            orderModel.setCurrency("BRL");
            orderModel.setDeliveryAddress(cart.getUser() != null ? cart.getUser().getAddress() : null);
            orderModel.setOrderTotal(cart.getCartTotal());
            orderModel.setOwner(cart.getUser());
            orderModel.setPaymentInfo(cart.getPaymentInfo());
            orderModel.setProducts(cart.getProducts());
            orderState.gotSent();

            return orderModel;
        } catch (Exception exception) {
            System.out.println("Error during place order");
        }
        return null;
    }
}
