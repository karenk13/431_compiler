package llvm;

public class MiscLLVM implements LLVM {
    
    public String result;
    public String type;
    public String value;
    public String type2;
    public Operation op;

    public MiscLLVM (String result, String type, String value, String type2, String op) {
          this.result = result;
          this.type = type;
          this.value = value;
          this.type2 = type2;
          this.op = Operation.valueOf(op);
    }

    enum Operation {
          BITCAST, TRUNC, ZEXT
    }

    public void printOut() {
         System.out.println(result + " = " + op + " " + type + " " + value + " to " + type2 );
    }

    public String getResultReg() { return result;}
    public String getResultType() {return type2;}

}

