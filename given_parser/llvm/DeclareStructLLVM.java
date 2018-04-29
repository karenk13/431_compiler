package llvm;

import java.util.List;
import java.util.ArrayList;
import arm.*;

public class DeclareStructLLVM implements LLVM {
    
    public String name;
    public List<String> argTypes;
    public List<ARM> arms;

    public DeclareStructLLVM (String name, List<String> argTypes) {
         this.name = name;
         this.argTypes = argTypes;
         this.arms = new ArrayList<ARM>();
    }

    public void printOut() {
         System.out.print("type %struct." + name + " = {"); 

         for (int i = 0; i < argTypes.size(); i++) {
             System.out.print(argTypes.get(i));
             if (i != argTypes.size() -1) {
                 System.out.print(", ");
             }
         }

         System.out.print("};\n");

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

