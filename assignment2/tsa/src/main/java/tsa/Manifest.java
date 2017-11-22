package tsa;

import java.util.ArrayList;

public class Manifest
{
   private ArrayList<Passenger> manifest;

   Manifest(Integer numPassengers) {
      System.out.println("I am a manifest with " + numPassengers + "ppl.");
      manifest = new ArrayList<Passenger>();
      for (Integer i = 0; i < numPassengers; i++)
         manifest.add(new Passenger(i));
   }

   public void printManifest() {
      for (Passenger p: manifest) {
         p.showId();
      }
   }
}
