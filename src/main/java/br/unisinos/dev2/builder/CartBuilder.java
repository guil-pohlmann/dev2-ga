package br.unisinos.dev2.builder;

import br.unisinos.dev2.model.PaymentInfoModel;
import br.unisinos.dev2.model.ProductModel;
import br.unisinos.dev2.service.CartService;
import br.unisinos.dev2.service.CustomerService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class CartBuilder extends AbstractCartBuilder {

    @Resource
    private CartService cartService;

    @Resource
    private CustomerService customerService;

    @Override
    public void setSessionId() {
        cart.setSessionId("8798SDD98dsSFG987");
    }

    @Override
    public void setUser() {
        cart.setUser(customerService.getCurrentUser());
    }

    @Override
    public void setCartTotal() {
        cartService.calculateCart(cart);
    }

    @Override
    public void setPaymentInfo(PaymentInfoModel paymentInfo) {
        cart.setPaymentInfo(paymentInfo);
    }

    @Override
    public void setProducts(List<ProductModel> products) {
        cart.setProducts(products);
    }
}
