package llvm;


public class BinaryLLVM implements LLVM {
    
    public String result;
    public Operation op;
    public String type;
    public String op1;
    public String op2;

    public BinaryLLVM (String result, String op, String type, String op1, String op2) {
          this.result = result;
          this.type = type;
          this.op1 = op1;
          this.op2 = op2;
          this.op = Operation.valueOf(op);
    }

    enum Operation {
          ADD, MUL, SDIV, SUB, AND, OR, XOR;
    }

    public void printOut() {
         System.out.println(result + " = " + op + " " + type + " " + op1 + ", " + op2 );
    }

    public String getResultReg() { return result;}
    public String getResultType() {return type;}

}
