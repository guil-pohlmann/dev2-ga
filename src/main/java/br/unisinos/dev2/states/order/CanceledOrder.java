package br.unisinos.dev2.states.order;

import br.unisinos.dev2.model.OrderModel;

public class CanceledOrder implements OrderState{
    private OrderModel order;

    public CanceledOrder(OrderModel order){
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
