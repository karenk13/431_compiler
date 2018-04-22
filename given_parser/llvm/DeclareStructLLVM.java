package llvm;

import java.util.List;

public class DeclareStructLLVM implements LLVM {
    
    public String name;
    public List<String> argTypes;

    public DeclareStructLLVM (String name, List<String> argTypes) {
          this.name = name;
          this.argTypes = argTypes;
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

    public String getResultReg() { return "";}
    public String getResultType() {return "";}

}

