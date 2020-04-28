package br.unisinos.dev2.service.impl;

import br.unisinos.dev2.factory.ModelFactory;
import br.unisinos.dev2.model.CustomerModel;
import br.unisinos.dev2.service.CustomerService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static java.util.Objects.nonNull;

@Component
public class DefaultCustomerService implements CustomerService {

    private CustomerModel currentUser;

    @Resource
    private ModelFactory modelFactory;

    @Override
    public CustomerModel getCurrentUser() {
        if (nonNull(currentUser))
            return currentUser;
        try {
            currentUser = modelFactory.create(CustomerModel.class);
            return currentUser;
        } catch (Exception e) {
            System.out.println("Something went wrong");
            return null;
        }
    }
}
