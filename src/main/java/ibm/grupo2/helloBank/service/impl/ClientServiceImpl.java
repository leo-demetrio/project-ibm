package ibm.grupo2.helloBank.service.impl;

import ibm.grupo2.helloBank.dto.ClientDto;
import ibm.grupo2.helloBank.exception.ObjectNotFoundException;
import ibm.grupo2.helloBank.model.Client;
import ibm.grupo2.helloBank.repository.ClientRepository;
import ibm.grupo2.helloBank.service.IClientService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
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
        Client client = clientRepository.findById(uuid).get();
        client.setName(clientDto.getName());
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

}
