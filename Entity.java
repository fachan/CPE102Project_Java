public abstract class Entity
   extends WorldObject
{
   private Point position;

   public Entity(String name, Point position)
   {
      super(name);
      this.position = position;
   }

   public void set_position(Point point)
   {
      this.position = point;
   }

   public Point get_position()
   {
      return this.position;
   }

   protected abstract int get_rate();
}
