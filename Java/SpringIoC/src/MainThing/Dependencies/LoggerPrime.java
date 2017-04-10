package MainThing.Dependencies;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by Kay on 4/9/2017.
 */


@Component
@Qualifier("PrimeLogger")
@Primary
@Scope("singleton")
public class LoggerPrime implements ILogger, DisposableBean {

    @Autowired
    public LoggerPrime()
    {
        System.out.println("LoggerPrime was created!");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Disposed logger prime.");
    }
}
