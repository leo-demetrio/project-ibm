package ibm.grupo2.helloBank.config;


import ibm.grupo2.helloBank.model.Client;
import ibm.grupo2.helloBank.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private ClientRepository clientRepository;

    @Bean
    public void seederDB(){
        clientRepository.deleteAll();
        Client c = new Client(null, "Leo1", "123");
        Client c1 = new Client(null, "Leo3", "123");

        clientRepository.saveAll(List.of(c,c1));
    }
}
