package MainThing.Dependencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Kay on 4/10/2017.
 */
@Component
@Scope("non-singleton")
public class Service implements IService {
@Autowired
    public Service(@Qualifier("PrimeLogger") ILogger logger){
    System.out.println("Service created. Logger injected.");
}
}
