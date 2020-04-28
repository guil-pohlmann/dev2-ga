package br.unisinos.dev2.states.order;

import br.unisinos.dev2.model.OrderModel;

public class OpenOrder implements OrderState{
    private OrderModel order;

    public OpenOrder(OrderModel order){
        this.order = order;
    }

    @Override
    public void gotOpen() {
        order.toOpen();
    }

    @Override
    public void gotPendentPayment() {
        order.toPendent();
    }

    @Override
    public void gotPayment() {}

    @Override
    public void gotSent() {}

    @Override
    public void gotReceived() {}

    @Override
    public void gotCanceled() {
        order.toCanceled();
    }

    @Override
    public void gotClosed() {
        order.toClosed();
    }
}
