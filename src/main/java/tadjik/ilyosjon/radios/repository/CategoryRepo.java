package tadjik.ilyosjon.radios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tadjik.ilyosjon.radios.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
