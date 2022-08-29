package cn.liyu.config;


import com.fasterxml.jackson.databind.util.Converter;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Address;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.convert.ElasticsearchCustomConversions;
import org.springframework.http.HttpHeaders;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
@Slf4j
public class Config extends AbstractElasticsearchConfiguration {
    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {

        //Define default headers, if they need to be customized
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("some-header", "on every request");

        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                //Use the builder to provide cluster addresses, set default HttpHeaders or enable SSL.
                .connectedTo("192.168.253.130:9200")
                //Optionally enable SSL
//                .usingSsl()
                //Optionally set a proxy
//                .withProxy("localhost:8888")
                //Optionally set a path prefix, mostly used when different clusters a behind some reverse proxy
//                .withPathPrefix("ela")
                //Set the connection timeout.Default is 10 sec.
                .withConnectTimeout(Duration.ofSeconds(5))
                //Set the socket timeout.Default is 5 sec
                .withSocketTimeout(Duration.ofSeconds(3))
//                .withDefaultHeaders(httpHeaders)
//                .withBasicAuth("username", "password")
                //A Supplier<Header> function can be specified which is called every time before a request is sent to Elasticsearch - here,
                // as an example, the current time is written in a header
                .withHeaders(() -> {
                    HttpHeaders headers = new HttpHeaders();
                    headers.add("currentTime", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
                    return headers;
                })
                //for reactive setup a function configuring the WebClient
//                .withClientConfigurer(
//                        ReactiveRestClients.WebClientConfigurationCallback.from(webClient -> {
//                            // ...
//                            log.info("for reactive setup a function configuring the WebClient");
//                            return webClient;
//                        }))
                //for non-reactive setup a function configuring the REST client
                .withClientConfigurer(
                        RestClients.RestClientConfigurationCallback.from(clientBuilder -> {
                            // ...
                            log.info("for non-reactive setup a function configuring the REST client");
                            return clientBuilder;
                        }))

                .build();

        return RestClients.create(clientConfiguration).rest();
    }

/**
 * Custom Conversions
 */
//    @Bean
//    @Override
//    public ElasticsearchCustomConversions elasticsearchCustomConversions() {
//        return new ElasticsearchCustomConversions(
//                Arrays.asList(new AddressToMap(), new MapToAddress()));
//    }


}
