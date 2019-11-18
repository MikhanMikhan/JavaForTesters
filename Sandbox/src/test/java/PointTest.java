import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {
    @Test
    public void testArea1(){
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 4);
        Assert.assertEquals( p1.distance(p2), 5.0);
    }

    @Test
    public void testArea2(){
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 0);
        Assert.assertEquals( p1.distance(p2), 0);
    }

    @Test
    public void testArea3(){
        Point p1 = new Point(2, 2);
        Point p2 = new Point(2, 2);
        Assert.assertEquals( p1.distance(p2), 0);
    }

    @Test
    public void testArea4(){
        Point p1 = new Point(-0.1, -0.1);
        Point p2 = new Point(0.3, 0.2);
        Assert.assertEquals( p1.distance(p2), 0.5);
    }


}

