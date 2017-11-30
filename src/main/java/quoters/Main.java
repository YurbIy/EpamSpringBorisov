package quoters;

import com.sun.org.apache.bcel.internal.util.ClassPath;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        while (true) {
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        context.getBean(quoters.Quoter.class).sayQuote();
        }

    }
}
