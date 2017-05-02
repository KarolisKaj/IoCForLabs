package MainThing;

import MainThing.Dependencies.*;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Qualifier("SecondaryLogger")
    @Scope("singleton")
    @Bean
    public ILogger secodaryLogger(){
        return new LoggerSecondary();
    }



    @Bean
    @Qualifier("primaryCalendarFactory")
    public FactoryBeanCalendar primaryCalendarFactory(){
        return new FactoryBeanCalendar();
    }

    @Autowired
    @Bean(name = "chinnessCalendarFactory")
    @Qualifier("chinnessCalendarFactory")
    public FactoryBeanCalendar chinnessCalendarFactory(@Qualifier("primaryCalendarFactory") FactoryBeanCalendar factory){
        factory.setType("Chinese");
        return factory;
    }

    @Bean
    @Qualifier("chinnessCalendar")
    @Autowired
    public ICalendar calendar(@Qualifier("chinnessCalendarFactory") FactoryBeanCalendar defaultFactory) throws Exception {
        try {
            return defaultFactory.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
