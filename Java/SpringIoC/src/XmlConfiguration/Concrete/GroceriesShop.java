package XmlConfiguration.Concrete;

import XmlConfiguration.Interfaces.IShopService;

/**
 * Created by Kay on 5/2/2017.
 */
public class GroceriesShop implements IShopService {
    private static IShopService groceriesShop = new GroceriesShop();
    private GroceriesShop() {}

    public static IShopService createInstance() {
        return groceriesShop;
    }
}
