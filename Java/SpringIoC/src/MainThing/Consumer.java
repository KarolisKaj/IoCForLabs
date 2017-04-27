package MainThing;

import MainThing.Dependencies.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Kay on 4/10/2017.
 */

@Component
@Scope("singleton")
public class Consumer
{
    @Autowired
    public Consumer(@Qualifier("SecondaryLogger") ILogger logger, ICalendar calendar, IClock clock, ClockManager clockManager)
    {
        if(logger != null)
            System.out.println("Logger was injected successfully!");
        if(calendar != null)
            System.out.println(calendar.toString()+" was injected successfully!");
        if(clock != null)
            System.out.println(clock.toString() + " was initialized correctly");
        if(clockManager !=null){
            System.out.println("Successfuly injected method override of " + clockManager.getClock().toString());
        }
    }


    @Autowired
    private IService _service;

    public IService getService(){
        return  _service;
    }
}
