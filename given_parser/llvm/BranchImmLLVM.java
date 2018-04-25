package llvm;

public class BranchImmLLVM implements LLVM {
    
    public String label;

    public BranchImmLLVM (String label) {
          this.label = label;
    }
    
    public void printOut() {
         System.out.println("\tbr label " + label);
    }

    public String getResultReg() { return "";}
    public String getResultType() {return "";}

}

