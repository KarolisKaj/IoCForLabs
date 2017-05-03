package XmlConfiguration.Concrete;

import XmlConfiguration.Interfaces.IShopService;

/**
 * Created by Kay on 5/2/2017.
 */
public class ShopCreator{
    public IShopService createService(){
        System.out.println("Lookup hit");
        return new GeneralShop();
    }
}
