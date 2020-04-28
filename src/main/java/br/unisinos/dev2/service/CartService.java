package br.unisinos.dev2.service;

import br.unisinos.dev2.model.CartModel;

public interface CartService {
    CartModel getCurrentCart();
    void calculateCart(CartModel cartModel);
}
