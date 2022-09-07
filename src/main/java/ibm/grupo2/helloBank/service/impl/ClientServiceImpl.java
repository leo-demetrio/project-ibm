package ibm.grupo2.helloBank.service.impl;

import ibm.grupo2.helloBank.dto.ClientDto;
import ibm.grupo2.helloBank.exception.ObjectNotFoundException;
import ibm.grupo2.helloBank.exception.NoSuchElementException;
import ibm.grupo2.helloBank.model.Client;
import ibm.grupo2.helloBank.repository.ClientRepository;
import ibm.grupo2.helloBank.service.IClientService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
@Log4j2
public class ClientServiceImpl implements IClientService {

    private final ClientRepository clientRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    @Override
    public Client create(ClientDto clientDto){
        return clientRepository.save(modelMapper.map(clientDto, Client.class));
    }

    @Override
    public Client update(UUID uuid, ClientDto clientDto) {
        clientRepository.findById(uuid);
        Client client = modelMapper.map(clientDto, Client.class);
        client.setId(uuid);
        return clientRepository.save(client);
    }

    @Override
    public void delete(UUID uuid) {
        findById(uuid);
        clientRepository.deleteById(uuid);
    }

    @Override
    public Client findById(UUID id){
        return clientRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Client not found"));
    }
    @Override
    public Client findByCpf(String cpf){
        return clientRepository.findByCpf(cpf).orElseThrow(() -> new NoSuchElementException("Client not found"));
    }

}
