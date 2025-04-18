package tadjik.ilyosjon.radios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tadjik.ilyosjon.radios.model.Checkout;

public interface CheckoutRepo extends JpaRepository<Checkout, Integer> {
    boolean existsById(Integer id);
}
