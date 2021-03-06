package ast;

import java.util.List;
import java.util.ArrayList;
import cfg.*;
import llvm.*;


public class ConditionalStatement
   extends AbstractStatement
{
   private final Expression guard;
   private final Statement thenBlock;
   private final Statement elseBlock;

   public ConditionalStatement(int lineNum, Expression guard,
      Statement thenBlock, Statement elseBlock)
   {
      super(lineNum);
      this.guard = guard;
      this.thenBlock = thenBlock;
      this.elseBlock = elseBlock;
   }


   public void typeOpCheck(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
      if (! guard.getType(types, decls, func, curFunc).equals(new BoolType())) {
          System.out.println("IF STATEMNET NEEDS A BOOLEAN TYPE FOR GUARD: " + this.getLineNum());
      }
      thenBlock.typeOpCheck(types, decls, func, curFunc);
      elseBlock.typeOpCheck(types, decls, func, curFunc);
   }

   public void typeCheck(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
       // System.out.println("TYPECHECK: Conditional");

        thenBlock.typeCheck(types, decls, func, curFunc);
	elseBlock.typeCheck(types, decls, func, curFunc);
   }


   public boolean checkReturn() {
        return thenBlock.checkReturn() && elseBlock.checkReturn();
   }

   public CFGNode cfg(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc, CFGNode startNode, CFGNode exitNode) {
       //guard.cfg(types, decls, func, curFunc);
       startNode.addGuard(guard);
       startNode.addLLVMList(guard.toLLVM(types, decls, func, curFunc, startNode, exitNode));
 
       CFGNode thenNode = new CFGNode( startNode.name, exitNode.blockNum );
       exitNode.incrementBlock();
       thenNode.addParent(startNode);
       startNode.addChild(thenNode);
       CFGNode thenEndNode = thenBlock.cfg(types, decls, func, curFunc, thenNode, exitNode);

       CFGNode elseNode = new CFGNode(startNode.name, exitNode.blockNum);
       exitNode.incrementBlock();
       elseNode.addParent(startNode);
       startNode.addChild(elseNode);
       CFGNode elseEndNode = elseBlock.cfg(types, decls, func, curFunc, elseNode, exitNode);
       
       CFGNode ifEndNode = new CFGNode(startNode.name, exitNode.blockNum );
       exitNode.incrementBlock();
       ifEndNode.addParent(thenEndNode);
       ifEndNode.addParent(elseEndNode);

       thenEndNode.addChild(ifEndNode);
       elseEndNode.addChild(ifEndNode);

// add branches
       String op = ((BinaryExpression) guard).getOp();
       startNode.addLLVM(new BranchLLVM( op , thenNode.name + thenNode.count, elseNode.name + elseNode.count));
       thenNode.addLLVM(new BranchImmLLVM(ifEndNode.name + ifEndNode.count));
       elseNode.addLLVM(new BranchImmLLVM(ifEndNode.name + ifEndNode.count));

       return ifEndNode;
   }

   public String typeToLLVM(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
       return "";
   }

   public List<LLVM> toLLVM(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
       return new ArrayList<LLVM>();     
   }
}

