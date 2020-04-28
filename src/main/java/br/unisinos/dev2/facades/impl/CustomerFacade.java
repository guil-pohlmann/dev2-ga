package br.unisinos.dev2.facades.impl;

import br.unisinos.dev2.dto.CustomerDTO;
import br.unisinos.dev2.exception.CustomerNotFoundException;
import br.unisinos.dev2.exception.IncompleteDataSendException;
import br.unisinos.dev2.model.CustomerModel;
import br.unisinos.dev2.strategy.impl.ModelToDTOCustomerPopulatorStrategy;
import br.unisinos.dev2.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.Optional;

@Deprecated
@Component
public class CustomerFacade {

    @Autowired
    private CustomerRepository customerRepository;
    private ModelToDTOCustomerPopulatorStrategy modelToDTOCustomerPopulatorStrategy = new ModelToDTOCustomerPopulatorStrategy();

    public CustomerDTO getCustomer(String id){
        Optional<CustomerModel> customer = customerRepository.findById(id);
        CustomerDTO customerDTO = new CustomerDTO();
        if(customer.isPresent()){
            modelToDTOCustomerPopulatorStrategy.populate(customer.get(), customerDTO);
        }
        else {
            throw new CustomerNotFoundException();
        }
        return customerDTO;
    }

    public CustomerDTO saveCustomer(CustomerDTO customerDTO){
        if(customerDTO.getEmail() == null || customerDTO.getName() == null){
            throw new IncompleteDataSendException();
        }
        CustomerModel customer = new CustomerModel.CustomerBuilder(customerDTO.getEmail(), customerDTO.getName())
                .withAddress(customerDTO.getAddress())
                .withPaymentIfo(customerDTO.getPaymentInfo())
                .build();
        customerRepository.save(customer);
        CustomerDTO responseDTO = new CustomerDTO();
        modelToDTOCustomerPopulatorStrategy.populate(customer, responseDTO);
        return responseDTO;
    }

    public void deleteCustomer(String id){
        Optional<CustomerModel> customer = customerRepository.findById(id);
        if(customer.isPresent()){
            customerRepository.delete(customer.get());
        }
        else {
            throw new CustomerNotFoundException();
        }
    }
}
