import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class IndividualTestCases
{
   private static final double DELTA = 0.0001;

   @Test
   public void test_individual_get_rate()
   {
      Individual i = new Blacksmith("test", new Point(3, 12), 52, 3, 1);
      assertEquals(i.get_rate(), 3, DELTA);
   }

   @Test
   public void test_individual_inherit()
   {
      Individual i = new Blacksmith("test", new Point(45, -33), 34, 21, 1);
      Point p2 = new Point(123, 5);

      assertTrue(i.get_name().equals("test"));

      assertEquals(i.get_position().xCoordinate(), 45, DELTA);
      assertEquals(i.get_position().yCoordinate(), -33, DELTA);

      i.set_position(p2);
      assertEquals(i.get_position().xCoordinate(), 123, DELTA);
      assertEquals(i.get_position().yCoordinate(), 5, DELTA); 
   }

   @Test
   public void test_m_e_inherit()
   {
      MovingEntity i = new OreBlob("test_i", new Point(-23, 35), 33, 20);
      Point p2 = new Point(12, 9);

      assertTrue(i.get_name().equals("test_i"));

      assertEquals(i.get_position().xCoordinate(), -23, DELTA);
      assertEquals(i.get_position().yCoordinate(), 35, DELTA);

      i.set_position(p2);
      assertEquals(i.get_position().xCoordinate(), 12, DELTA);
      assertEquals(i.get_position().yCoordinate(), 9, DELTA);

      assertEquals(i.get_rate(), 33, DELTA);
   }

   @Test
   public void test_miner_inherit()
   {
      Miner m = new MinerFull("test", 5, new Point(12, 4), 43, 3);
      assertTrue(m.get_name().equals("test"));
      assertEquals(m.get_resource_limit(), 5);
      assertEquals(m.get_position().xCoordinate(), 12);
      assertEquals(m.get_position().yCoordinate(), 4);
      assertEquals(m.get_rate(), 43);
      assertEquals(m.get_animation_rate(), 3);
   }

   @Test
   public void test_blacksmith_inherit()
   {
      Individual b = new Blacksmith("test", new Point(2, 3), 3, 12, 1);
      assertTrue(b.get_name().equals("test"));
      assertEquals(b.get_position().xCoordinate(), 2);
      assertEquals(b.get_position().yCoordinate(), 3);
      assertEquals(b.get_resource_limit(), 3);
      assertEquals(b.get_resource_count(), 0);
      assertEquals(b.get_resource_distance(), 1);

      b.set_resource_count(5);
      assertEquals(b.get_resource_count(), 5);
   }

   @Test
   public void test_oreblob_inherit()
   {
      MovingEntity o = new OreBlob("test1", new Point(3, 2), 23, 12);
      assertTrue(o.get_name().equals("test1"));
      assertEquals(o.get_position().xCoordinate(), 3);
      assertEquals(o.get_position().yCoordinate(), 2);
      assertEquals(o.get_animation_rate(), 12);
   }

   @Test
   public void test_minerNotFull_inherit()
   {
      Miner m = new MinerNotFull("test", 3, new Point(12, 3), 2, 12);
      assertTrue(m.get_name().equals("test"));
      assertEquals(m.get_position().xCoordinate(), 12);
      assertEquals(m.get_position().yCoordinate(), 3);
      assertEquals(m.get_resource_limit(), 3);
      assertEquals(m.get_resource_count(), 0);

      m.set_resource_count(3);
      assertEquals(m.get_resource_count(), 3);
   }

   @Test
   public void test_minerFull_inherit()
   {
      Miner m = new MinerFull("test1", 43, new Point(12, 3), 32, 19);
      assertTrue(m.get_name().equals("test1"));
      assertEquals(m.get_position().xCoordinate(), 12);
      assertEquals(m.get_position().yCoordinate(), 3);
      assertEquals(m.get_resource_limit(), 43);
      assertEquals(m.get_resource_count(), 43);

      m.set_resource_count(10);
      assertEquals(m.get_resource_count(), 10);
   }

   @Test
   public void test_m_e_animation_rate()
   {
      MovingEntity m = new OreBlob("test", new Point(4, 3), 12, 40);
      assertEquals(m.get_animation_rate(), 40, DELTA);
   }

   @Test
   public void test_blacksmith_get_limit()
   {
      Individual b = new Blacksmith("test1", new Point(3, 122), 44, 55, 1);
      assertEquals(b.get_resource_limit(), 44, DELTA);
   }

   @Test
   public void test_blacksmith_get_count()
   {
      Individual b = new Blacksmith("test2", new Point(-12, 344), 32, 2, 1);
      assertEquals(b.get_resource_count(), 0, DELTA);
   }

   @Test
   public void test_blacksmith_set_count()
   {
      Individual b = new Blacksmith("test3", new Point(-43, 12), 20, 42, 1);
      b.set_resource_count(4);
      assertEquals(b.get_resource_count(), 4, DELTA);
   }

   @Test
   public void test_blacksmith_get_distance()
   {
      Individual b = new Blacksmith("test4", new Point(12, 923), 4, 12, 1);
      assertEquals(b.get_resource_distance(), 1, DELTA);
   }

   @Test
   public void test_get_limit()
   {
      Miner m = new MinerFull("test1", 2, new Point(434, 12), 33, 11);
      assertEquals(m.get_resource_limit(), 2, DELTA);
   }

   @Test
   public void test_get_count()
   {
      Miner m = new MinerFull("test2", 31, new Point(23, 133), 10, 25);
      assertEquals(m.get_resource_count(), 31, DELTA);
   }

   @Test
   public void test_set_count()
   {
      Miner m = new MinerFull("test3", 12, new Point(-124, 44), 3, 112);
      m.set_resource_count(3);
      assertEquals(m.get_resource_count(), 3, DELTA);
   }   
   
   
   @Test
   public void test_not_full_toentity()
   {
      Miner m = new MinerNotFull("test", 3, new Point(-12, 2), 4, 12);
      assertEquals(m.to_entity(), Ore.class);
   }
   

   @Test
   public void test_not_full_status()
   {
      Miner m = new MinerNotFull("test", 3, new Point(22, 16), 32, 5);
      m.set_resource_count(2);
      Miner m2 = m.try_transform_miner_status();

      assertTrue(m2 instanceof MinerNotFull);
      assertTrue(m2.get_name().equals("test"));

      assertEquals(m2.get_resource_limit(), 3, DELTA);

      assertEquals(m2.get_position().xCoordinate(), 22, DELTA);
      assertEquals(m2.get_position().yCoordinate(), 16, DELTA);

      assertEquals(m2.get_rate(), 32, DELTA);
      assertEquals(m2.get_animation_rate(), 5, DELTA);
   }

   @Test
   public void test_not_full_status2()
   {
      Miner m = new MinerNotFull("test2", 9, new Point(-10, 20), 91, 2);
      m.set_resource_count(15);
      Miner m2 = m.try_transform_miner_status();

      assertTrue(m2 instanceof MinerFull);
      assertTrue(m2.get_name().equals("test2"));

      assertEquals(m2.get_resource_limit(), 9, DELTA);

      assertEquals(m2.get_position().xCoordinate(), -10, DELTA);
      assertEquals(m2.get_position().yCoordinate(), 20, DELTA);

      assertEquals(m2.get_rate(), 91, DELTA);
      assertEquals(m2.get_animation_rate(), 2, DELTA);
   }
   
   @Test
   public void test_full_toentity()
   {
      Miner m = new MinerFull("test", 32, new Point(33, -1), 9, 10);
      assertEquals(m.to_entity(), Blacksmith.class);
   }
   

   @Test
   public void test_full_status()
   {
      Miner m = new MinerFull("test", 102, new Point(92, -37), 14, 27);
      Miner m2 = m.try_transform_miner_status();

      assertTrue(m2 instanceof MinerNotFull);

      assertTrue(m2.get_name().equals("test"));
      assertEquals(m2.get_resource_limit(), 102, DELTA);

      assertEquals(m2.get_position().xCoordinate(), 92, DELTA);
      assertEquals(m2.get_position().yCoordinate(), -37, DELTA);

      assertEquals(m2.get_rate(), 14, DELTA);
      assertEquals(m2.get_animation_rate(), 27, DELTA);
   }

   @Test
   public void test_miner_full_to()
   {
      WorldObject b = new Background("test");
      WorldModel world = new WorldModel(4, 5, b);
      Individual s = new Blacksmith("test1", new Point(1, 1), 32, 3, 1);
      Miner m = new MinerFull("test2", 3, new Point(1, 2), 4, 3);

      assertTrue(m.miner_to(world, s));
   }
}


