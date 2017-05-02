package XmlConfiguration.Concrete;

import MainThing.Dependencies.IService;
import XmlConfiguration.Interfaces.IShopService;
import XmlConfiguration.Interfaces.IWebShop;

/**
 * Created by Kay on 5/2/2017.
 */
public abstract class CarWebShop implements IWebShop {

    public void process() {
        IShopService service = (IShopService)createService();
    }

    protected abstract IShopService createService();
}
