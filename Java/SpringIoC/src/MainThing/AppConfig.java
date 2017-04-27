package MainThing;

import MainThing.Dependencies.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

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

    @Qualifier("PrimeLogger")
    @Primary
    @Scope("singleton")
    @Bean
    public ILogger primaryLogger(){
        return new LoggerPrime();
    }

    @Bean(name = "calendar")
    public FactoryBeanCalendar calendarFactory(){
        FactoryBeanCalendar factory = new FactoryBeanCalendar();
        factory.setType("Chinese");
        return factory;
    }
    @Bean
    public ICalendar calendar() throws Exception {
        try {
            return calendarFactory().getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
