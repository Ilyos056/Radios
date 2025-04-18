package tadjik.ilyosjon.radios.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private String name;
    private Double review;
    private Double price;
    private String description;
    private String model;
    private Integer category_id;
    private String tags;
    private String count;

}
