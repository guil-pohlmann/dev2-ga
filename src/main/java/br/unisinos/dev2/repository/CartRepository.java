package br.unisinos.dev2.repository;

import br.unisinos.dev2.model.CartModel;
import br.unisinos.dev2.model.CustomerModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CartRepository extends MongoRepository<CartModel, String> {
    Optional<CartModel> findById(String id);
}
