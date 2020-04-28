package br.unisinos.dev2.strategy.impl;

import br.unisinos.dev2.dto.ProductDTO;
import br.unisinos.dev2.model.ProductModel;
import br.unisinos.dev2.strategy.PopulatorStrategy;
import org.springframework.stereotype.Component;

@Component
public class DtoToModelProductPopulatorStrategy implements PopulatorStrategy<ProductDTO, ProductModel> {

    @Override
    public void populate(ProductDTO source, ProductModel target) {
        target.setCode(source.getCode());
        target.setDescription(source.getDescription());
        target.setName(source.getName());
        target.setPrice(source.getPrice());
        target.setUpc(source.getUpc());
    }
}
