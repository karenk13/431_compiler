package llvm;

import java.util.List;
import java.util.ArrayList;
import arm.*;

public class ReturnEmptyLLVM implements LLVM {

    public List<ARM> arms;

    public ReturnEmptyLLVM () {
        this.arms = new ArrayList<ARM>();

       // no stack so something will happen in future ??? push pop ???
    }

    public void printOut() {
         System.out.println("\tret void");   
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

