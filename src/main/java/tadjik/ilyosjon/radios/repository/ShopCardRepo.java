package tadjik.ilyosjon.radios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tadjik.ilyosjon.radios.model.Photo;
import tadjik.ilyosjon.radios.model.ShopCard;

import java.util.List;

public interface ShopCardRepo extends JpaRepository<ShopCard, Integer> {
    boolean existsById(Integer id);
}
