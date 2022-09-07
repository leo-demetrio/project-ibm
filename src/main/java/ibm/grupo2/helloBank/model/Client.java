package ibm.grupo2.helloBank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Client {

    @Id

    @GeneratedValue( generator = "uuid2" )
    @Column( name = "id", columnDefinition = "BINARY(16)")
    private UUID id;
    private String name;
    private String cpf;
    private String email;
    private String telephone;
    private int age;
}
