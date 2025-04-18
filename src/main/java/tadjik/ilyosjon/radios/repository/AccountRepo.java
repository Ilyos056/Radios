package tadjik.ilyosjon.radios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tadjik.ilyosjon.radios.model.Account;

public interface AccountRepo extends JpaRepository<Account, Integer> {

}
