import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class PointTestCases
{
   private static final double DELTA = 0.00001;

   @Test
   public void test_point_x1()
   {
      Point p = new Point(4, -1);
      assertEquals(4, p.xCoordinate(), DELTA);
   }

   @Test
   public void test_point_y1()
   {
      Point p = new Point(6, -123);
      assertEquals(-123, p.yCoordinate(), DELTA);
   }
   
   @Test
   public void test_pt_distance1()
   {
      Point p = new Point(0, -12);
      Point p2 = new Point(-212, -1);
      assertEquals(45065, p.distance_sq(p2), DELTA);
   }

   @Test
   public void test_pt_distance2()
   {
      Point p = new Point(5, 25);
      Point p2 = new Point(0, -23);
      assertEquals(2329, p.distance_sq(p2), DELTA);
   }
   
   @Test
   public void test_pt_adjacent()
   {
      Point p = new Point(-1, 2);
      Point p2 = new Point(-1, 3);
      assertTrue(p.adjacent(p2));
   }

   @Test
   public void test_pt_adjacent2()
   {
      Point p = new Point(3, -12);
      Point p2 = new Point(2, -12);
      assertTrue(p.adjacent(p2));
   }

   @Test
   public void test_pt_adjacent3()
   {
      Point p = new Point(0, -2);
      Point p2 = new Point(124, 21);
      assertFalse(p.adjacent(p2));
   }
}
