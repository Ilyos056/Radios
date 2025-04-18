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
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToMany
    private List<Photo> photoId;
    @ManyToMany
    private List<Tag> tagId;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String name;
    @CreatedDate
    private LocalDateTime created_date=LocalDateTime.now();
    @Column(nullable = false)
    private String comment;
    @Column(nullable = false)
    private String post_date;
}
