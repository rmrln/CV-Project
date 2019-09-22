package fr.takima.demo;

import Controller.FileUploadController;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.File;

/**
 *
 */
@ComponentScan
@EnableJpaRepositories
@EnableAutoConfiguration
@SpringBootConfiguration
public class Application {

  public static void main(String[] args) {
    new File(FileUploadController.uploadDirectory).mkdir();
    new SpringApplicationBuilder(Application.class)
        .run();
  }

}
