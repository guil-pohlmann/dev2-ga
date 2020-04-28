package br.unisinos.dev2.facades;

import br.unisinos.dev2.dto.CartDTO;
import br.unisinos.dev2.dto.CustomerDTO;
import br.unisinos.dev2.dto.OrderDTO;
import br.unisinos.dev2.dto.ProductDTO;

public interface CommerceFacade {

    CartDTO addProductToCart(ProductDTO productDTO);

    OrderDTO placeOrder();

    CustomerDTO getCurrentCustomer();

}
