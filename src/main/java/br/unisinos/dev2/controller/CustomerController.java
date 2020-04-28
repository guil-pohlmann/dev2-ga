package br.unisinos.dev2.controller;


import br.unisinos.dev2.dto.CustomerDTO;
import br.unisinos.dev2.facades.impl.CustomerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/customer")
@RestController
public class CustomerController {

    @Autowired
    private CustomerFacade customerFacade;
    @GetMapping("/{id}")
    public CustomerDTO getCustomer(@PathVariable String id){
        return customerFacade.getCustomer(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        return customerFacade.saveCustomer(customerDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable String id){
        customerFacade.deleteCustomer(id);
    }
}
