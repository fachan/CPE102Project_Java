public class Ore
   extends StaticEntity
{
   private int rate = 5000;

   public Ore(String name, Point position, int rate)
   {
      super(name, position);
      this.rate = rate;
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
      return -1;
   }
}
