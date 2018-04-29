package llvm;

import java.util.List;
import java.util.ArrayList;
import arm.*;

public class GetElementPtrLLVM implements LLVM {
    
    public String result;
    public String type;
    public String ptrval;
    public String index;
    public List<ARM> arms;

    public GetElementPtrLLVM (String result, String type, String ptrval, String index) {
         this.result = result;
         this.type = type;
         this.ptrval = ptrval;
         this.index = index;
         this.arms = new ArrayList<ARM> ();

         int i = Integer.parseInt(index);
         arms.add(new BinaryARM("ADD", result, ptrval, "#" + i*4 ));
    }

    public void printOut() {
         System.out.println("\t" + result + " = getelementptr " + type + "* " + ptrval + ", i1 0, i32 " + index );
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

