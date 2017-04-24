package MainThing;

import MainThing.Dependencies.IService;
import MainThing.Dependencies.ServiceSecondary;
import org.springframework.context.annotation.*;

/**
 * Created by Kay on 4/9/2017.
 */

@Configuration
@ComponentScan(value = "MainThing")
public class AppConfig {

    @Bean
    @Primary
    @Scope("prototype")
    public IService serviceSecondary(){
        System.out.println("Bean Service created!");
        return new ServiceSecondary();
    }
}
