package ast;

import java.util.List;
import java.util.ArrayList;
import cfg.*;
import llvm.*;



public class ReturnEmptyStatement
   extends AbstractStatement
{
   public ReturnEmptyStatement(int lineNum)
   {
      super(lineNum);
   }


   public void typeOpCheck(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
   }

   public void typeCheck(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
        //System.out.println("TYPECHECK: Return empty");
   	if (!(curFunc.getReturnType() instanceof VoidType)) {
	    System.out.println("RETURN TYPE not the same");
	}
   }

   public boolean checkReturn() {
        return true;
   }

   public CFGNode cfg(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc, CFGNode startNode, CFGNode exitNode) {
       startNode.addChild(exitNode);
       exitNode.addParent(startNode);
       exitNode.addLLVM(new ReturnEmptyLLVM());
       return exitNode;
   }


   public String typeToLLVM(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
       return "";
   }


   public List<LLVM> toLLVM(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
       return new ArrayList<LLVM>();     
   }

}
