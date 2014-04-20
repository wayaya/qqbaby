package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: wayaya
 * Date: 14-4-1
 * Time: ����2:35
 */
@Configuration
@ComponentScan
public class Application {

    @Bean
    MessageService mockMessageSevice() {
        return new MessageService() {
            @Override
            public String getMessage() {
                return "Hello World";
            }
        };
    }

    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(Application.class);
        MessagePrinter messagePrinter=context.getBean(MessagePrinter.class);
        messagePrinter.printMessage();
    }
}
