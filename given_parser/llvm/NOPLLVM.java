package llvm;


public class NOPLLVM implements LLVM {
    
    public String result;
    public String type;

    public NOPLLVM (String result, String type) {
          this.result = result;
          this.type = type;
    }

    public void printOut() {
    }

    public String getResultReg() { return result;}
    public String getResultType() {return type;}

}

