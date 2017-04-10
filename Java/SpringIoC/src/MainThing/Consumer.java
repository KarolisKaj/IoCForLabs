package MainThing;

import MainThing.Dependencies.ILogger;
import MainThing.Dependencies.IService;
import MainThing.Dependencies.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Kay on 4/10/2017.
 */

@Configuration
@Component
@Scope("singleton")
public class Consumer
{
    @Autowired
    public Consumer(@Qualifier("SecondaryLogger") ILogger logger)
    {
        if(logger != null)
            System.out.println("Logger was injected successfully!");
    }

    @Autowired
    private IService _service;

    public IService getService(){
        return  _service;
    }
}
