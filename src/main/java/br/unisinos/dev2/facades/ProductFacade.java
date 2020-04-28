package br.unisinos.dev2.facades;

import br.unisinos.dev2.dto.ProductDTO;
import br.unisinos.dev2.exception.CustomerNotFoundException;
import br.unisinos.dev2.exception.IncompleteDataSendException;
import br.unisinos.dev2.exception.ProductNotFoundException;
import br.unisinos.dev2.model.ProductModel;
import br.unisinos.dev2.repository.ProductRepository;
import br.unisinos.dev2.strategy.impl.ProductPopulatorStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductFacade {

    @Autowired
    private ProductRepository productRepository;
    private ProductPopulatorStrategy productPopulatorStrategy = new ProductPopulatorStrategy();

    public ProductDTO getProduct(String id){
        Optional<ProductModel> product = productRepository.findById(id);
        ProductDTO productDTO = new ProductDTO();
        if(product.isPresent()){
            productPopulatorStrategy.populate(product.get(), productDTO);
        }
        else {
            throw new ProductNotFoundException();
        }
        return productDTO;
    }

    public ProductDTO saveProduct(ProductDTO productDTO){
        if(productDTO.getDescription() == null || productDTO.getName() == null || productDTO.getUpc() == null){
            throw new IncompleteDataSendException();
        }
        ProductModel product = new ProductModel(productDTO.getUpc(), productDTO.getName(), productDTO.getDescription(), productDTO.getPrice());
        productRepository.save(product);
        ProductDTO responseDTO = new ProductDTO();
        productPopulatorStrategy.populate(product, responseDTO);
        return responseDTO;
    }

    public ProductDTO updateProduct(String code, ProductDTO productDTO){
        if(productDTO.getDescription() == null || productDTO.getName() == null || productDTO.getUpc() == null){
            throw new IncompleteDataSendException();
        }
        Optional<ProductModel> product = productRepository.findById(code);
        ProductDTO responseDTO = new ProductDTO();
        if(product.isPresent()){
            ProductModel newProduct = product.get();
            newProduct.setDescription(productDTO.getDescription());
            newProduct.setName(productDTO.getName());
            newProduct.setPrice(productDTO.getPrice());
            newProduct.setUpc(productDTO.getUpc());

            productPopulatorStrategy.populate(newProduct, responseDTO);
        }
        else {
            throw new ProductNotFoundException();
        }
        return responseDTO;
    }

    public void deleteProduct(String id){
        Optional<ProductModel> product = productRepository.findById(id);
        if(product.isPresent()){
            productRepository.delete(product.get());
        }
        else {
            throw new CustomerNotFoundException();
        }
    }
}
