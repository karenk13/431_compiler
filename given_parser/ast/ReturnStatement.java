package ast;

import java.util.List;
import java.util.ArrayList;
import cfg.*;
import llvm.*;


public class ReturnStatement
   extends AbstractStatement
{
   private final Expression expression;

   public ReturnStatement(int lineNum, Expression expression)
   {
      super(lineNum);
      this.expression = expression;
   }

   public void typeOpCheck(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
      expression.typeOpCheck(types, decls, func, curFunc);
   }

   public void typeCheck(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
      //System.out.println("TYPECHECK: Return");
      
      //System.out.println("compare types: " + (expression.getType(types, decls, func).equals(returnType)));
      if ( !(expression.getType(types, decls, func, curFunc).equals(curFunc.getReturnType()))) {
          System.out.println("RETURN TYPE DOES NOT Match");
      }
   }

   public boolean checkReturn() {
        return true;
   }
   /*
   public boolean sameNode(CFGNode node1, CFGNode node2) {
      return node1 instanceof CFGNode && node1.equals(((CFGNode)node2).a); 
   }
   */
   public CFGNode cfg(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc, CFGNode startNode, CFGNode exitNode) {
       //expression.cfg(types, decls, func, curFunc);
       //CFGNode newNode = new CFGNode(startNode.name, startNode.count + 1);

       CFGNode retNode = new CFGNode(startNode.name , exitNode.blockNum);
       exitNode.incrementBlock();

       startNode.addChild(retNode);
       retNode.addParent(startNode);

       retNode.addChild(exitNode);
       exitNode.addParent(retNode);

       retNode.addLLVM(new ReturnEmptyLLVM());
       retNode.addStatement(this);

       List<LLVM> inst = expression.toLLVM(types, decls, func, curFunc, startNode, exitNode);
       String resultReg = inst.get(inst.size() - 1).getResultReg();
       String resultType = inst.get(inst.size() - 1).getResultType();
       LLVM ret = new ReturnLLVM(resultType, resultReg);
       retNode.addLLVMList(inst);
       retNode.addLLVM(ret);

       // store the value int _retval_
       // break to the blockLabel       


       
       return retNode;
   }


   public String typeToLLVM(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
       return "";
   }


   public List<LLVM> toLLVM(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
       return new ArrayList<LLVM>();     
   }


}
