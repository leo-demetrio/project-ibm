package ibm.grupo2.helloBank.controller;


import ibm.grupo2.helloBank.dto.ClientDto;
import ibm.grupo2.helloBank.model.Client;
import ibm.grupo2.helloBank.service.IClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
@Log4j2
public class ClientController {

    private final IClientService iClientService;
    private final ModelMapper modelMapper;


    @GetMapping
    public ResponseEntity<List<Client>> findAll(){
        return ResponseEntity.ok().body(iClientService.findAll());
    }

    @PostMapping
    public ResponseEntity<ClientDto> create(@RequestBody @Valid ClientDto clientDto){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(iClientService.create(clientDto).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> create(@PathVariable UUID id){
        Client client = iClientService.findById(id);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).body(modelMapper.map(client, ClientDto.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDto> update(@PathVariable UUID id, @RequestBody @Valid ClientDto clientDto){
        return ResponseEntity.ok().body(modelMapper.map(iClientService.update(id, clientDto), ClientDto.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        iClientService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/cpf")
    public ResponseEntity<Client> findByCpf(@RequestBody @Valid ClientDto clientDto){
        return ResponseEntity.ok().body(iClientService.findByCpf(clientDto.getCpf()));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String messageError = error.getDefaultMessage();
            errors.put(fieldName, messageError);
        });

        return errors;
    }
}
