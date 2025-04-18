package tadjik.ilyosjon.radios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tadjik.ilyosjon.radios.model.Profile;

public interface ProfileRepo extends JpaRepository<Profile, Integer> {
    boolean existsById(Integer id);
}
