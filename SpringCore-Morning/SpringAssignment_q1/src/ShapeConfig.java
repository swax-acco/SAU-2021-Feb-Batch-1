import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShapeConfig {
    @Bean(name = "point0")
    public Point getPoint0() {
        return new Point(0, 0);
    }
    @Bean(name = "point1")
    public Point getPoint1() {
        return new Point(0, 1);
    }
    @Bean(name = "point2")
    public Point getPoint2() {
        return new Point(2, 0);
    }
    @Bean(name = "point3")
    public Point getPoint3() {
        return new Point(2, 1);
    }
    @Bean
    public Rectangle getRectangle(){
        return new Rectangle(1, 2);
    }

    @Bean(name="pointList")
	public ArrayList<Point> getPoint() {
		ArrayList<Point> points = new ArrayList<Point>();
		points.add(new Point(0, 0));
		points.add(new Point(0,20));
		points.add(new Point(10, 0));
		return points;
	}
    @Bean
    public Triangle getTriangle(){
        return new Triangle();
    }
}
