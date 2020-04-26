package br.unisinos.dev2.populator.impl;

import br.unisinos.dev2.dto.CartDTO;
import br.unisinos.dev2.model.CartModel;
import br.unisinos.dev2.populator.PopulatorStrategy;

public class CartPopulatorStrategy implements PopulatorStrategy<CartModel, CartDTO> {


    @Override
    public void populate(CartModel source, CartDTO target) {
        target.setCartTotal(source.getCartTotal());
        //TODO populate remaining fields
    }
}