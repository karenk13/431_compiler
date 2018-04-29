package arm;

public class AlignARM implements ARM {
     public int size;

     public AlignARM(int size) {
         this.size = size;
     }

     public void printOut() {
         System.out.println("\t.align  " + size);
     }
}

