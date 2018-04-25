package llvm;

public class ReturnEmptyLLVM implements LLVM {

    public ReturnEmptyLLVM () {
    }

    public void printOut() {
         System.out.println("\tret void");   
    }
    public String getResultReg() { return "";}
    public String getResultType() {return "";}

}

