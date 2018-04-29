package arm;


public class MovesARM implements ARM {
     public String reg;
     public String operand2;
     public Moves m;

     public MovesARM(String moves, String reg, String operand2) {
         this.reg = reg;
         this.operand2 = operand2;
         this.m = Moves.valueOf(moves);
     }

     public enum Moves {
         MOV, MOVW, MOVT, MOVEQ, MOVLT, MOVNE, MOVGE
     }

     public void printOut() {
         System.out.println( "\t" + m + "\t" + reg + "," + operand2);
     }
}

