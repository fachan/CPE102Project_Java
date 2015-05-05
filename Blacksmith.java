public class Blacksmith
   extends Individual
{
   private int resource_limit;
   private int resource_count = 0;
   private int resource_distance = 1;

   public Blacksmith(String name, Point position, int resource_limit, 
      int rate, int resource_distance)
   {
      super(name, position, rate);
      this.resource_limit = resource_limit;
      this.resource_count = 0;
      this.resource_distance = resource_distance;
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
      return this.resource_distance;
   }
}
