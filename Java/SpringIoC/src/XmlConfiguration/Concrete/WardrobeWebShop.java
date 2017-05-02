package XmlConfiguration.Concrete;

import XmlConfiguration.Interfaces.IShopService;
import XmlConfiguration.Interfaces.IWebShop;

/**
 * Created by Kay on 5/2/2017.
 */
public class WardrobeWebShop implements IWebShop {


public WardrobeWebShop(IShopService shopService){

}
    public void setOtherShopService(IShopService otherShopService) {
        this.otherShopService = otherShopService;
    }
    private IShopService otherShopService;
}
