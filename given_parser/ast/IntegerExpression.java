package ast;

import java.util.List;
import java.util.ArrayList;
import cfg.*;
import llvm.*;

public class IntegerExpression
   extends AbstractExpression
{
   private final String value;

   public IntegerExpression(int lineNum, String value)
   {
      super(lineNum);
      this.value = value;
   }

   public Type getType(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
      return new IntType();
   }



   public void typeOpCheck(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
   }
   
   public void cfg(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
   	System.out.println("integer expression: " + value);
   }
   
   public String typeToLLVM(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
       return "i32";
   }

   public List<LLVM> toLLVM(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc, CFGNode startNode, CFGNode exitNode) {
       
//       LLVM inst = new LoadLLVM("%u" + exitNode.regNum, "i32", value);
 //      exitNode.incrementReg();       

       LLVM inst = new NOPLLVM(value, "i32");
       List<LLVM> list = new ArrayList<LLVM>();
       list.add(inst);
       return list;     
   }
}
