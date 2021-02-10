import com.ta.bean.config.MainConfigOfLifeCycle;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class IOCTest {

    @Test
    public void test(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        log.info("AnnotationConfigApplicationContext....");
        context.close();
    }
}
