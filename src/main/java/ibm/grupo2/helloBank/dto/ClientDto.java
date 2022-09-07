package ibm.grupo2.helloBank.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {

    @NotBlank(message = "Field not informed")
    private String name;
    @CPF(message = "Field invalid")
    @NotBlank(message = "Field not informed")
    private String cpf;
    @Email(message = "Field invalid")
    @NotBlank(message = "Field not informed")
    private String email;
    @NotBlank(message = "Field not informed")
    private String telephone;
    @Range(min=13, max=100, message = "Age invalid")
    private Integer age;
}
