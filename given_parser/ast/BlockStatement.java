package ast;

import java.util.List;
import java.util.ArrayList;
import cfg.*;
import llvm.*;


public class BlockStatement
   extends AbstractStatement
{
   private final List<Statement> statements;

   public BlockStatement(int lineNum, List<Statement> statements)
   {
      super(lineNum);
      this.statements = statements;
   }

   public static BlockStatement emptyBlock()
   {
      return new BlockStatement(-1, new ArrayList<>());
   }

   public void typeOpCheck(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
      for (int i = 0; i < statements.size(); i++ ) {
          statements.get(i).typeOpCheck(types, decls, func, curFunc);
      }
   }


   public void typeCheck(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
    // System.out.println("TYPE CHECKING: BLOCK STATEMENT");
      for (int i = 0; i < statements.size(); i++ ) {
          statements.get(i).typeCheck(types, decls, func, curFunc);
      }
   }

   public boolean checkReturn() {
	for (int i = 0; i < statements.size(); i++ ) {
	     if ( statements.get(i).checkReturn()) {
		return true;
	     }
        }
	return false;
   }

   public CFGNode cfg(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc, CFGNode startNode, CFGNode exitNode) {
      //System.out.println("Block: " + startNode.count);
      CFGNode temp = null;      
      CFGNode next = new CFGNode("block: " + startNode.name, exitNode.blockNum );
      exitNode.incrementBlock();
      startNode.addChild(next);
      next.addParent(startNode);
      for (int i = 0; i < statements.size(); i++ ) {
          temp = statements.get(i).cfg(types, decls, func, curFunc, next, exitNode);
          next = temp;
      }
      return next;
   }

   public String typeToLLVM(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
       return "";
   }


   public List<LLVM> toLLVM(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
       return new ArrayList<LLVM>();     
   }

}
