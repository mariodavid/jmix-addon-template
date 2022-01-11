package io.jmix.addon.template;

import io.jmix.core.annotation.JmixModule;
import io.jmix.core.security.InMemoryUserRepository;
import io.jmix.core.security.UserRepository;
import io.jmix.eclipselink.EclipselinkConfiguration;
import io.jmix.ui.UiConfiguration;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityDataConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@SpringBootConfiguration
@EnableAutoConfiguration
@Import(AddonConfiguration.class)
@JmixModule(dependsOn = {AddonConfiguration.class, EclipselinkConfiguration.class, UiConfiguration.class, SecurityDataConfiguration.class})
public class AddonTestConfiguration {


    @Bean
    public UserRepository userRepository() {
        return new InMemoryUserRepository();
    }

    @Bean
    @Primary
    DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .generateUniqueName(true)
                .setType(EmbeddedDatabaseType.HSQL)
                .build();
    }
}
