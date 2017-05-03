package XmlConfiguration.Concrete;

import XmlConfiguration.Interfaces.IService;
import XmlConfiguration.Interfaces.IWebShop;

/**
 * Created by Kay on 5/2/2017.
 */
public class CarWebShop implements IWebShop {
public CarWebShop(IService service){
    service.process();
}
}
