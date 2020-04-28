package br.unisinos.dev2.context;

import br.unisinos.dev2.model.AbstractModel;
import br.unisinos.dev2.strategy.PopulatorStrategy;

import java.util.List;

public interface ConverterContext {

    <T extends java.io.Serializable> T convert(AbstractModel source, Class<T> type);

    List<AbstractDTO> convertAll(List<AbstractModel> source);

    void setPopulatorStrategy(PopulatorStrategy populatorStrategy);

    void setTarget(AbstractDTO target);

    }
