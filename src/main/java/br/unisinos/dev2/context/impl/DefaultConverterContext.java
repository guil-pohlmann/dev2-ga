package br.unisinos.dev2.context.impl;

import br.unisinos.dev2.context.ConverterContext;
import br.unisinos.dev2.factory.DTOFactory;
import br.unisinos.dev2.model.AbstractModel;
import br.unisinos.dev2.strategy.PopulatorStrategy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DefaultConverterContext implements ConverterContext {

    private PopulatorStrategy populatorStrategy;

    @Resource
    private DTOFactory dtoFactory;

    @Override
    public <T extends java.io.Serializable> T convert(AbstractModel source, Class<T> type) {
        try {
            T abstractDTO = dtoFactory.create(type);
            populatorStrategy.populate(source, abstractDTO);
            return abstractDTO;
        } catch (Exception exception) {
            System.out.println("Error while converting to DTO");
        }
        return null;
    }

    @Override
    public <T extends Serializable> List<T> convertAll(List<AbstractModel> source, Class<T> type) {

        return source.stream()
                    .map(
                        product -> convert(product, type)
                     ).collect(Collectors.toList());
    }

    public void setPopulatorStrategy(PopulatorStrategy populatorStrategy) {
        this.populatorStrategy = populatorStrategy;
    }
}
