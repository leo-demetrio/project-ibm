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
        Client c = new Client(null, "Lucas",  "095.188.270-87", "lucas@gmail.com", "88888888", 18);
        Client c1 = new Client(null, "Leo","761.857.370-00",  "leo@gmail.com", "999999999", 21);

        clientRepository.saveAll(List.of(c,c1));
    }
}
