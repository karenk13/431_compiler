package arm;


public class BinaryARM implements ARM {
     public Operation op;
     public String dest;
     public String reg;
     public String operand2;

     public BinaryARM(String op, String dest, String reg, String operand2) {
          this.op = Operation.valueOf(op);
          this.dest = dest;
          this.reg = reg;
          this.operand2 = operand2;
     }

     public enum Operation {
         ADD, SUB, MUL, AND, ORR, EOR
     }

     public void printOut() {
         System.out.println( "\t" + op + "\t" + dest + "," + reg + "," + operand2);
     }
}
