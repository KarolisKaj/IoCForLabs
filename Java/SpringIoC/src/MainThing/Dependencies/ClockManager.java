package MainThing.Dependencies;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import java.time.Clock;

/**
 * Created by Kay on 4/24/2017.
 */
@Component
public abstract class ClockManager {
    public IClock getClock(){
        IClock clock = createClock();
        clock.initialize();
        return clock;
    }
    @Lookup("myClock")
    protected abstract IClock createClock();

}
