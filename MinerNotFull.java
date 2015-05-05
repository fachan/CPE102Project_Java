public class MinerNotFull
   extends Miner
{
   public MinerNotFull(String name, int resource_limit, Point position,
      int rate, int animation_rate)
   {
      super(name, resource_limit, position, rate, animation_rate);
   }

      
   protected Class to_entity()
   {
      return Ore.class;
   }


   protected boolean miner_to(WorldModel world, StaticEntity ore)
   {
      return false;
   }

   protected boolean miner_to(WorldModel world, Individual smith)
   {
      return false;
   }
   
   /*
   protected boolean miner_to(WorldModel world, WorldObject ore)
   {
      Point ore_pt = ore.get_position();
      this.set_resource_count(1 + this.get_resource_count());
      ore.remove_entity(world);
      return true;
   }
   */

   protected Miner try_transform_miner_status()
   {
      if (this.get_resource_count() < this.get_resource_limit())
      {
         return this;
      }
      
      else
      {
         MinerFull new_entity = new MinerFull(this.get_name(), 
            this.get_resource_limit(), this.get_position(),
            this.get_rate(), this.get_animation_rate());

         return new_entity;
      }
   }   
}

//miner_to
