package ast;

import java.util.List;

public class InvocationStatement
   extends AbstractStatement
{
   private final Expression expression;

   public InvocationStatement(int lineNum, Expression expression)
   {
      super(lineNum);
      this.expression = expression;
   }

   public void typeOpCheck(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
       expression.typeOpCheck(types, decls, func, curFunc);
   }
   public void typeCheck(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
     // System.out.println("TYPECHECK: Invocation");
  }


   public boolean checkReturn() {
        return false;
   }
 
   public void cfg(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
       expression.cfg(types, decls, func, curFunc);
   }

}
