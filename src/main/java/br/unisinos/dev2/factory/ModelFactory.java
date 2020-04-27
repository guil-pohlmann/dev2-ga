package br.unisinos.dev2.factory;

import br.unisinos.dev2.model.AbstractModel;
import org.springframework.stereotype.Component;

@Component
public class ModelFactory extends AbstractModelFactory {
    @Override
    public <T extends AbstractModel> T create(Class<T> type) throws InstantiationException, IllegalAccessException {
        return type.newInstance();
    }
}
