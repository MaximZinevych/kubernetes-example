package hrytsenko;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @AllArgsConstructor
    @Component
    @EnableConfigurationProperties(ConfigVersionInfo.Properties.class)
    public static class ConfigVersionInfo implements InfoContributor {
        private Properties properties;

        @Override
        @SneakyThrows
        public void contribute(Info.Builder builder) {
            builder.withDetail("config", properties.getVersion());
        }

        @Data
        @ConfigurationProperties(prefix = "configuration-repository-app.config")
        static class Properties {
            private String version;
        }
    }

}
