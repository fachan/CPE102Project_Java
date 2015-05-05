public abstract class MovingEntity
   extends Individual
{
   private int animation_rate;

   public MovingEntity(String name, Point position, int rate, 
      int animation_rate)
   {
      super(name, position, rate);
      this.animation_rate = animation_rate;
   }

   protected int get_animation_rate()
   {
      return this.animation_rate;
   }

   /* next_position */

   protected abstract int get_resource_limit();
   protected abstract void set_resource_count(int n);
   protected abstract int get_resource_count();
}
