package br.unisinos.dev2.states.order;

import br.unisinos.dev2.model.OrderModel;

public class ReceivedOrder implements OrderState{
    private OrderModel order;

    public ReceivedOrder(OrderModel order){
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
    public void gotReceived() {}

    @Override
    public void gotCanceled() {
        order.toReceived();
    }

    @Override
    public void gotClosed() {
        order.toCanceled();
    }
}
