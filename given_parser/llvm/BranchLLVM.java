package llvm;

public class BranchLLVM implements LLVM {
    
    public String cond;
    public String trueLabel;
    public String falseLabel;

    public BranchLLVM (String cond, String trueLabel, String falseLabel) {
          this.cond = cond;
          this.trueLabel = trueLabel;
          this.falseLabel = falseLabel;
    }

    public void printOut() {
         System.out.println( "\tbr i1 " + cond + ", label " + trueLabel + ", label " + falseLabel );
    }
    public String getResultReg() { return "";}
    public String getResultType() {return "";}

}

