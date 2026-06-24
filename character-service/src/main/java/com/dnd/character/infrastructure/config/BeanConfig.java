package com.dnd.character.infrastructure.config;

import com.dnd.character.application.port.output.ClassServicePort;
import com.dnd.character.application.port.output.RaceServicePort;
import com.dnd.shared.ClassDTO;
import com.dnd.shared.RaceDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {

    @Value("${race.service.url:http://localhost:8082}")
    private String raceServiceUrl;

    @Value("${class.service.url:http://localhost:8083}")
    private String classServiceUrl;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public RaceServicePort raceServicePort(RestTemplate restTemplate) {
        return new RaceServicePort() {
            @Override
            public RaceDTO getRaceByName(String name) {
                String url = raceServiceUrl + "/api/races/name/" + name;
                return restTemplate.getForObject(url, RaceDTO.class);
            }
        };
    }

    @Bean
    public ClassServicePort classServicePort(RestTemplate restTemplate) {
        return new ClassServicePort() {
            @Override
            public ClassDTO getClassByName(String name) {
                String url = classServiceUrl + "/api/classes/name/" + name;
                return restTemplate.getForObject(url, ClassDTO.class);
            }
        };
    }
}
