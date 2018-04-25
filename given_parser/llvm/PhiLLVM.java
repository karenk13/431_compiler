package llvm;

import java.util.List;

public class PhiLLVM implements LLVM {
    
    public String result;
    public String type;
    public List<String> values;
    public List<String> labels;

    public PhiLLVM (String result, String type, List<String> values, List<String> labels) {
          this.result = result;
          this.type = type;
          this.values = values;
          this.labels = labels;
    }

    public void printOut() {
         System.out.print("\t" + result + " = phi " + type + " " );
         
         for (int i = 0; i < values.size(); i++) {
             System.out.print("[" + values.get(i) + ", " + labels.get(i) + "]");
         }
         System.out.print("\n");
        
    }
    public String getResultReg() { return result;}
    public String getResultType() {return type;}

}

