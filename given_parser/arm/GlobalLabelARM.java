package arm;

public class GlobalLabelARM implements ARM {
     public String name;

     public GlobalLabelARM(String name) {
         this.name = name;
     }

     public void printOut() {
         System.out.println("\t.global " + name);
     }
}

