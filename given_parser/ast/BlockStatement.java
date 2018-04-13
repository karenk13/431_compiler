package ast;

import java.util.List;
import java.util.ArrayList;

public class BlockStatement
   extends AbstractStatement
{
   private final List<Statement> statements;

   public BlockStatement(int lineNum, List<Statement> statements)
   {
      super(lineNum);
      this.statements = statements;
   }

   public static BlockStatement emptyBlock()
   {
      return new BlockStatement(-1, new ArrayList<>());
   }

   public void typeOpCheck(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
      for (int i = 0; i < statements.size(); i++ ) {
          statements.get(i).typeOpCheck(types, decls, func, curFunc);
      }
   }


   public void typeCheck(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
    // System.out.println("TYPE CHECKING: BLOCK STATEMENT");
      for (int i = 0; i < statements.size(); i++ ) {
          statements.get(i).typeCheck(types, decls, func, curFunc);
      }
   }

   public boolean checkReturn() {
	for (int i = 0; i < statements.size(); i++ ) {
	     if ( statements.get(i).checkReturn()) {
		return true;
	     }
        }
	return false;
   }

   public void cfg(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
      for (int i = 0; i < statements.size(); i++ ) {
          statements.get(i).cfg(types, decls, func, curFunc);
      }
   }

}
