package arm;

public class LabelARM implements ARM {
     public String label;

     public LabelARM(String label) {
         this.label = label;
     }

     public void printOut() {
         System.out.println("." + label + ":");
     }
}

