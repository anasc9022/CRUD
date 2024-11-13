package crud.crud.example.service;

import crud.crud.example.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product createProduct(Product product);

    ResponseEntity<Product> updateProduct(Long id, Product productDetails);

    ResponseEntity<Product> deleteProduct(Long id);
}
