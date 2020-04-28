package br.unisinos.dev2.strategy.impl;

import br.unisinos.dev2.dto.*;
import br.unisinos.dev2.model.CartModel;
import br.unisinos.dev2.model.ProductModel;
import br.unisinos.dev2.strategy.PopulatorStrategy;
import org.springframework.stereotype.Component;

@Component
public class CartPopulatorStrategy implements PopulatorStrategy<CartModel, CartDTO> {
    @Override
    public void populate(CartModel source, CartDTO target) {
        PaymentInfoPopulatorStrategy paymentInfoPopulatorStrategy = new PaymentInfoPopulatorStrategy();
        CustomerPopulatorStrategy customerPopulatorStrategy = new CustomerPopulatorStrategy();
        ProductPopulatorStrategy productPopulatorStrategy = new ProductPopulatorStrategy();
        target.setCartTotal(source.getCartTotal());
        PaymentInfoDTO paymentInfo = new PaymentInfoDTO();
        paymentInfoPopulatorStrategy.populate(source.getPaymentInfo(), paymentInfo);
        target.setPaymentInfo(paymentInfo);
        CustomerDTO user = new CustomerDTO();
        customerPopulatorStrategy.populate(source.getUser(), user);
        target.setUser(user);
        ProductDTO product;
        for (ProductModel productModel: source.getProducts()){
            product = new ProductDTO();
            productPopulatorStrategy.populate(productModel, product);
            target.getProducts().add(product);
        }
    }
}
