public class Obstacle
   extends WorldObject
{
   private Point position;

   public Obstacle(String name, Point position)
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
}
