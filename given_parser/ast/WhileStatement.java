package ast;

import java.util.List;
import java.util.ArrayList;
import cfg.*;
import llvm.*;


public class WhileStatement
   extends AbstractStatement
{
   private final Expression guard;
   private final Statement body;

   public WhileStatement(int lineNum, Expression guard, Statement body)
   {
      super(lineNum);
      this.guard = guard;
      this.body = body;
   }

   public void typeOpCheck(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
      guard.typeOpCheck(types, decls, func, curFunc);
      body.typeOpCheck(types, decls, func, curFunc);
   }

   public void typeCheck(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
      //System.out.println("TYPECHECK: While");
   }

   public boolean checkReturn() {
        return false;
   }

   public CFGNode cfg(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc, CFGNode startNode, CFGNode exitNode) {
 //     System.out.println("While: " + startNode.count); 
      
      //guard.cfg(types, decls, func, curFunc);
      //startNode.addExpression(guard);
      CFGNode guardNode = new CFGNode("whileguard: " + startNode.name, exitNode.blockNum );
      exitNode.incrementBlock();
      guardNode.addGuard(guard);
      guardNode.addLLVMList(guard.toLLVM(types, decls, func, curFunc, startNode, exitNode));  
    
      guardNode.addParent(startNode);
      startNode.addChild(guardNode); 

      // two more nodes end node and the body
      CFGNode bodyNode = new CFGNode("whileBody: " + startNode.name, exitNode.blockNum);
      exitNode.incrementBlock();
      guardNode.addChild(bodyNode);
      bodyNode.addParent(guardNode);
      
      bodyNode = body.cfg(types, decls, func, curFunc, bodyNode, exitNode);
      bodyNode.addChild(guardNode);
      guardNode.addParent(bodyNode);

      CFGNode endNode = new CFGNode("whileEnd: " + startNode.name, exitNode.blockNum);
      exitNode.incrementBlock();
      endNode.addParent(guardNode);
      guardNode.addChild(endNode);   

      return endNode;
  }


   public String typeToLLVM(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
       return "";
   }


   public List<LLVM> toLLVM(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
       return new ArrayList<LLVM>();     
   }

}
