public class Vein
   extends StaticEntity
{
   private int rate;
   private int resource_distance = 1;

   public Vein(String name, int rate, Point position, int resource_distance)
   {
      super(name, position);
      this.rate = rate;
      this.resource_distance = resource_distance; 
   }

   protected int get_rate()
   {
      return this.rate;
   }

   protected int get_animation_rate()
   {
      return -1;
   }

   protected int get_resource_distance()
   {
      return this.resource_distance;
   }

   
   private Point find_open_around(WorldModel world)
   {
      for (int dy = -this.get_resource_distance(); 
         dy < this.get_resource_distance() + 1; dy++)
      {
         for (int dx = -this.get_resource_distance();
            dx < this.get_resource_distance() + 1; dx++)
         {
            Point new_pt = new Point(this.get_position().xCoordinate() + dx,
               this.get_position().yCoordinate() + dy);

            if (world.within_bounds(new_pt) && !(world.is_occupied(new_pt)))
            {
               return new_pt;
            }
         }
      }
      return null;
   }
   
}
