package MainThing.Dependencies;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.naming.Name;
import java.util.UUID;

/**
 * Created by Kay on 4/11/2017.
 */
public class Calendar implements ICalendar {
    private String _name;
    public Calendar(String name)
    {
        _name = name;
        System.out.println("Created " + toString());
    }
    @Override
    public String toString() {
        return  "Calendar " + _name;
    }
}
