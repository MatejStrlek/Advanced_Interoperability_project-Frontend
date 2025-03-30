package hr.algebra.advanced_interoperability_projectfrontend.config;

import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class RestTemplateFactory {
    public static RestTemplate createRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        jsonConverter.setSupportedMediaTypes(List.of(MediaType.APPLICATION_JSON));
        StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();

        restTemplate.setMessageConverters(List.of(
                jsonConverter,
                stringConverter
        ));

        return restTemplate;
    }
}
