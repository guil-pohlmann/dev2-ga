package br.unisinos.dev2.state.order;

import br.unisinos.dev2.model.OrderModel;
import br.unisinos.dev2.states.order.OpenOrder;
import br.unisinos.dev2.states.order.PaidOrder;
import br.unisinos.dev2.states.order.PendentPaymentOrder;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class OrderStateTest {

    @Test
    void orderShouldStartWithOpenState(){
        OrderModel orderModel = new OrderModel();
        Assert.isInstanceOf(OpenOrder.class, orderModel.getState());
    }

    @Test
    void shouldChangeStateToPendentPayment(){
        OrderModel orderModel = new OrderModel();
        orderModel.toPendent();
        Assert.isInstanceOf(PendentPaymentOrder.class, orderModel.getState());
    }

    @Test
    void shouldNotChangeBackToPendentPaymentAfterPaid(){
        OrderModel orderModel = new OrderModel();
        orderModel.toPendent();
        orderModel.toPaid();
        orderModel.toPendent();
        Assert.isInstanceOf(PaidOrder.class, orderModel.getState());
    }

    @Test
    void shouldNotChangeToSentStateIfNotPaid(){
        OrderModel orderModel = new OrderModel();
        orderModel.toPendent();
        orderModel.toSent();
        Assert.isInstanceOf(PendentPaymentOrder.class, orderModel.getState());
    }
}
