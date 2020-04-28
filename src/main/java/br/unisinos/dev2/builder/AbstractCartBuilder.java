package br.unisinos.dev2.builder;

import br.unisinos.dev2.model.CartModel;
import br.unisinos.dev2.model.PaymentInfoModel;
import br.unisinos.dev2.model.ProductModel;

import java.util.List;

public abstract class AbstractCartBuilder {
    protected CartModel cart;

    public AbstractCartBuilder() {
        this.cart = new CartModel();
    }

    public abstract void setSessionId();

    public abstract void setUser();

    public abstract void setCartTotal();

    public abstract void setPaymentInfo(PaymentInfoModel paymentInfo);

    public abstract void setProducts(List<ProductModel> products);

    public void setCart(CartModel cart) {
        this.cart = cart;
    }

    public CartModel getCart() {
        return cart;
    }
}
