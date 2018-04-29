package llvm;

import java.util.List;
import java.util.ArrayList;
import arm.*;

public class ReturnLLVM implements LLVM {
    
    public String value;
    public String type;
    public List<ARM> arms;

    public ReturnLLVM (String value, String type) {
         this.value = value;
         this.type = type;
         this.arms = new ArrayList<ARM>();
	 arms.add(new MovesARM("MOV", "%r0", value));
         List<String> pop = new ArrayList<String>();
         pop.add("fp");
         pop.add("pc");
         arms.add(new PushPopARM("POP", pop));
    }

    public void printOut() {
         System.out.println("\tret " + type + " " + value);   
    }
    public void printOutARM() {
         for (int i = 0; i < arms.size(); i++) {
              arms.get(i).printOut();
         }
    }
    public String getResultReg() { return "";}
    public String getResultType() {return type;}

    public void addARM( ARM arm ) {
         this.arms.add(arm);
    }
    public void addARMList(List<ARM> arms ) {
         this.arms.addAll(arms);
    }

}

