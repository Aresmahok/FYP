package Controllers

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan

//import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

/**
 * Created by mcmahok8 on 30/12/2014.
 */
@Configuration
@ComponentScan(["Controllers", "Services"])
@EnableAutoConfiguration
class Application {

    public static void main(String [] args){
        print("Main context initializer")

        SpringApplication.run(Application.class, args);


    }
}
