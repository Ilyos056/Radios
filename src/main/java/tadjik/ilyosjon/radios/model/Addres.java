package tadjik.ilyosjon.radios.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Addres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false, unique = true)
    private String street;
    @Column(nullable = false, unique = true)
    private Integer zipcode;
    @Column(nullable = false)
    private String home_number;
    @CreatedDate
    private LocalDateTime created_date=LocalDateTime.now();
}
