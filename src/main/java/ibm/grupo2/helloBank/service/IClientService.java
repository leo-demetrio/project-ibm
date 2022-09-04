package ibm.grupo2.helloBank.service;

import ibm.grupo2.helloBank.dto.ClientDto;
import ibm.grupo2.helloBank.model.Client;

import java.util.List;
import java.util.UUID;

public interface IClientService {
    Client findById(UUID uuid);
    List<Client> findAll();
    Client create(ClientDto clientDto);
    Client update(UUID uuid, ClientDto clientDto);
    void delete(UUID uuid);
}
