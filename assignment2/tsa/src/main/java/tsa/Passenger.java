package tsa;


public class Passenger
{
   private Integer id;

   Passenger(Integer id) {
      this.id = id;
   }

   public void showId() {
      System.out.println("Passenger ID: " + id);
   }
}
