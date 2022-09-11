package ibm.grupo2.helloBank.repository;

import ibm.grupo2.helloBank.exception.NoSuchElementException;
import ibm.grupo2.helloBank.model.Client;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;
import java.util.UUID;

@DataJpaTest
@Log4j2
class ClientRepositoryTest {

    @Autowired
    private ClientRepository repository;

    @Test
    @DisplayName("Save client when successful")
    void save_PersistClient_WhenSuccessful(){
        var c = new Client(null, "Lucas",  "095.188.270-87", "lucas@gmail.com", "88888888", 18);

        var client = repository.save(c);

        Assertions.assertThat(client).isNotNull();
        Assertions.assertThat(client.getId()).isNotNull();
        Assertions.assertThat(client.getName()).isNotNull();
    }
    @Test
    @DisplayName("Save update client when successful")
    void save_UpdateClient_WhenSuccessful(){
        var c = new Client(null, "Lucas",  "095.188.270-87", "lucas@gmail.com", "88888888", 18);

        var client = repository.save(c);

        client.setName("Leo");

        var clientUpdated = repository.save(client);

        Assertions.assertThat(client).isNotNull();
        Assertions.assertThat(client.getId()).isNotNull();
        Assertions.assertThat(clientUpdated.getName()).isEqualTo(client.getName());
    }
    @Test
    @DisplayName("Delete remove client when successful")
    void save_DeleteClient_WhenSuccessful(){
        var c = new Client(null, "Lucas",  "095.188.270-87", "lucas@gmail.com", "88888888", 18);

        var client = repository.save(c);

        repository.delete(client);

        Optional<Client> optionalClient = repository.findById(client.getId());

        Assertions.assertThat(optionalClient).isEmpty();
    }

    @Test
    @DisplayName("Find by cpf client when successful")
    void findByCpf_ReturnClient_WhenSuccessful(){
        var c = new Client(null, "Lucas",  "095.188.270-87", "lucas@gmail.com", "88888888", 18);

        var client = repository.save(c);

        var clientWithCpf = repository.findByCpf(client.getCpf());

        Assertions.assertThat(clientWithCpf.get().getCpf()).isEqualTo(client.getCpf());
    }


    @Test
    @DisplayName("Find by id when success")
    void findById_ReturnClient_WhenSuccess(){
        var c = new Client(null, "Lucas",  "095.188.270-87", "lucas@gmail.com", "88888888", 18);

        var client = repository.save(c);
        log.info(client.getId());
        var clientById = repository.findById(client.getId());

        Assertions.assertThat(clientById).isNotEmpty();
        Assertions.assertThat(client.getId()).isEqualTo(clientById.get().getId());
    }

}