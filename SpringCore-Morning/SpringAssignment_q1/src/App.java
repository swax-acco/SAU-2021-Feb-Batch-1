import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext factory = new AnnotationConfigApplicationContext(ShapeConfig.class);
        Rectangle rectangle = factory.getBean(Rectangle.class);
        Triangle triangle = factory.getBean(Triangle.class);
        System.out.println("Rectangle\n" + rectangle);
        System.out.println("Triangle\n" + triangle);
        ((AbstractApplicationContext) factory).close();
    }
}
