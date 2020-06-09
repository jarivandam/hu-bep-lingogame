package nl.jarivandam.lingogame;

import nl.jarivandam.lingogame.application.GameRepository;
import nl.jarivandam.lingogame.application.GameService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;

@Configuration
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class AppConfig {
    public String DEFAULT_DB_URL = "postgresql://dev:dev@localhost:54321/lingowords";

    @Bean
    public DataSource getDataSource() throws URISyntaxException {

        String dbUrl = System.getenv("DATABASE_URL");
        if (dbUrl == null) {
            dbUrl = DEFAULT_DB_URL;
        }
        URI dbUri = new URI (dbUrl);

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String resUri = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        return DataSourceBuilder
                .create()
                .url(resUri)
                .username(username)
                .password(password)
                .build();
    }
}
