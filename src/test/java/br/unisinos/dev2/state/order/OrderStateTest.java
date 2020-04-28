package br.unisinos.dev2.state.order;

import br.unisinos.dev2.model.OrderModel;
import br.unisinos.dev2.states.order.*;
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

    @Test
    void shouldChangeStateToCancelled(){
        OrderModel orderModel = new OrderModel();
        orderModel.toCanceled();
        Assert.isInstanceOf(CanceledOrder.class, orderModel.getState());
    }

    @Test
    void shouldChangeStateToClosed(){
        OrderModel orderModel = new OrderModel();
        orderModel.toClosed();
        Assert.isInstanceOf(ClosedOrder.class, orderModel.getState());
    }

    @Test
    void shouldChangeStateToReceived(){
        OrderModel orderModel = new OrderModel();
        orderModel.toReceived();
        Assert.isInstanceOf(ReceivedOrder.class, orderModel.getState());
    }

    @Test
    void shouldChangeStateToSent(){
        OrderModel orderModel = new OrderModel();
        orderModel.toPaid();
        orderModel.toSent();
        Assert.isInstanceOf(SentOrder.class, orderModel.getState());
    }
}
