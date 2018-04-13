package ast;

import java.util.List;


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

   public void cfg(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
      System.out.print("While: "); 
      guard.cfg(types, decls, func, curFunc);

      System.out.print("   body: ");
      body.cfg(types, decls, func, curFunc);
   }

}
