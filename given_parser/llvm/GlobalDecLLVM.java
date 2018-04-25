package llvm;

public class GlobalDecLLVM implements LLVM {
    
    public String name;
    public String scope;
    public String space;
    public String type;
    public String body;
    public int num;

    public GlobalDecLLVM (String name, String scope, String space, String type, String body, int num) {
          this.name = name;
          this.scope = scope;
          this.space = space;
          this.type = type;
          this.body = body;
          this.num = num;
    }

    public void printOut() {
         System.out.println("@" + name + " = " + scope + " " + space + " " + type + " " + body + ", align " + num);
    }

    public String getResultReg() { return "";}
    public String getResultType() {return "";}

}

