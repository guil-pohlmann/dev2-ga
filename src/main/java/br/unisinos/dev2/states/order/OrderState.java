package br.unisinos.dev2.states.order;

public interface OrderState {
     void gotOpen();
     void gotPendentPayment();
     void gotPayment();
     void gotSent();
     void gotReceived();
     void gotCanceled();
     void gotClosed();
}
