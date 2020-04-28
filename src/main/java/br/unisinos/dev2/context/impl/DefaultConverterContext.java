package br.unisinos.dev2.context.impl;

import br.unisinos.dev2.context.ConverterContext;
import br.unisinos.dev2.dto.AbstractDTO;
import br.unisinos.dev2.model.AbstractModel;
import br.unisinos.dev2.strategy.PopulatorStrategy;
import org.springframework.stereotype.Component;

@Component
public class DefaultConverterContext implements ConverterContext {

    private PopulatorStrategy populatorStrategy;
    private AbstractDTO abstractDTO;

    public DefaultConverterContext(AbstractDTO abstractDTO){
        this.abstractDTO = abstractDTO;
    }

    @Override
    public AbstractDTO convert(AbstractModel source){
        populatorStrategy.populate(source, abstractDTO);
        return abstractDTO;
    }

    public void setPopulatorStrategy(PopulatorStrategy populatorStrategy){
        this.populatorStrategy = populatorStrategy;
    }

    public void setAbstractDTO(AbstractDTO abstractDTO){
        this.abstractDTO = abstractDTO;
    }

}
