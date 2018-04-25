package llvm;

import java.util.List;

public class DeclareFuncLLVM implements LLVM {
    
    public String name;
    public String retType;
    public List<String> argTypes;

    public DeclareFuncLLVM (String name, String retType, List<String> argTypes) {
          this.name = name;
          this.retType = retType;
          this.argTypes = argTypes;
    }

    public void printOut() {
         System.out.print("declare " + retType + " @" + name + "("); 

         for (int i = 0; i < argTypes.size(); i++) {
             System.out.print(argTypes.get(i));
             if (i != argTypes.size() -1) {
                 System.out.print(", ");
             }
         }

         System.out.print(")\n");

    }

    public String getResultReg() { return "";}
    public String getResultType() {return retType;}

}
