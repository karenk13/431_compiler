package llvm;

import java.util.List;
import java.util.ArrayList;
import arm.*;


public class InvocationLLVM implements LLVM {
    
    public String result;
    public String type;
    public String fnptrval;
    public List<String> args;
    public List<ARM> arms;

    public InvocationLLVM (String result, String type, String fnptrval, List<String> args) {
         this.result = result;
         this.type = type;
         this.fnptrval = fnptrval;
         this.args = args;
         this.arms = new ArrayList<ARM>();


         // use pushpopArm for the stack
         for (int i = 0; i < args.size(); i++) {
              arms.add(new MovesARM("MOV", "%r" + i, args.get(i)));
         }
         arms.add(new BranchARM("BL", fnptrval));
         arms.add(new MovesARM("MOV", result, "%r0"));
    }

    public void printOut() {
         System.out.print("\t" + result + " = call " + type + " " + fnptrval + "(");

         for (int i = 0; i < args.size(); i++) {
             System.out.print(args.get(i));
             if (i != args.size() -1) {
                 System.out.print(", ");
             }
         }

         System.out.print(")\n");
    }
    public void printOutARM() {
         for (int i = 0; i < arms.size(); i++) {
              arms.get(i).printOut();
         }
    }

    public String getResultReg() { return result;}
    public String getResultType() {return type;}

    public void addARM( ARM arm ) {
         this.arms.add(arm);
    }
    public void addARMList(List<ARM> arms ) {
         this.arms.addAll(arms);
    }

}

