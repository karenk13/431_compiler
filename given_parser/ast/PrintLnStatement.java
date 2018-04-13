package ast;

import java.util.List;

public class PrintLnStatement
   extends AbstractStatement
{
   private final Expression expression;

   public PrintLnStatement(int lineNum, Expression expression)
   {
      super(lineNum);
      this.expression = expression;
   }

   public void typeOpCheck(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
       //expression.typeOpCheck(types, decls, func, curFunc);
       expression.getType(types, decls, func, curFunc);
   }
   public void typeCheck(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
     // System.out.println("TYPECHECK: Print ln");
   }

   public boolean checkReturn() {
        return false;
   }

   public void cfg(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
       expression.cfg(types, decls, func, curFunc);
   }

}
