package br.unisinos.dev2.model;

import br.unisinos.dev2.states.order.*;

import java.util.List;

public class OrderModel extends AbstractModel {

    private String code;

    private CustomerModel owner;

    private double orderTotal;

    private String currency;

    private PaymentInfoModel paymentInfo;

    private AddressModel deliveryAddress;

    private List<ProductModel> products;

    private OrderState state;

    private CanceledOrder canceledOrder;
    private ClosedOrder closedOrder;
    private OpenOrder openOrder;
    private PaidOrder paidOrder;
    private PendentPaymentOrder pendentPaymentOrder;
    private ReceivedOrder receivedOrder;
    private SentOrder sentOrder;

    public OrderModel() {
        this.canceledOrder = new CanceledOrder(this);
        this.closedOrder = new ClosedOrder(this);
        this.openOrder = new OpenOrder(this);
        this.paidOrder = new PaidOrder(this);
        this.pendentPaymentOrder = new PendentPaymentOrder(this);
        this.receivedOrder = new ReceivedOrder(this);
        this.sentOrder = new SentOrder(this);
        this.state = openOrder;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CustomerModel getOwner() {
        return owner;
    }

    public void setOwner(CustomerModel owner) {
        this.owner = owner;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public PaymentInfoModel getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(PaymentInfoModel paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public AddressModel getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(AddressModel deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public List<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductModel> products) {
        this.products = products;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void gotOpen() {
        state.gotOpen();
    }

    public void gotPendentPayment() {
        state.gotPendentPayment();
    }

    public void gotPayment() {
        state.gotPayment();
    }

    public void gotSent() {
        state.gotSent();
    }

    public void gotReceived() {
        state.gotReceived();
    }

    public void gotCanceled() {
        state.gotCanceled();
    }

    public void gotClosed() {
        state.gotClosed();
    }

    public void toOpen() {
        state = openOrder;
    }

    public void toClosed() {
        state = closedOrder;
    }

    public void toCanceled() {
        state = canceledOrder;
    }

    public void toPaid() {
        state = paidOrder;
    }

    public void toPendent() {
        if (state != paidOrder)
            state = pendentPaymentOrder;
    }

    public void toReceived() {
        state = receivedOrder;
    }

    public void toSent() {
        if (state == paidOrder)
            state = sentOrder;
    }
}
