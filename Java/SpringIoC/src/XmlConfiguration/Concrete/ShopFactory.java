package XmlConfiguration.Concrete;

import XmlConfiguration.Interfaces.IShopService;
import org.springframework.beans.factory.FactoryBean;

/**
 * Created by Kay on 5/2/2017.
 */
public class ShopFactory implements FactoryBean {

    private String _name = "ZooKeepers";
    public void setName(String name){
        this._name = name;
    }
    @Override
    public Object getObject() throws Exception {
        return new PetShop(_name);
    }

    @Override
    public Class<IShopService> getObjectType() {
        return IShopService.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
