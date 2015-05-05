public class OreBlob
   extends MovingEntity
{
   public OreBlob(String name, Point position, int rate, 
      int animation_rate)
   {
      super(name, position, rate, animation_rate);
   }

   //next_position


   protected int get_resource_count()
   {
      return -1;
   }

   protected void set_resource_count(int n)
   {
   }

   protected int get_resource_limit()
   {
      return -1;
   }

   protected int get_resource_distance()
   {
      return -1;
   }

   /*
   private blob_to_vein(WorldModel world, WorldObject vein)
   {
      Point entity_pt = this.get_position();
      if (!vein)
      {
         return ________
      }
      Point vein_pt = vein.get_position();
      if (entity_pt.adjacent(vein_pt))
      {
         vein.remove_entity(
      }
   }
   */
}
