package tadjik.ilyosjon.radios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tadjik.ilyosjon.radios.model.Addres;

public interface AddresRepo extends JpaRepository<Addres, Integer> {
   boolean existsById(Integer id);
}
