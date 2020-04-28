package br.unisinos.dev2.repository;

import br.unisinos.dev2.model.ProductModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<ProductModel, String> {
    Optional<ProductModel> findById(String id);
}
