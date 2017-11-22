package tsa;

public class TsaSimulation
{
   private PassengerQueue checkedPassengers;
   private PassengerQueue preCheck;
   private PassengerQueue nonPreCheck;
   private PassengerQueue clearedPassengers;
   private PassengerQueue boardedPassengers;

   TsaSimulation(Integer numPassengers) {
      checkedPassengers = new PassengerQueue(new Manifest(numPassengers));
      preCheck = new PassengerQueue();
      nonPreCheck = new PassengerQueue();
      new Thread(new TsaAgent("Bob")).start();
      new Thread(new TsaAgent("Ruth")).start();
   }
}
