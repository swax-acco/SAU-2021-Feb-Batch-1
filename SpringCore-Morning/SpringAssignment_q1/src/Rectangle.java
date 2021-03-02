import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Rectangle {
    @Autowired
    @Qualifier("point0")
    private Point p0;
    @Autowired
    @Qualifier("point1")
    private Point p1;
    @Autowired
    @Qualifier("point2")
    private Point p2;
    @Qualifier("point3")
    @Autowired
    private Point p3;

    private int height, width;

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public String toString() {
        return "Points: " + p0.toString() + p1.toString() + p2.toString() + p3.toString() + "\nHeight: " +
        String.valueOf(height) + "\nWidth: " + String.valueOf(width);
    }

    

}
