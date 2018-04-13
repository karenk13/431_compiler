package ast;

import java.util.List;

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

   public void cfg(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
       guard.cfg(types, decls, func, curFunc);
       System.out.print("If: ");
       thenBlock.cfg(types, decls, func, curFunc);
       System.out.print("Else: ");
       elseBlock.cfg(types, decls, func, curFunc);
   }

}

