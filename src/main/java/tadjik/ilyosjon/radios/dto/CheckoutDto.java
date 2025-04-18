package tadjik.ilyosjon.radios.dto;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tadjik.ilyosjon.radios.model.Addres;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutDto {

    private String firstName;
    private String lastName;
    private String company_name;
    private String email;
    private String password;
    private String phone;
    private Integer addres_id;
    private String notes;
}
