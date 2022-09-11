package ibm.grupo2.helloBank.controller;

import ibm.grupo2.helloBank.model.Client;
import ibm.grupo2.helloBank.service.impl.ClientServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class ClientControllerTest {

    @InjectMocks
    private ClientController controller;

    @Mock
    private ClientServiceImpl service;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

    }

    @Test
    void findAll() {
        List<Client> clients = new ArrayList<>(List.of(new Client(UUID.randomUUID(), "Lucas",  "095.188.270-87", "lucas@gmail.com", "88888888", 18)));
        log.info(clients.get(0));
        BDDMockito.when(service.findAll()).thenReturn(clients);
        var listClients = controller.findAll();
        log.info(listClients.getBody());
        Assertions.assertThat(listClients.getBody()).isNotEmpty();
        Assertions.assertThat(listClients).isNotNull();
        Assertions.assertThat(listClients).isNotNull();
    }

    @Test
    void create() {
    }

    @Test
    void testCreate() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void findByCpf() {
    }

    @Test
    void handleValidationException() {
    }
}