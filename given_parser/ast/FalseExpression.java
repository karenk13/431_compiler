package ast;

import java.util.List;
import llvm.*;
import java.util.ArrayList;
import cfg.*;

public class FalseExpression
   extends AbstractExpression
{
   public FalseExpression(int lineNum)
   {
      super(lineNum);
   }

   public Type getType(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
      return new BoolType();
   }

   public void typeOpCheck(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
   }

   public void cfg(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
   	System.out.println("false expression");
   }
 
   public String typeToLLVM(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
       return "i1";
   }

   public List<LLVM> toLLVM(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc, CFGNode startNode, CFGNode exitNode) {
       // mmmm
       LLVM inst = new LoadLLVM("%u" + exitNode.regNum, "i1", "0");
       exitNode.incrementReg();       
       
       List<LLVM> list = new ArrayList<LLVM>();
       list.add(inst);
       return list;    
   }
}
