package ibm.grupo2.helloBank.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {

    private String name;
    private String cpf;
    private String email;
    private String telephone;
    private int age;
}
