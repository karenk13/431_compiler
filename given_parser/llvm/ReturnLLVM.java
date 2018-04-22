package llvm;

public class ReturnLLVM implements LLVM {
    
    public String value;
    public String type;

    public ReturnLLVM (String value, String type) {
          this.value = value;
          this.type = type;
    }

    public void printOut() {
         System.out.print("ret " + type + " " + value);   
    }
    public String getResultReg() { return "";}
    public String getResultType() {return type;}

}

