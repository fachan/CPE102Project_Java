public class Quake
   extends StaticEntity
{
   private int animation_rate;

   public Quake(String name, Point position, int animation_rate)
   {
     super(name, position);
     this.animation_rate = animation_rate;
   }

   protected int get_animation_rate()
   {
      return this.animation_rate;
   }

   protected int get_rate()
   {
      return -1;
   }

   protected int get_resource_distance()
   {
      return -1;
   }
}
