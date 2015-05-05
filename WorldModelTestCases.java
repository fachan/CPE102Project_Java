import java.util.List;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;


public class WorldModelTestCases
//Contains test cases for WorldModel and Occ_Grid
{
   private static final double DELTA = 0.00001;
   
   @Test
   public void test_grid_get()
   {
      Point p = new Point(1, 29);
      WorldObject val = new Background("test");
      Grid g = new Grid(44, 30, val);

      assertTrue(g.get_cell(p) instanceof Background);
      assertTrue(g.get_cell(p).get_name().equals("test"));
   }

   @Test
   public void test_grid_set()
   {
      Point p = new Point(2, 3);
      WorldObject val1 = new Background("test1");
      WorldObject val2 = new Vein("testVein", 4, p, 1);
      Grid g = new Grid(11, 12, val1);

      g.set_cell(p, val2);
      assertTrue(g.get_cell(p) instanceof Vein);
   }
   
   @Test
   public void test_get_background()
   {
      WorldObject b = new Background("test2");
      WorldObject b2 = new Background("test3");
      WorldModel w = new WorldModel(4, 12, b);
      Point p = new Point(1, 3);

      w.set_background(p, b2);
      WorldObject b3 = w.get_background(p);
      assertTrue(b3 instanceof Background);
      assertTrue(b3.get_name().equals("test3"));
   }
      
   @Test
   public void test_get_background2()
   {
      WorldObject b = new Background("test3");
      WorldModel w = new WorldModel(3, 4, b);
      Point p = new Point(12, 35);

      WorldObject b2 = w.get_background(p);
      assertEquals(b2, null);
   }

   @Test
   public void test_set_background()
   {
      WorldObject b = new Background("test3");
      WorldObject b2 = new Background("test4");
      WorldModel w = new WorldModel(14, 23, b);
      Point p = new Point(3, 4);

      w.set_background(p, b2);
      assertTrue(w.get_background(p).get_name().equals("test4"));
   }

   @Test
   public void test_set_background2()
   {
      WorldObject b = new Background("test5");
      WorldObject b2 = new Background("test6");
      WorldModel w = new WorldModel(3, 4, b);
      Point p = new Point(15, 20);
      
      w.set_background(p, b2);
      assertEquals(w.get_background(p), null);
   }
   
   @Test
   public void test_within_bounds()
   {
      WorldObject b = new Background("test1");
      WorldModel w = new WorldModel(10, 22, b);
      Point p = new Point(2, 4);

      assertTrue(w.within_bounds(p));
   }

   @Test
   public void test_within_bounds2()
   {
      WorldObject b = new Background("test2");
      WorldModel w = new WorldModel(4, 10, b);
      Point p = new Point(14, 29);

      assertFalse(w.within_bounds(p));
   }

   @Test
   public void test_occupied()
   {
      WorldObject b = new Background("test");
      WorldObject v = new Vein("test1", 4, new Point(2, 1), 1);
      WorldModel w = new WorldModel(12, 4, b);
      Point p = new Point(2, 1);

      w.add_entity(v);
      assertTrue(w.is_occupied(p));
   }

   @Test
   public void test_occupied2()
   {
      WorldObject b = new Background("test");
      WorldObject v = new Vein("test2", 51, new Point(4, 2), 1);
      WorldObject v2 = new Vein("test3", 44, new Point(12, 3), 1);
      WorldModel w = new WorldModel(3, 4, b);
      Point p = new Point(5, 19);
      Point p2 = new Point(12, 3);

      w.add_entity(v);
      w.add_entity(v2);
      assertFalse(w.is_occupied(p));
      assertFalse(w.is_occupied(p2));
   }

   
   @Test
   public void test_tile_occupant()
   {
      WorldObject b = new Background("test");
      WorldObject v = new Vein("test1", 32, new Point(3, 2), 1);
      WorldModel w = new WorldModel(10, 10, b);
      Point p = new Point(3, 2);

      w.add_entity(v);
      w.move_entity(v, p);
      WorldObject b2 = w.get_tile_occupant(p);
      assertTrue(b2 instanceof Vein);
   }

   @Test
   public void test_tile_occupant2()
   {
      WorldObject b = new Background("test");
      WorldObject v = new Vein("test2", 10, new Point(32, 40), 1);
      WorldModel w = new WorldModel(5, 5, b);
      Point p = new Point(32, 40);

      w.set_background(p, v);
      WorldObject b2 = w.get_tile_occupant(p);
      assertEquals(b2, null);
   }
   
   @Test
   public void test_get_entities()
   {
      WorldObject b = new Background("test");
      WorldObject v = new Vein("test3", 12, new Point(1, 2), 1);
      WorldObject v2 = new Vein("test2", 44, new Point(0, 2), 1);
      WorldModel w = new WorldModel(6, 3, b);

      w.add_entity(v);
      w.add_entity(v2);
      List<WorldObject> e = w.get_entities();
      assertEquals(e.size(), 2, DELTA);
      assertTrue(e.get(0).get_name().equals("test3"));
      assertTrue(e.get(1).get_name().equals("test2"));
   }

   @Test
   public void test_get_entities2()
   {
      WorldObject b = new Background("test");
      WorldObject v = new Vein("test2", 10, new Point(4, 2), 1);
      WorldModel w = new WorldModel(20, 4, b);

      w.add_entity(v);
      List<WorldObject> e = w.get_entities();
      assertEquals(e.size(), 0, DELTA);
   }

   
   @Test
   public void test_add_entity()
   {
      WorldObject b = new Background("test");
      WorldObject v = new Vein("test1", 24, new Point(1, 1), 1);
      WorldModel w = new WorldModel(4, 4, b);

      w.add_entity(v);
      WorldObject occ = w.get_tile_occupant(new Point(1, 1));
      assertTrue(occ instanceof Vein);
      assertTrue(occ.get_name().equals("test1"));
   } 

   @Test
   public void test_move()
   {
      WorldObject b = new Background("test2");
      WorldObject v = new Vein("test", 12, new Point(4, 3), 1);
      WorldModel w = new WorldModel(15, 10, b);

      w.add_entity(v);
      List<Point> t = w.move_entity(v, new Point(1, 1));
      assertTrue(w.is_occupied(new Point(1, 1)));
      assertFalse(w.is_occupied(new Point(4, 3)));

      assertEquals(t.get(0).xCoordinate(), 4);
      assertEquals(t.get(0).yCoordinate(), 3);
      assertEquals(t.get(1).xCoordinate(), 1);
      assertEquals(t.get(1).yCoordinate(), 1);
      assertTrue(w.get_tile_occupant(new Point(1, 1)) instanceof Vein);
   }

   @Test
   public void test_move2()
   {
     WorldObject b = new Background("test");
     WorldObject v = new Vein("test2", 124, new Point(2, 2), 1);
     WorldModel w = new WorldModel(12, 12, b);

     w.add_entity(v);
     List<Point> t = w.move_entity(v, new Point(20, 20));
     assertEquals(t, new LinkedList<Point>());
   }

   @Test
   public void test_remove()
   {
      WorldObject b = new Background("test");
      WorldObject v = new Vein("test2", 4, new Point(2, 3), 1);
      WorldModel w = new WorldModel(10, 20, b);

      w.add_entity(v);
      assertTrue(w.get_tile_occupant(new Point(2, 3)) instanceof Vein);
      assertTrue(w.is_occupied(new Point(2, 3)));

      w.remove_entity(v);
      assertFalse(w.get_tile_occupant(new Point(2, 3)) instanceof Vein);
      assertFalse(w.is_occupied(new Point(2, 3)));
   }
   
   @Test
   public void test_remove_at()
   {
      WorldObject b = new Background("test");
      WorldObject v = new Vein("test2", 5, new Point(3, 3), 1);
      WorldModel w = new WorldModel(22, 12, b);

      w.add_entity(v);
      assertTrue(w.get_tile_occupant(new Point(3, 3)) instanceof Vein);
      assertTrue(w.is_occupied(new Point(3, 3)));

      w.remove_entity_at(new Point(3, 3));
      assertFalse(w.get_tile_occupant(new Point(3, 3)) instanceof Vein);
      assertFalse(w.is_occupied(new Point(3, 3)));
   }

   @Test
   public void test_remove_at2()
   {
      WorldObject b = new Background("test");
      WorldObject v = new Vein("test3", 10, new Point(5, 5), 1);
      WorldModel w = new WorldModel(3, 3, b);

      w.add_entity(v);
      assertFalse(w.get_tile_occupant(new Point(5, 5)) instanceof Vein);
      assertEquals(w.get_tile_occupant(new Point(5, 5)), null);

      w.remove_entity_at(new Point(5, 5));
      assertFalse(w.get_tile_occupant(new Point(5, 5)) instanceof Vein);
      assertEquals(w.get_tile_occupant(new Point(5, 5)), null);
   }

   @Test
   public void test_find_nearest()
   {
      WorldObject b = new Background("test");
      WorldModel w = new WorldModel(35, 32, b);

      WorldObject v = new Vein("test1", 23, new Point(3, 14), 1);
      WorldObject v2 = new Vein("test2", 10, new Point(7, 7), 1);
      WorldObject v3 = new Vein("test3", 15, new Point(20, 10), 1);
      WorldObject o = new Ore("test4", new Point(20, 11), 5000);

      w.add_entity(v);
      w.add_entity(v2);
      w.add_entity(v3);
      w.add_entity(o);

      WorldObject nearest = w.find_nearest(new Point(21, 12), Vein.class);
      assertTrue(nearest.get_name().equals("test3"));
      assertTrue(nearest instanceof Vein);
      assertEquals(nearest.get_position().xCoordinate(), 20, DELTA);
      assertEquals(nearest.get_position().yCoordinate(), 10, DELTA);
   }

   /*
   @Test
   public void test_nearest_entity()
   {
      WorldObject b = new Background("test");
      WorldModel w = new WorldModel(4, 4, b);

      List<WorldObject> e = new LinkedList<WorldObject>();
      WorldObject v = new Vein("test1", 44, new Point(1, 1), 1);
      WorldObject v2 = new Vein("test2", 10, new Point(3, 3), 1);
      WorldObject v3 = new Vein("test3", 12, new Point(0, 0), 1);
      e.add(v);
      e.add(v2);
      e.add(v3);

      List<Integer> d = new LinkedList<Integer>();
      d.add(73);
      d.add(122);
      d.add(50);

      assertEquals(w.nearest_entity(e, d), e.get(2));
   }
   */
}
