package llvm;

import java.util.List;
import java.util.ArrayList;
import arm.*;

public class BranchLLVM implements LLVM {
    
    public String cond;
    public String trueLabel;
    public String falseLabel;
    public List<ARM> arms;

    public BranchLLVM (String cond, String trueLabel, String falseLabel) {
         this.cond = cond;
         this.trueLabel = trueLabel;
         this.falseLabel = falseLabel;
         this.arms = new ArrayList<ARM>();

         arms.add(new ComparisonARM(cond, "#1"));
         arms.add(new BranchARM( "BEQ", "." + trueLabel));
         arms.add(new BranchARM( "B", "." + falseLabel));
    }

    public void printOut() {
         System.out.println( "\tbr i1 " + cond + ", label " + trueLabel + ", label " + falseLabel );
    }
    public void printOutARM() {
         for (int i = 0; i < arms.size(); i++) {
              arms.get(i).printOut();
         }
    }
    public String getResultReg() { return "";}
    public String getResultType() {return "";}

    public void addARM( ARM arm ) {
         this.arms.add(arm);
    }
    public void addARMList(List<ARM> arms ) {
         this.arms.addAll(arms);
    }

}

