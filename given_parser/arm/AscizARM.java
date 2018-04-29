package arm;

public class AscizARM implements ARM {
     public String body;

     public AscizARM(String body) {
         this.body = body;
     }

     public void printOut() {
         System.out.println("\t.asciz  " + body);
     }
}


