package guru.springframework.config;

import guru.springframework.examplebeans.FakaDataSource;
import guru.springframework.examplebeans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource({"classpath:datasource.properties","classpath:jms.properties"})
public class PropertyConfig {

    @Value("${guru.username}")
    String username;

    @Value("${guru.password}")
    String password;

    @Value("${guru.url}")
    String url;

    @Value("${guru.jms.username}")
    String jmsUsername;

    @Value("${guru.jms.password}")
    String jmsPassword;

    @Value("${guru.jms.url}")
    String jmsUrl;

    @Autowired
    Environment env;
    @Bean
    public FakaDataSource fakaDataSource(){
        FakaDataSource fakaDataSource=new FakaDataSource();
        fakaDataSource.setPassword(password);
        fakaDataSource.setUsername(env.getProperty("_USERNAME"));
        fakaDataSource.setUrl(url);
        return fakaDataSource;
    }
    @Bean
    public FakeJmsBroker fakeJmsBroker(){
        FakeJmsBroker fakaDataSource=new FakeJmsBroker();
        fakaDataSource.setPassword(jmsPassword);
        fakaDataSource.setUsername(jmsUsername);
        fakaDataSource.setUrl(url);
        return fakaDataSource;
    }
    @Bean
    public static PropertySourcesPlaceholderConfigurer properties(){
        return      new   PropertySourcesPlaceholderConfigurer();

    }
}
