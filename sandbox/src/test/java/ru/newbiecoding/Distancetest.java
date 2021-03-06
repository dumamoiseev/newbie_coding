package ru.newbiecoding;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.newbiecoding.Point;


public class Distancetest {
@Test
    public void distance1(){
        Point p1 = new Point(50, 10);
        Point p2 = new Point(50, 100);
        Assert.assertEquals(p2.distance(p1),90.0);
    }
    public void distance2(){
        Point p1 = new Point(0, 5);
        Point p2 = new Point(0, 10);
        Assert.assertEquals(p2.distance(p1),5.0);
    }
    public void distance3(){
        Point p1 = new Point(0, 50);
        Point p2 = new Point(0, 100);
        Assert.assertEquals(p2.distance(p1),50.0);
    }
}
