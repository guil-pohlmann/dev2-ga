package br.unisinos.dev2.populator.impl;

import br.unisinos.dev2.dto.ProductDTO;
import br.unisinos.dev2.model.ProductModel;
import br.unisinos.dev2.populator.PopulatorStrategy;

public class ProductPopulatorStrategy implements PopulatorStrategy<ProductModel, ProductDTO> {

    @Override
    public void populate(ProductModel source, ProductDTO target) {
        target.setCode(source.getCode());
        target.setDescription(source.getDescription());
        target.setName(source.getName());
        target.setPrice(source.getPrice());
        target.setUpc(source.getUpc());
    }
}
