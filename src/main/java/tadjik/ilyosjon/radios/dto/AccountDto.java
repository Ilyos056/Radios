package tadjik.ilyosjon.radios.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    private String name;
    private String email;
    private String password;
}
