package br.unisinos.dev2.states.order;

import br.unisinos.dev2.model.OrderModel;

public class SentOrder implements OrderState{
    private OrderModel order;

    public SentOrder(OrderModel order){
        this.order = order;
    }

    @Override
    public void gotOpen() {}

    @Override
    public void gotPendentPayment() {}

    @Override
    public void gotPayment() {}

    @Override
    public void gotSent() {}

    @Override
    public void gotReceived() {
        order.toReceived();
    }

    @Override
    public void gotCanceled() {
        order.toCanceled();
    }

    @Override
    public void gotClosed() {
        order.toClosed();
    }
}
