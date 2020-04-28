package br.unisinos.dev2.context.impl;

import br.unisinos.dev2.context.ConverterContext;
import br.unisinos.dev2.dto.AbstractDTO;
import br.unisinos.dev2.factory.DTOFactory;
import br.unisinos.dev2.factory.ModelFactory;
import br.unisinos.dev2.model.AbstractModel;
import br.unisinos.dev2.strategy.PopulatorStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import static java.util.Objects.isNull;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DefaultConverterContext implements ConverterContext {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultConverterContext.class);

    private PopulatorStrategy populatorStrategy;

    @Resource
    private DTOFactory dtoFactory;

    @Resource
    private ModelFactory modelFactory;

    @Override
    public <T extends java.io.Serializable> T convert(AbstractModel source, Class<T> type) {
        createDTOFactoryIfNull();
        try {
            T abstractDTO = dtoFactory.create(type);
            populatorStrategy.populate(source, abstractDTO);
            return abstractDTO;
        } catch (Exception exception) {
            LOGGER.error("Error while converting {} to DTO", source);
        }
        return null;
    }

    @Override
    public <T extends AbstractModel> T convert(AbstractDTO source, Class<T> type) {
        createModelFactoryIfNull();
        try {
            T abstractModel = modelFactory.create(type);
            populatorStrategy.populate(source, abstractModel);
            return abstractModel;
        } catch (Exception exception) {
            LOGGER.error("Error while converting {} to DTO", source);
        }
        return null;
    }

    @Override
    public <T extends Serializable> List<T> convertAll(List<? extends AbstractModel> source, Class<T> type) {
        return source.stream()
                    .map(
                        product -> convert(product, type)
                     ).collect(Collectors.toList());
    }

    @Override
    public void setPopulatorStrategy(PopulatorStrategy populatorStrategy) {
        this.populatorStrategy = populatorStrategy;
    }

    protected void createModelFactoryIfNull(){
        if (isNull(modelFactory)){
            modelFactory = new ModelFactory();
        }
    }

    protected void createDTOFactoryIfNull(){
        if (isNull(dtoFactory)){
            dtoFactory = new DTOFactory();
        }
    }
}
