import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class StaticTestCases
{
   private static final double DELTA = 0.00001;

   @Test
   public void test_vein_get_rate()
   {
      StaticEntity v = new Vein("test", 5, new Point(-21, 91), 1);
      assertEquals(v.get_rate(), 5, DELTA);
   }

   @Test
   public void test_vein_get_distance()
   {
      StaticEntity v = new Vein("test2", 12, new Point(23, -92), 1);
      assertEquals(v.get_resource_distance(), 1, DELTA);
   }

   @Test
   public void test_ore_get_rate()
   {
      StaticEntity o = new Ore("test", new Point(12, 27), 5000);
      assertEquals(o.get_rate(), 5000);
   }

   @Test
   public void test_quake_animation_rate()
   {
      StaticEntity q = new Quake("test", new Point(-172, 83), 53);
      assertEquals(q.get_animation_rate(), 53, DELTA);
   }
}
