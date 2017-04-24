package MainThing.Dependencies;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by Kay on 4/11/2017.
 */
@Component
@Scope("prototype")
public class Calendar implements ICalendar {
    private UUID _uuid;
    public Calendar()
    {
        _uuid = UUID.randomUUID();
        System.out.println("Created " + toString());
    }
    @Override
    public String toString() {
        return  "Calendar " + _uuid.toString();
    }
}
