package MainThing.Dependencies;

import org.springframework.context.annotation.Bean;

/**
 * Created by Kay on 4/14/2017.
 */

public class OrderService implements IOrderService {

    private static  IOrderService orderService = new OrderService();
    private OrderService(){}

    @Bean
    public static IOrderService createInstance(){
        return  orderService;
    }
}
