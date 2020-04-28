package br.unisinos.dev2.repository;

import br.unisinos.dev2.model.AddressModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<AddressModel, Integer>{

}
