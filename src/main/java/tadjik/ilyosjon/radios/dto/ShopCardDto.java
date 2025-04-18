package tadjik.ilyosjon.radios.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopCardDto {

    public Integer photoId;
    public Integer productId;
    private Double price;
    private String quantity;
    private Double total;
    private String coupon;
    private String shipping;
}
