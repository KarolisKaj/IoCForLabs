package XmlConfiguration.Concrete;

import XmlConfiguration.Interfaces.IService;
import XmlConfiguration.Interfaces.IShopService;

/**
 * Created by Kay on 5/3/2017.
 */
public abstract class LaunchService implements IService {

    public void process() {
        IShopService service = (IShopService)createService();
        System.out.println(service.toString());
    }

    protected abstract IShopService createService();
}
