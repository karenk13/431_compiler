package ast;

import java.util.List;
import java.util.ArrayList;
import cfg.*;
import llvm.*;


public class AssignmentStatement
   extends AbstractStatement
{
   private final Lvalue target;
   private final Expression source;

   public AssignmentStatement(int lineNum, Lvalue target, Expression source)
   {
      super(lineNum);
      this.target = target;
      this.source = source;
   }

   public void typeCheck(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
	//System.out.println("TYPECHECK: Assignment");
	//source.typeCheck(returnType, types, decls, func);
   }

   public void typeOpCheck(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
       source.getType(types, decls, func, curFunc).equals(target.getType(types, decls, func, curFunc));
   }

   public boolean checkReturn() {
        return false;
   }

   public CFGNode cfg(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc, CFGNode startNode, CFGNode exitNode) {

              //  "u" + exit.regNum
       List<LLVM> sourceInst = source.toLLVM(types, decls, func, curFunc, startNode, exitNode);
       List<LLVM> leftInst = target.toLLVM(types, decls, func, curFunc, startNode, exitNode);


       String resultReg = sourceInst.get(sourceInst.size() - 1).getResultReg();
       String resultType = sourceInst.get(sourceInst.size() - 1).getResultType();
       
       String leftReg = leftInst.get(leftInst.size() - 1).getResultReg();
       String leftType = leftInst.get(leftInst.size() - 1).getResultType();

       //LLVM load = new LoadLLVM("%u" + exitNode.regNum, resultType, resultReg);
       LLVM store = new StoreLLVM(resultType, resultReg, leftType, leftReg);
       //exitNode.incrementReg();

       List<LLVM> finalList = new ArrayList<LLVM>(sourceInst);
       finalList.addAll(leftInst);
       //finalList.add(load);
       finalList.add(store);

       startNode.addLLVMList(finalList);

       startNode.addStatement(this);
       return startNode;
   }

   public String typeToLLVM(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
       return "";
   }


   public List<LLVM> toLLVM(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
       //LLVM load = new LoadLLVM();
       //LLVM load = new LoadLLVM();


      // LLVM store = new StoreLLVM();


       return new ArrayList<LLVM>();     
   }
}
