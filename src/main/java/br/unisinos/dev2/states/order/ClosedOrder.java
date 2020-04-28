package br.unisinos.dev2.states.order;

import br.unisinos.dev2.model.OrderModel;

public class ClosedOrder implements OrderState{
    private OrderModel order;

    public ClosedOrder(OrderModel order){
        this.order = order;
    }
    @Override
    public void gotOpen() {
        order.toOpen();
    }

    @Override
    public void gotPendentPayment() {}

    @Override
    public void gotPayment() {}

    @Override
    public void gotSent() {}

    @Override
    public void gotReceived() {}

    @Override
    public void gotCanceled() {}

    @Override
    public void gotClosed() {}
}
