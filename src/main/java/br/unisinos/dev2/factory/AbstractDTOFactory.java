package br.unisinos.dev2.factory;

public abstract class AbstractDTOFactory {
    public abstract <T extends java.io.Serializable> T create(Class<T> type) throws InstantiationException, IllegalAccessException;
}
