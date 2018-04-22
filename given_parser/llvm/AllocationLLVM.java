package llvm;

public class AllocationLLVM implements LLVM {
    
    public String result;
    public String type;

    public AllocationLLVM (String result, String type) {
          this.result = result;
          this.type = type;
    }

    public void printOut() {
         System.out.println(result + " = alloca " + type);
    }

    public String getResultReg() { return result;}
    public String getResultType() {return type;}

}

