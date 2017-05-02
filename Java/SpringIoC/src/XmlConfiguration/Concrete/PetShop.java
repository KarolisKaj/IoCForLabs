package XmlConfiguration.Concrete;

import XmlConfiguration.Interfaces.IShopService;

/**
 * Created by Kay on 5/2/2017.
 */
public class PetShop implements IShopService {
    String _name;
    public PetShop(String name){
        _name = name;
    }
    public String getName(){return  _name;}
}
