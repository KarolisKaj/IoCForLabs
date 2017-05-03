package XmlConfiguration.Concrete;

import XmlConfiguration.Interfaces.IService;
import XmlConfiguration.Interfaces.IShopService;
import org.springframework.beans.factory.annotation.Lookup;

/**
 * Created by Kay on 5/3/2017.
 */
public abstract class LaunchService implements IService {

    public LaunchService(ShopFactory factory) throws Exception {
        factory.getObject();
    }

    public void process() {
        IShopService service = createService();
        service.hashCode();
        System.out.println(service.toString());
    }

    protected abstract IShopService createService();
}
