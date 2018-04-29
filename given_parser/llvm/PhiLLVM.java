package llvm;

import java.util.List;
import java.util.ArrayList;
import arm.*;


public class PhiLLVM implements LLVM {
    
    public String result;
    public String type;
    public List<String> values;
    public List<String> labels;
    public List<ARM> arms;

    public PhiLLVM (String result, String type, List<String> values, List<String> labels) {
         this.result = result;
         this.type = type;
         this.values = values;
         this.labels = labels;
         this.arms = new ArrayList<ARM>();

         
    }

    public void printOut() {
         System.out.print("\t" + result + " = phi " + type + " " );
         
         for (int i = 0; i < values.size(); i++) {
             System.out.print("[" + values.get(i) + ", " + labels.get(i) + "]");
         }
         System.out.print("\n");
        
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

