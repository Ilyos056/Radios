package tadjik.ilyosjon.radios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tadjik.ilyosjon.radios.model.Tag;

public interface TagRepo extends JpaRepository<Tag, Integer> {
    boolean existsById(Integer id);
}
