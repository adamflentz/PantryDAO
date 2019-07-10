package com.adamlentz.pantryDao;

import com.adamlentz.pantryDao.clients.AuthClient;
import com.adamlentz.pantryDao.controller.PantryController;
import com.adamlentz.pantryDao.controller.RecipeController;
import com.adamlentz.pantryDao.repositories.PantryRepository;
import com.adamlentz.pantryDao.repositories.RecipeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class}, scanBasePackageClasses = {PantryController.class, RecipeController.class, AuthClient.class})
@EnableJpaRepositories(basePackageClasses = {PantryRepository.class, RecipeRepository.class})
@EnableSwagger2
public class PantryApplication {
    public static void main(String[] args) {
        SpringApplication.run(PantryApplication.class, args);
    }

}

