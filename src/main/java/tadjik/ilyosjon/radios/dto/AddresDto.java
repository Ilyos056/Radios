package tadjik.ilyosjon.radios.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddresDto {
    private String city;
    private String street;
    private Integer zipcode;
    private String home_number;
}
