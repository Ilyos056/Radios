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
public class ShopCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    public Photo photoId;
    @ManyToMany
    public List<Product> productId;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private String quantity;
    @Column(nullable = false)
    private Double total;
    @Column(nullable = false)
    private String coupon;
    @Column(nullable = false)
    private String shipping;
    @CreatedDate
    private LocalDateTime created_date=LocalDateTime.now();
}
