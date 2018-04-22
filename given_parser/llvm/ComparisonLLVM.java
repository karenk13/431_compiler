package llvm;

public class ComparisonLLVM implements LLVM {
    
    public String result;
    public String cond;
    public String type;
    public String op1;
    public String op2;

    public ComparisonLLVM (String result, String cond, String type, String op1, String op2) {
          this.result = result;
          this.cond = cond;
          this.type = type;
          this.op1 = op1;
          this.op2 = op2;
    }

    public void printOut() {
         System.out.println(result + " = icmp " + cond + " " + type + " " + op1 + ", " + op2 );
    }

    public String getResultReg() { return result;}
    public String getResultType() {return type;}

}
