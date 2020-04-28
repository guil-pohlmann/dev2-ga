package br.unisinos.dev2.service;

import br.unisinos.dev2.dto.ProductDTO;
import br.unisinos.dev2.model.CartModel;
import br.unisinos.dev2.model.ProductModel;

import java.util.List;

public interface CartService {
    CartModel getCurrentCart();

    void calculateCart(CartModel cartModel);

    void addToCart(ProductModel productModel);

    void addToCart(ProductDTO productDTO);

    void addToCart(List<ProductModel> products);
}
