package br.unisinos.dev2.factory;

import br.unisinos.dev2.model.AbstractModel;

public abstract class AbstractModelFactory {
    public abstract <T extends AbstractModel> T create(Class<T> type) throws InstantiationException, IllegalAccessException;
}
