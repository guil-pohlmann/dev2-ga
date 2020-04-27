package br.unisinos.dev2.factory;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class DTOFactory extends AbstractDTOFactory {
    @Override
    public <T extends Serializable> T create(Class<T> type) throws InstantiationException, IllegalAccessException {
        return type.newInstance();
    }
}
