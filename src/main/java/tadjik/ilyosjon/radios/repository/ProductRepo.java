package tadjik.ilyosjon.radios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tadjik.ilyosjon.radios.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, Integer> {
    boolean existsById(Integer id);

}


