package llvm;

import java.util.List;
import java.util.ArrayList;
import arm.*;

public class MiscLLVM implements LLVM {
    
    public String result;
    public String type;
    public String value;
    public String type2;
    public Operation op;
    public List<ARM> arms;

    public MiscLLVM (String result, String type, String value, String type2, String op) {
         this.result = result;
         this.type = type;
         this.value = value;
         this.type2 = type2;
         this.op = Operation.valueOf(op);
         this.arms = new ArrayList<ARM>();

         if (this.op == Operation.BITCAST) {
              arms.add(new MovesARM("MOV", result, value));
         } else if (this.op == Operation.TRUNC) {
              // does nothing
         } else if (this.op == Operation.ZEXT) {
              // does nothing
         }
    }

    enum Operation {
          BITCAST, TRUNC, ZEXT
    }

    public void printOut() {
         System.out.println("\t" + result + " = " + op + " " + type + " " + value + " to " + type2 );
    }
    public void printOutARM() {
         for (int i = 0; i < arms.size(); i++) {
              arms.get(i).printOut();
         }
    }

    public String getResultReg() { return result;}
    public String getResultType() {return type2;}

    public void addARM( ARM arm ) {
         this.arms.add(arm);
    }
    public void addARMList(List<ARM> arms ) {
         this.arms.addAll(arms);
    }

}

