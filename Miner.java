public abstract class Miner
   extends MovingEntity
{
   private int resource_limit;
   private int resource_count;

   public Miner(String name, int resource_limit, Point position, 
      int rate, int animation_rate)
   {
      super(name, position, rate, animation_rate);
      this.resource_limit = resource_limit;

      if (this instanceof MinerFull)
      { 
         this.resource_count = resource_limit;
      }
 
      else
      {
         this.resource_count = 0;
      }
   }

   protected int get_resource_limit()
   {
      return this.resource_limit;
   }

   protected void set_resource_count(int n)
   {
      this.resource_count = n;
   }

   protected int get_resource_count()
   {
      return this.resource_count;
   }

   protected int get_resource_distance()
   {
      return -1;
   }


   /*
   private miner_to_entity(WorldModel world, WorldObject entity)
   {
      Point entity_pt = this.get_position();

      if (!entity)
      {
         return ____
      }

      Point to_pt = entity.get_position();

      if (entity_pt.adjacent(to_pt))
      {
         return this.miner_to(world, entity);
      }

      else
      {
         Point new_pt = this.next_position(
      }
   }
   */


   protected abstract Class to_entity();
   protected abstract Miner try_transform_miner_status(); 
   protected abstract boolean miner_to(WorldModel w, StaticEntity ore);
   protected abstract boolean miner_to(WorldModel w, Individual smith);
}
