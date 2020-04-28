package br.unisinos.dev2.controller;

import br.unisinos.dev2.dto.CartDTO;
import br.unisinos.dev2.dto.ProductDTO;
import br.unisinos.dev2.facades.impl.CartFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cart")
@RestController
public class CartController {
    @Autowired
    private CartFacade cartFacade;

    @GetMapping("/{id}")
    public CartDTO getCart(@PathVariable String id){
        return cartFacade.getCart(id);
    }

    @PostMapping
    public CartDTO saveCart(@RequestBody CartDTO cartDTO) {
        cartFacade.saveCart(cartDTO);
        return cartDTO;
    }

    @PutMapping("/{id}")
    public CartDTO addProduct(@PathVariable String id, @RequestBody ProductDTO productDTO){
        return cartFacade.addItem(id, productDTO);
    }

    @DeleteMapping("/{id}")
    public CartDTO removeProduct(@PathVariable String id, @RequestBody ProductDTO productDTO){
        return cartFacade.removeItem(id, productDTO);
    }


}
