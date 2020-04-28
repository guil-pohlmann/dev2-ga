package br.unisinos.dev2.builder;

import br.unisinos.dev2.factory.ModelFactory;
import br.unisinos.dev2.model.CustomerModel;
import br.unisinos.dev2.model.PaymentInfoModel;
import br.unisinos.dev2.model.ProductModel;
import br.unisinos.dev2.service.CartService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class AnonymousCartBuilder extends AbstractCartBuilder {

    @Resource
    private CartService cartService;

    @Resource
    private ModelFactory modelFactory;

    @Override
    public void setSessionId() {
        cart.setSessionId("7a6dASFs789SF");
    }

    @Override
    public void setUser() {
        try {
            CustomerModel anonymous = modelFactory.create(CustomerModel.class);
            anonymous.setEmail("anonymous");
            anonymous.setName("anonymous");
            cart.setUser(anonymous);
        } catch (Exception exception) {
            System.out.println("Error while setting anonymous customer");
        }
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
