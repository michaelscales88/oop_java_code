package tsa;

import java.util.LinkedList;

public class PassengerQueue
{
   private LinkedList myQueue;

   PassengerQueue() {
      System.out.println("I am a queue to process passengers.");
   }

   PassengerQueue(Manifest expPassengers) {
      System.out.println("I am used to create the first queue.");
      expPassengers.printManifest();
   }
}
