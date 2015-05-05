public class MinerFull
   extends Miner
{
   public MinerFull(String name, int resource_limit, Point position, 
      int rate, int animation_rate)
   {
      super(name, resource_limit, position, rate, animation_rate);
   }

   
   protected Class to_entity()
   {
      return Blacksmith.class;
   }


   protected boolean miner_to(WorldModel world, Individual smith)
   {
      smith.set_resource_count(smith.get_resource_count()
         + this.get_resource_count());
      this.set_resource_count(0);
      return true;
   }


   protected boolean miner_to(WorldModel world, StaticEntity ore)
   {
      return false;
   }

   
   protected Miner try_transform_miner_status()
   {
      MinerNotFull new_entity = new MinerNotFull(this.get_name(), 
         this.get_resource_limit(), this.get_position(), this.get_rate(),
         this.get_animation_rate());

      return new_entity;
   }
}

//miner_to
