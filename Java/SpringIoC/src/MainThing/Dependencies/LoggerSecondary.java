package MainThing.Dependencies;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Kay on 4/10/2017.
 */
public class LoggerSecondary implements ILogger {

    public LoggerSecondary()
    {
        System.out.println("LoggerSecondary was created!");
    }
}
