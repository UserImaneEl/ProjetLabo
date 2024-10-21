package projet.libre.ProjetLabo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/getMessage")
                .allowedOrigins("http://localhost:3000") // Assurez-vous que c'est le port de votre frontend
                .allowedMethods("GET");
    }
}
