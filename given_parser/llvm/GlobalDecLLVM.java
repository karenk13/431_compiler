package llvm;

import java.util.List;
import java.util.ArrayList;
import arm.*;

public class GlobalDecLLVM implements LLVM {
    
    public String name;
    public String scope;
    public String space;
    public String type;
    public String body;
    public int num;
    public List<ARM> arms;

    public GlobalDecLLVM (String name, String scope, String space, String type, String body, int num) {
         this.name = name;
         this.scope = scope;
         this.space = space;
         this.type = type;
         this.body = body;
         this.num = num;
         this.arms = new ArrayList<ARM> ();

         arms.add(new AlignARM(2));
         arms.add(new LabelARM(name));
         arms.add(new AscizARM( body ));
    }

    public void printOut() {
         System.out.println("@" + name + " = " + scope + " " + space + " " + type + " " + body + ", align " + num);
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

