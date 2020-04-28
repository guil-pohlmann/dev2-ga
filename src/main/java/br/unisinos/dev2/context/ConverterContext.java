package br.unisinos.dev2.context;

import br.unisinos.dev2.model.AbstractModel;

public interface ConverterContext {

    <T extends java.io.Serializable> T convert(AbstractModel source, Class<T> type);

}
