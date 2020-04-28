package br.unisinos.dev2.repository;
import br.unisinos.dev2.model.CustomerModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<CustomerModel, String>{
    Optional<CustomerModel> findById(String id);
}
