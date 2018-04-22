package llvm;

import java.util.List;

public class InvocationLLVM implements LLVM {
    
    public String result;
    public String type;
    public String fnptrval;
    public List<String> args;

    public InvocationLLVM (String result, String type, String fnptrval, List<String> args) {
          this.result = result;
          this.type = type;
          this.fnptrval = fnptrval;
          this.args = args;
    }

    public void printOut() {
         System.out.print( result + " = call " + type + " " + fnptrval + "(");

         for (int i = 0; i < args.size(); i++) {
             System.out.print(args.get(i));
             if (i != args.size() -1) {
                 System.out.print(", ");
             }
         }

         System.out.print(")\n");
    }

    public String getResultReg() { return result;}
    public String getResultType() {return type;}

}

