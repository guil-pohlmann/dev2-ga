package br.unisinos.dev2.controller;

import br.unisinos.dev2.dto.CartDTO;
import br.unisinos.dev2.dto.ProductDTO;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cart")
@RestController
public class CartController {

    @GetMapping("/{id}")
    public CartDTO getCart(@PathVariable String id){
        //TODO implement search
        return new CartDTO();
    }

    @PostMapping
    public CartDTO saveCart(@PathVariable String id, @RequestBody CartDTO cartDTO) {
        //TODO persist this
        return cartDTO;
    }

    @PostMapping("/{id}/add")
    public CartDTO addProduct(@PathVariable String id, @RequestBody Integer code){

        //TODO implement search end persitence
        CartDTO cartDTO= new CartDTO();
        cartDTO.getProducts().add(new ProductDTO());

        return cartDTO;
    }

    @DeleteMapping("/{id}/remove")
    public CartDTO removeProduct(@PathVariable String id, @RequestBody Integer code){

        //TODO implement search end persitence
        CartDTO cartDTO= new CartDTO();
        cartDTO.getProducts().remove(new ProductDTO());

        return cartDTO;
    }


}
