import com.ta.bean.Person;
import com.ta.bean.config.MainConfig;
import com.ta.bean.config.MainConfig2;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;


@Slf4j
public class MyTest {

    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");



    @Test
    public void test(){


        Object person = context.getBean("person");
        System.out.println(person);

        context.close();

    }

    @Test
    public void testAnnotation(){
        AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(MainConfig.class);
        Person bean = context2.getBean(Person.class);
        System.out.println(bean);

        String[] beanNamesForType = context2.getBeanNamesForType(Person.class);

        for (String s : beanNamesForType) {
            System.out.println(s);
        }

    }
    @Test
    public void testAnnotation2(){

        AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(MainConfig.class);
//        Person bean = context2.getBean(Person.class);
//        System.out.println(bean);

        String[] beanNamesForType = context2.getBeanDefinitionNames();

        for (String s : beanNamesForType) {
            log.info("=====> "+s);
        }

    }

    @Test
    public void testScpe(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);

        ConfigurableEnvironment environment = context.getEnvironment();
        Map<String, Object> systemProperties = environment.getSystemProperties();
        log.info("systemProperties----> {} " +systemProperties);
        String property = environment.getProperty("os.name");

        log.info("property---> {} ",property);




        Object person = context.getBeansOfType(Person.class);

        log.info("---===="+person);


    }

    @Test
    public void testImport(){
        printBeanNames();

    }

//    @ImportSelector
    @Test
    public void testImportSelector(){
        printBeanNames();


    }


    public  void printBeanNames(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);

        String[] beanDefinitionNames = context.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            log.info("beanDefinitionName -->{}",beanDefinitionName);
        }

        Object colorFactoryBean = context.getBean("&colorFactoryBean");

        System.out.println(colorFactoryBean);

    }

}
