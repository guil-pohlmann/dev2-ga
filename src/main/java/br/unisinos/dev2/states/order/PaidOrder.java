package br.unisinos.dev2.states.order;

import br.unisinos.dev2.model.OrderModel;

public class PaidOrder implements OrderState {
    private OrderModel order;

    public PaidOrder(OrderModel order){
        this.order = order;
    }

    @Override
    public void gotOpen() {}

    @Override
    public void gotPendentPayment() {}

    @Override
    public void gotPayment() {}

    @Override
    public void gotSent() {
        order.toSent();
    }

    @Override
    public void gotReceived() {}

    @Override
    public void gotCanceled() {
        order.toCanceled();
    }

    @Override
    public void gotClosed() {}
}
