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
       CFGNode ret = new CFGNode(startNode.name , exitNode.blockNum);
       exitNode.incrementBlock();

       startNode.addChild(ret);
       ret.addParent(startNode);

       ret.addChild(exitNode);
       exitNode.addParent(ret);

       ret.addLLVM(new ReturnEmptyLLVM());

       return ret;
   }


   public String typeToLLVM(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
       return "";
   }


   public List<LLVM> toLLVM(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
       return new ArrayList<LLVM>();     
   }

}
