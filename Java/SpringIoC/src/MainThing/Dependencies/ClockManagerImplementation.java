package MainThing.Dependencies;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by Kay on 4/24/2017.
 */
@Component
public class ClockManagerImplementation {
    @Bean("myClock")
    public IClock createClock() {
        return new Clock();
    }
}
