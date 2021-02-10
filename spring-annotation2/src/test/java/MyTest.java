import com.ta.config.MainConfig;
import com.ta.pojo.Cat;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class MyTest {

    @Autowired
    private Cat cat;

    @Test
    public void test(){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);

        String[] beanDefinitionNames = context.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            log.info(beanDefinitionName);

        }

        Object cat = context.getBean("cat");
//        Object getCat = context.getBean("getCat");
//        log.info("getCat.eq(cat) --->{}",cat.equals(getCat));


        log.info("cat.hashCode {}",cat.toString());



    }

}
