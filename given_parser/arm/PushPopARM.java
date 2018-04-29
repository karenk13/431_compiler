package arm;

import java.util.List;

public class PushPopARM implements ARM {
     public Operation op;
     public List<String> listRegs;

     public PushPopARM(String op, List<String> list) {
         this.op = Operation.valueOf(op);
         this.listRegs = list;
     }

     public enum Operation {
         PUSH, POP
     }

     public void printOut() {
         System.out.print( "\t" + op + "\t{");
         for (int i = 0; i < listRegs.size(); i++) {
             System.out.print(listRegs.get(i));
             if (i != listRegs.size() - 1) {
                 System.out.print(",");
             }
         } 
         System.out.println("}");
     }
}

