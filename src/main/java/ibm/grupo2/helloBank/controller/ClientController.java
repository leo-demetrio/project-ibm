package ibm.grupo2.helloBank.controller;


import ibm.grupo2.helloBank.dto.ClientDto;
import ibm.grupo2.helloBank.model.Client;
import ibm.grupo2.helloBank.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
public class ClientController {

    private final IClientService iClientService;
    private final ModelMapper modelMapper;


    @GetMapping
    public ResponseEntity<List<Client>> findAll(){
        return ResponseEntity.ok().body(iClientService.findAll());
    }

    @PostMapping
    public ResponseEntity<ClientDto> create(@RequestBody ClientDto clientDto){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(iClientService.create(clientDto).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<ClientDto> create(@PathVariable UUID id){
        Client client = iClientService.findById(id);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).body(modelMapper.map(client, ClientDto.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDto> update(@PathVariable UUID id, @RequestBody ClientDto clientDto){
        return ResponseEntity.ok().body(modelMapper.map(iClientService.update(id, clientDto), ClientDto.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        iClientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
