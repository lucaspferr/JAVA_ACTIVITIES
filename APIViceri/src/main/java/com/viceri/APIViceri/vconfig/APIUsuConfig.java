package com.viceri.APIViceri.vconfig;

import com.viceri.APIViceri.vrepository.APIUsuRepository;
import com.viceri.APIViceri.vusu.APIUsu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class APIUsuConfig {

    @Bean
    CommandLineRunner commandLineRunner(APIUsuRepository repository){
        return args -> {
            APIUsu lucas = new APIUsu(
                    "Lucas",
                    "lucas.pferr194@gmail.com",
                    "123456"
            );

            APIUsu alberto = new APIUsu(
                    "Alberto",
                    "alberto.pferr194@gmail.com",
                    "123456"
            );

            repository.saveAll(List.of(lucas,alberto));

        };
    }
}
