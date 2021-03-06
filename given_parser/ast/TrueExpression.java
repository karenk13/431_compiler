package ast;

import java.util.List;
import java.util.ArrayList;
import cfg.*;
import llvm.*;

public class TrueExpression
   extends AbstractExpression
{
   public TrueExpression(int lineNum)
   {
      super(lineNum);
   }

   public Type getType(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc){
      return new BoolType();
   }

   public void typeOpCheck(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
   }

   public void cfg(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
   	System.out.println("true expression");
   }

   public String typeToLLVM(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
       return "i1";
   }

   public List<LLVM> toLLVM(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc, CFGNode startNode, CFGNode exitNode) {
       LLVM inst = new LoadLLVM("%u" + exitNode.regNum, "i1", "1");
       exitNode.incrementReg();       
       List<LLVM> list = new ArrayList<LLVM>();
       list.add(inst);
       return list;    
   }
}
