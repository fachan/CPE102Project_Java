public abstract class WorldObject
{
   private String name;
   
   public WorldObject(String name)
   {
      this.name = name;
   }

   public String get_name()
   {
      return this.name;
   }

   public abstract void set_position(Point pt);
   public abstract Point get_position();
}
