package tadjik.ilyosjon.radios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tadjik.ilyosjon.radios.dto.ProductDto;
import tadjik.ilyosjon.radios.model.Product;
import tadjik.ilyosjon.radios.model.Result;
import tadjik.ilyosjon.radios.repository.ProductRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public List<Product> findAll() {
        return productRepo.findAll();
    }

    public Product findById(Integer id) {
        return productRepo.findById(id).get();
    }

    public Result create(Integer id, ProductDto productDto) {
        boolean exists = productRepo.existsById(id);
        if (exists) {
            return new Result(false, "Product already exists");
        }
        Product product = new Product();
        product.setName(productDto.getName());
        product.setReview(productDto.getReview());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setModel(productDto.getModel());
        product.setTags(productDto.getTags());
        product.setCount(productDto.getCount());
        productRepo.save(product);
        return new Result(true, "Product created");
    }

    public Result update(Integer id, ProductDto productDto) {

        Optional<Product> optionalProduct = productRepo.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(productDto.getName());
            product.setReview(productDto.getReview());
            product.setPrice(productDto.getPrice());
            product.setDescription(productDto.getDescription());
            product.setModel(productDto.getModel());
            product.setTags(productDto.getTags());
            product.setCount(productDto.getCount());
            productRepo.save(product);
            return new Result(true, "Product updated");
        }
        return new Result(false, "Product not found");
    }

    public Result delete(Integer id) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if (optionalProduct.isPresent()) {
            productRepo.delete(optionalProduct.get());
            return new Result(true, "Product deleted");
        }
        return new Result(false, "Product not found");
    }
}