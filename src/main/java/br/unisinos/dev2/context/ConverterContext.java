package br.unisinos.dev2.context;

import br.unisinos.dev2.model.AbstractModel;
import br.unisinos.dev2.strategy.PopulatorStrategy;

import java.io.Serializable;
import java.util.List;

public interface ConverterContext {

    <T extends java.io.Serializable> T convert(AbstractModel source, Class<T> type);

    <T extends Serializable> List<T> convertAll(List<? extends AbstractModel> source, Class<T> type);

    void setPopulatorStrategy(PopulatorStrategy populatorStrategy);

    }
