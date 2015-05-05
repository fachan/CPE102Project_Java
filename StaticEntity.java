public abstract class StaticEntity
   extends Entity
{
   public StaticEntity(String name, Point position)
   {
      super(name, position);
   }

   protected abstract int get_rate();
   protected abstract int get_animation_rate();
   protected abstract int get_resource_distance();
   private abstract Point find_open_around();
}
