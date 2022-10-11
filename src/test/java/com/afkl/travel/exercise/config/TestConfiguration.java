package com.afkl.travel.exercise.config;

import com.afkl.travel.exercise.client.TravelWebClient;
import com.afkl.travel.exercise.configuration.TravelConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(TravelConfiguration.class)
public class TestConfiguration {

    @Bean
    public TravelWebClient geTravelWebClient() {
        return new TravelWebClient();
    }
}
