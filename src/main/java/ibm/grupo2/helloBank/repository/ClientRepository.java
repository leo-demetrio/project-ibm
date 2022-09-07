package ibm.grupo2.helloBank.repository;


import ibm.grupo2.helloBank.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
    Optional<Client> findByCpf(String cpf);
}
