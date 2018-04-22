package ast;

import java.util.List;
import java.util.ArrayList;
import cfg.*;
import llvm.*;

public class PrintLnStatement
   extends AbstractStatement
{
   private final Expression expression;

   public PrintLnStatement(int lineNum, Expression expression)
   {
      super(lineNum);
      this.expression = expression;
   }

   public void typeOpCheck(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
       //expression.typeOpCheck(types, decls, func, curFunc);
       expression.getType(types, decls, func, curFunc);
   }
   public void typeCheck(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
     // System.out.println("TYPECHECK: Print ln");
   }

   public boolean checkReturn() {
        return false;
   }

   public CFGNode cfg(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc, CFGNode startNode, CFGNode exitNode) {
       startNode.addStatement(this);
       List<LLVM> inst = expression.toLLVM(types, decls, func, curFunc, startNode, exitNode);
// add stuff to do the print of the returned register? TODO: print the newline
       String resultReg = inst.get(inst.size() -1 ).getResultReg();
       List<String> args = new ArrayList<String>();
       args.add("i8* getelementptr inbounds ([4xi8]*@.println,i32 0, i32 0)");
       args.add("i32 " + resultReg);
       LLVM call = new InvocationLLVM("%u"+ exitNode.regNum,"i32 (i8*, ... )*", "@printf", args);
       exitNode.incrementReg(); 
       inst.add(call);
       startNode.addLLVMList(inst);
      return startNode;
   }


   public String typeToLLVM(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
       return "i1";
   }


   public List<LLVM> toLLVM(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
       return new ArrayList<LLVM>();     
   }

}
