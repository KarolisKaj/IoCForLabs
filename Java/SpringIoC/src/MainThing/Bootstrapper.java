package MainThing;

import MainThing.Dependencies.Calendar;
import MainThing.Dependencies.ICalendar;
import MainThing.Dependencies.ILogger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static java.lang.System.in;

/**
 * Created by Kay on 4/9/2017.
 */


public class Bootstrapper {
    AnnotationConfigApplicationContext ctx;
    public void Compose()
    {
        ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        String[] exportNames = ctx.getBeanDefinitionNames();
        System.out.println("//------CONTAINER CONTENT-------------");
        for (int i = 0; i < exportNames.length; i++){
            System.out.println(exportNames[i]);
        }
        System.out.println("//------CONTAINER CONTENT END---------");
    }

    public void Start()
    {
        if(ctx.getBean(Consumer.class).getService() != null){
            System.out.println("Service was injected successfully into setter!");
        }
    }

    public void Dispose()
    {
        ctx.close();
    }
}
