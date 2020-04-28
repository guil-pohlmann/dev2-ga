package br.unisinos.dev2.facades;

import br.unisinos.dev2.dto.CustomerDTO;
import br.unisinos.dev2.exception.CustomerNotFoundException;
import br.unisinos.dev2.exception.IncompleteDataSendException;
import br.unisinos.dev2.model.CustomerModel;
import br.unisinos.dev2.populator.impl.CustomerPopulatorStrategy;
import br.unisinos.dev2.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerFacade {

    @Autowired
    private CustomerRepository customerRepository;
    private CustomerPopulatorStrategy customerPopulatorStrategy = new CustomerPopulatorStrategy();

    public CustomerDTO getCustomer(String id){
        Optional<CustomerModel> customer = customerRepository.findById(id);
        CustomerDTO customerDTO = new CustomerDTO();
        if(customer.isPresent()){
            customerPopulatorStrategy.populate(customer.get(), customerDTO);
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
        customerPopulatorStrategy.populate(customer, responseDTO);
        System.out.println(customer.getId());
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
