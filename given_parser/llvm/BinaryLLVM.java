package llvm;

import java.util.List;
import java.util.ArrayList;
import arm.*;

public class BinaryLLVM implements LLVM {
    
    public String result;
    public Operation op;
    public String type;
    public String op1;
    public String op2;
    public List<ARM> arms;

    public BinaryLLVM (String result, String op, String type, String op1, String op2) {
          this.result = result;
          this.type = type;
          this.op1 = op1;
          this.op2 = op2;
          this.op = Operation.valueOf(op);
          this.arms = new ArrayList<ARM>();
 
          String opARM = op;
          if (this.op == Operation.OR) {
              opARM = "ORR";
          } else if (this.op == Operation.XOR) {
              opARM = "EOR";
          }
 
          if(op2.charAt(0) == '%') {
		// add register
		if(this.op != Operation.SDIV) {
			arms.add(new BinaryARM(op, result, op1, op2));
		}
          	else {
			// division by hand
			// TODO: change pr save r0 and r1 before calling
			arms.add(new MovesARM("MOV", "%r0", op1));
			arms.add(new MovesARM("MOV", "%r1", op2));
                        arms.add(new BranchARM("BL", "__aeabi_idiv"));
                        arms.add(new MovesARM("MOV", result, "%r0"));
		}
	  }
	  else {
		// add register + immediate
		if(this.op != Operation.SDIV) {
	        	if(Integer.parseInt(op2) < 10000) {	
				arms.add(new BinaryARM(op, result, op1, op2));
			}
			else {
				// overflow
				arms.add(new MovesARM("MOVW", "%t9", "#:lower16:" + op2));
				arms.add(new MovesARM("MOVT", "%t9", "#:upper16:" + op2));
				arms.add(new BinaryARM(op, result, op1, "%t9"));
			}
                }
          	else {
			// division by hand
			// TODO: change pr save r0 and r1 before calling, and maybe check op2 for overflow
			arms.add(new MovesARM("MOV", "%r0", op1));
	        	
                        if(Integer.parseInt(op2) < 10000) {	
				arms.add(new MovesARM("MOV", "%r1", op2));
                        	arms.add(new BranchARM("BL", "__aeabi_idiv"));
                        	arms.add(new MovesARM("MOV", result, "%r0"));
			}
			else {
				arms.add(new MovesARM("MOVW", "%t9", "#:lower16:" + op2));
				arms.add(new MovesARM("MOVT", "%t9", "#:upper16:" + op2));
			
   				arms.add(new MovesARM("MOV", "%r1", "%t9"));
                        	arms.add(new BranchARM("BL", "__aeabi_idiv"));
                        	arms.add(new MovesARM("MOV", result, "%r0"));
                        }
		}
	  }
    }

    enum Operation {
          ADD, MUL, SDIV, SUB, AND, OR, XOR;
    }

    public void printOut() {
         System.out.println("\t" + result + " = " + op + " " + type + " " + op1 + ", " + op2 );
    }
    public void printOutARM() {
         for (int i = 0; i < arms.size(); i++) {
              arms.get(i).printOut();
         }
    }

    public String getResultReg() { return result;}
    public String getResultType() {return type;}

    public void addARM( ARM arm ) {
         this.arms.add(arm);
    }
    public void addARMList(List<ARM> arms ) {
         this.arms.addAll(arms);
    }

}
