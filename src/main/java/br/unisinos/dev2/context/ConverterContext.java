package br.unisinos.dev2.context;

import br.unisinos.dev2.dto.AbstractDTO;
import br.unisinos.dev2.model.AbstractModel;
import br.unisinos.dev2.strategy.PopulatorStrategy;

import java.util.List;

public interface ConverterContext {

    AbstractDTO convert(AbstractModel source);

    List<AbstractDTO> convertAll(List<AbstractModel> source);

    void setPopulatorStrategy(PopulatorStrategy populatorStrategy);

    void setTarget(AbstractDTO target);

    }
