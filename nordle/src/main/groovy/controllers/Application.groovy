package Controllers

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan

import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(["controllers", "services"])
@EnableAutoConfiguration
class Application {

    public static void main(String [] args){
        print("Main context initializer")

        SpringApplication.run(Application.class, args);


    }
}