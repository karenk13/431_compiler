package llvm;

public class StoreLLVM implements LLVM {
    
    public String value;
    public String type1;
    public String pointer;
    public String type2;

    public StoreLLVM(String value, String type1, String pointer, String type2) {
          this.value = value;
          this.type1 = type1;
          this.pointer = pointer;
          this.type2 = type2;
    }

    public void printOut() {
         System.out.println("\tstore " + type1 + " " + value + ", " + type2 + "* " + pointer);
    }

    public String getResultReg() { return pointer;}
    public String getResultType() {return type1;}


}

