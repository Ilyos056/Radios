package tadjik.ilyosjon.radios.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Double review;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String model;
    @ManyToMany
    private List<Category> category_id;
    @Column(nullable = false)
    private String tags;
    @Column(nullable = false)
    private String count;
    @CreatedDate
    private LocalDateTime created_date=LocalDateTime.now();
}
