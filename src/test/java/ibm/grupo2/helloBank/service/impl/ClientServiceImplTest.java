package ibm.grupo2.helloBank.service.impl;

import ibm.grupo2.helloBank.dto.ClientDto;
import ibm.grupo2.helloBank.exception.ObjectNotFoundException;
import ibm.grupo2.helloBank.model.Client;
import ibm.grupo2.helloBank.repository.ClientRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
@Log4j2
@SpringBootTest
class ClientServiceImplTest {

    private static final UUID ID = UUID.fromString("7b1b8b55-f8d7-409a-a769-1bde4c1271df");
    public static final String NAME = "Lucas";
    public static final String CPF = "095.188.270-87";
    public static final String EMAIL = "lucas@gmail.com";
    public static final String TELEPHONE = "88888888";
    public static final int AGE = 18;

    @InjectMocks
    private ClientServiceImpl service;
    @Mock
    private ClientRepository repository;
    @Mock
    private ModelMapper mapper;

    private Client client;
    private ClientDto clientDto;
    private Optional<Client> optionalClient;

    @BeforeEach
    void setUp() {
        startClient();
        MockitoAnnotations.openMocks(this);
        Mockito.when(repository.findById(Mockito.any())).thenReturn(optionalClient);
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void whenFindByIdThenReturnAnClientInstance() {
        var client1 = service.findById(ID);
        assertEquals(Client.class, client1.getClass());
    }
    @Test
    void whenFindByIdThenReturnAnObjectNotFoundException() {
        Mockito.when(repository.findById(ID)).thenThrow(new ObjectNotFoundException("Client not found"));
        try {
            service.findById(ID);
        }catch (Exception ex){
            assertEquals(ObjectNotFoundException.class, ex.getClass());
        }
    }

    @Test
    void findByCpf() {
    }

    private void startClient(){
        client = new Client(ID, NAME, CPF, EMAIL, TELEPHONE, AGE);
        clientDto = new ClientDto(NAME, CPF, EMAIL, TELEPHONE, AGE);
        optionalClient = Optional.of(new Client(ID, NAME, CPF, EMAIL, TELEPHONE, AGE));

    }
}