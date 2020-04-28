package br.unisinos.dev2.states.order;

import br.unisinos.dev2.model.OrderModel;

public class PendentPaymentOrder implements OrderState{
    private OrderModel order;

    public PendentPaymentOrder(OrderModel order){
        this.order = order;
    }

    @Override
    public void gotOpen() {}

    @Override
    public void gotPendentPayment() {}

    @Override
    public void gotPayment() {
        order.toPaid();
    }

    @Override
    public void gotSent() {}

    @Override
    public void gotReceived() {}

    @Override
    public void gotCanceled() {
        order.toCanceled();
    }

    @Override
    public void gotClosed() {}
}
