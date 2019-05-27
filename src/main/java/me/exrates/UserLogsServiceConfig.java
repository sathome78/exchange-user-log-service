package me.exrates;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.log4j.Log4j2;
import me.exrates.config.DatabaseConfiguration;
import me.exrates.config.RabbitConfig;
import me.exrates.config.ResourcesServerConfiguration;
import me.exrates.config.SSMConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Log4j2
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableDiscoveryClient
@Import({
        DatabaseConfiguration.class,
        SSMConfiguration.class,
        ResourcesServerConfiguration.class,
        RabbitConfig.class
})
public class UserLogsServiceConfig {

    @Bean
    public ObjectMapper mapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
