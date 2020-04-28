package br.unisinos.dev2.facades;


import br.unisinos.dev2.dto.CartDTO;
import br.unisinos.dev2.dto.ProductDTO;
import br.unisinos.dev2.exception.CartNotFoundException;
import br.unisinos.dev2.model.CartModel;
import br.unisinos.dev2.model.ProductModel;
import br.unisinos.dev2.repository.CartRepository;
import br.unisinos.dev2.strategy.impl.ModelToDTOCartPopulatorStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Deprecated
@Component
public class CartFacade {

    @Autowired
    private CartRepository cartRepository;
    private ModelToDTOCartPopulatorStrategy modelToDTOCartPopulatorStrategy = new ModelToDTOCartPopulatorStrategy();

    public CartDTO getCart(String id){
        Optional<CartModel> cart = cartRepository.findById(id);
        CartDTO cartDTO = new CartDTO();
        if(cart.isPresent()){
            modelToDTOCartPopulatorStrategy.populate(cart.get(), cartDTO);
        }
        else {
            throw new CartNotFoundException();
        }
        return cartDTO;
    }

    public CartDTO saveCart(CartDTO cartDTO){
        CartModel cart = new CartModel(cartDTO.getUser(), cartDTO.getCartTotal(), cartDTO.getPaymentInfo(), cartDTO.getProducts());
        cartRepository.save(cart);
        CartDTO responseDTO = new CartDTO();
        modelToDTOCartPopulatorStrategy.populate(cart, responseDTO);
        return responseDTO;
    }

    public CartDTO addItem(String id, ProductDTO product){
        Optional<CartModel> cart = cartRepository.findById(id);
        CartDTO cartDTO = new CartDTO();
        if(cart.isPresent()){
            ProductModel productModel = new ProductModel(product.getUpc(), product.getName(), product.getDescription(), product.getPrice());
            CartModel cartModel = cart.get();
            cartModel.getProducts().add(productModel);
            cartModel.setCartTotal(cartModel.getCartTotal() + productModel.getPrice());
            cartRepository.save(cartModel);
            modelToDTOCartPopulatorStrategy.populate(cart.get(), cartDTO);
        }
        else {
            throw new CartNotFoundException();
        }
        return cartDTO;
    }

    public CartDTO removeItem(String id, ProductDTO product){
        Optional<CartModel> cart = cartRepository.findById(id);
        CartDTO cartDTO = new CartDTO();
        if(cart.isPresent()){
            CartModel cartModel = cart.get();
            cartModel.getProducts().removeIf(e -> e.getCode().equals(product.getCode()));
            cartModel.setCartTotal(cartModel.getCartTotal() - product.getPrice());
            cartRepository.save(cartModel);
            modelToDTOCartPopulatorStrategy.populate(cart.get(), cartDTO);
        }
        else {
            throw new CartNotFoundException();
        }
        return cartDTO;
    }

    public void deleteCart(String id){
        Optional<CartModel> cart = cartRepository.findById(id);
        if(cart.isPresent()){
            cartRepository.delete(cart.get());
        }
        else {
            throw new CartNotFoundException();
        }
    }
}
