package crud.crud.example.serviceImpl;

import crud.crud.example.entity.Product;
import crud.crud.example.repo.ProductRepository;
import crud.crud.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Product not found fot id " + id));
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public ResponseEntity<Product> updateProduct(Long id, Product productDetail) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id " + id));
        product.setName(productDetail.getName());
        product.setInStock(productDetail.getInStock());
        product.setDescription(productDetail.getDescription());

        Product updatedProduct = productRepository.save(product);
        return ResponseEntity.ok(updatedProduct);
    }

    @Override
    public ResponseEntity<Product> deleteProduct(Long id) {
        productRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
