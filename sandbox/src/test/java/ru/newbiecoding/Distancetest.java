package ru.newbiecoding;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.newbiecoding.Point;


public class Distancetest {
@Test
    public void distance1(){
        Point p1 = new Point(0, 5);
        Point p2 = new Point(0, 10);
        Assert.assertEquals(p2.distance(p1),5.0);
    }
}
