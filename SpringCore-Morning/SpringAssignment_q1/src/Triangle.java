import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Triangle {
    @Autowired
    @Qualifier("pointList")
    private ArrayList<Point> points;
    @Override
    public String toString() {
        return "Points: " + points.get(0).toString() + points.get(1).toString() + points.get(2).toString();
    }
}
