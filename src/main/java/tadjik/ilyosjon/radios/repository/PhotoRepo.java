package tadjik.ilyosjon.radios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tadjik.ilyosjon.radios.model.Photo;

import java.util.List;
import java.util.Optional;

public interface PhotoRepo extends JpaRepository<Photo, Integer> {
    boolean existsById(Integer id);


}
