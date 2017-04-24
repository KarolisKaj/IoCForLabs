package MainThing.Dependencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by Kay on 4/11/2017.
 */

public class ServiceSecondary implements IService
{
    private UUID _uuid;
    public ServiceSecondary() {
        _uuid = UUID.randomUUID();
        System.out.println("Created " + toString());
    }
    @Override
    public String toString() {
        return  "ServiceSecondary " + _uuid.toString();
    }

}
