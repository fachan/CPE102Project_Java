import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class WorldObjectTestCases
{
   private static final double DELTA = 0.00001;

   @Test
   public void test_background_inherit()
   {
      WorldObject o = new Background("test");
      assertTrue(o.get_name().equals("test"));
   }

   @Test
   public void test_obstacle_inherit()
   {
      WorldObject o = new Obstacle("test", new Point(3, 2));
      assertTrue(o.get_name().equals("test"));
   }
   
   @Test
   public void test_obstacle_getpos()
   {
      Point p = new Point(3, -12);
      WorldObject o = new Obstacle("test", p);

      Point p2 = o.get_position();
      assertEquals(p2.xCoordinate(), 3, DELTA);
      assertEquals(p2.yCoordinate(), -12, DELTA);
   }
   
   @Test
   public void test_obstacle_setpos()
   {
      Point p1 = new Point(3, 5);
      Point p2 = new Point(2, -4);

      WorldObject o = new Obstacle("test", p1);
      o.set_position(p2);
      assertEquals(o.get_position().xCoordinate(), 2, DELTA);
      assertEquals(o.get_position().yCoordinate(), -4, DELTA);
   }
}
