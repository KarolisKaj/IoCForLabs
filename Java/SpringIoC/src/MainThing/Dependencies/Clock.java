package MainThing.Dependencies;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by Kay on 4/24/2017.
 */
@Component
@Scope("prototype")
public class Clock implements IClock {

    @PostConstruct
    public void precreationMethod()
    {
        System.out.println("postCreation clock method called.    " + this.toString());
    }
    @PreDestroy
    public void predestroyMethod()
    {
        System.out.println("predestroy clock method called.    " + this.toString());
    }
    @Override
    public void initialize() {
        System.out.println("Initialized clock");
    }
}
