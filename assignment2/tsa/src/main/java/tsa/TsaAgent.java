package tsa;

public class TsaAgent implements Runnable
{
   private String name;

   TsaAgent(String alias) {
      name = alias;
   }

   public void run() {
      System.out.println(name + " is running!");
   }
}
