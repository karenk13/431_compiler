package llvm;

import java.util.List;

public class DeclareFuncLLVM implements LLVM {
    
    public String name;
    public String retType;
    public List<String> argTypes;
    public List<String> argNames;

    public DeclareFuncLLVM (String name, String retType, List<String> argTypes, List<String> argNames) {
          this.name = name;
          this.retType = retType;
          this.argTypes = argTypes;
          this.argNames = argNames;
    }

    public void printOut() {
         System.out.print("define " + retType + " @" + name + "("); 

         for (int i = 0; i < argTypes.size(); i++) {
             System.out.print(argTypes.get(i) + " " + argNames.get(i));
             if (i != argTypes.size() -1) {
                 System.out.print(", ");
             }
         }

         System.out.print(")\n");

    }

    public String getResultReg() { return "";}
    public String getResultType() {return retType;}

}
