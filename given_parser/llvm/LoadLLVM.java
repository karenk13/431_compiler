package llvm;

public class LoadLLVM implements LLVM {
    
    public String result;
    public String type;
    public String pointer;

    public LoadLLVM (String result, String type, String pointer) {
          this.result = result;
          this.type = type;
          this.pointer = pointer;
    }

    public void printOut() {
         System.out.println("\t" + result + " = load " + type + "* " + pointer );
    }

    public String getResultReg() { return result;}
    public String getResultType() {return type;}

}

