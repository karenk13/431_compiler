package ast;

import java.util.List;

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

   public void cfg(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
       expression.cfg(types, decls, func, curFunc);
   }

}
