package llvm;

public class GetElementPtrLLVM implements LLVM {
    
    public String result;
    public String type;
    public String ptrval;
    public String index;

    public GetElementPtrLLVM (String result, String type, String ptrval, String index) {
          this.result = result;
          this.type = type;
          this.ptrval = ptrval;
          this.index = index;
    }

    public void printOut() {
         System.out.println("\t" + result + " = getelementptr " + type + "* " + ptrval + ", i1 0, i32 " + index );
    }
    public String getResultReg() { return result;}
    public String getResultType() {return type;}

}

