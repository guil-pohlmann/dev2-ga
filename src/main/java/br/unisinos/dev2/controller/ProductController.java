package br.unisinos.dev2.controller;

import br.unisinos.dev2.dto.ProductDTO;
import br.unisinos.dev2.facades.impl.ProductFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/product")
@RestController
public class ProductController {

    @Autowired
    private ProductFacade productFacade;

    @GetMapping("/{id}")
    public ProductDTO getProduct(@PathVariable String id){
        return productFacade.getProduct(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO saveProduct(@RequestBody ProductDTO productDTO){
        return productFacade.saveProduct(productDTO);
    }

    @PutMapping("/{id}")
    public ProductDTO editProduct(@PathVariable String id, @RequestBody ProductDTO productDTO){
        return productFacade.updateProduct(id, productDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable String id){
        productFacade.deleteProduct(id);
    }
}
