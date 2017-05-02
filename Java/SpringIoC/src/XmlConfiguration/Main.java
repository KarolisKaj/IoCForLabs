package XmlConfiguration;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Kay on 5/2/2017.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("XmlConfiguration/DependenciesMap.xml");
        String[] exportNames = context.getBeanDefinitionNames();
        System.out.println("//------CONTAINER CONTENT-------------");
        for (int i = 0; i < exportNames.length; i++){
            System.out.println(exportNames[i]);
        }
        System.out.println("//------CONTAINER CONTENT END---------");
    }
}
