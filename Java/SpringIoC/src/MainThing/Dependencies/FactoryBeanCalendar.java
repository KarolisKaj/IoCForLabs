package MainThing.Dependencies;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.core.ResolvableType;

/**
 * Created by Kay on 4/21/2017.
 */

public class FactoryBeanCalendar implements FactoryBean<ICalendar> {

    private String _type = "Chinese";
    public void setType(String type){
        this._type = type;
    }

    @Override
    public ICalendar getObject() throws Exception {
        return new Calendar();
    }

    @Override
    public Class<ICalendar> getObjectType() {
       return ICalendar.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}