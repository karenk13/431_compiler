package ast;

import java.util.List;
import java.util.ArrayList;
import cfg.*;
import llvm.*;

public class DeleteStatement
   extends AbstractStatement
{
   private final Expression expression;

   public DeleteStatement(int lineNum, Expression expression)
   {
      super(lineNum);
      this.expression = expression;
   }


   public void typeOpCheck(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
      expression.typeOpCheck(types, decls, func, curFunc);
   }

   public void typeCheck(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
      //System.out.println("TYPECHECK: Delete");
 
   }


   public boolean checkReturn() {
        return false;
   }

   public CFGNode cfg(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc, CFGNode startNode, CFGNode exitNode) {
       //expression.cfg(types, decls, func, curFunc);
       startNode.addStatement(this);
       return startNode;
   }


   public String typeToLLVM(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
       return "";
   }


   public List<LLVM> toLLVM(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
       return new ArrayList<LLVM>();     
   }

}
