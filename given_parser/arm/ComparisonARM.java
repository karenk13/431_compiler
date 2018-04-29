package arm;


public class ComparisonARM implements ARM {
     public String reg;
     public String operand2;

     public ComparisonARM(String reg, String operand2) {
          this.reg = reg;
          this.operand2 = operand2;
     }

     public void printOut() {
         System.out.println( "\tcmp\t" + reg + "," + operand2);
     }
}

