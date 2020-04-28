package br.unisinos.dev2.context;

import br.unisinos.dev2.dto.AbstractDTO;
import br.unisinos.dev2.model.AbstractModel;

public interface ConverterContext {

    AbstractDTO convert(AbstractModel source);

}
