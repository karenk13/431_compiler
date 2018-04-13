package ast;

import java.util.List;


public class ReturnEmptyStatement
   extends AbstractStatement
{
   public ReturnEmptyStatement(int lineNum)
   {
      super(lineNum);
   }


   public void typeOpCheck(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
   }

   public void typeCheck(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
        //System.out.println("TYPECHECK: Return empty");
   	if (!(curFunc.getReturnType() instanceof VoidType)) {
	    System.out.println("RETURN TYPE not the same");
	}
   }

   public boolean checkReturn() {
        return true;
   }

   public void cfg(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
       //expression.cfg(types, decls, func, curFunc);
   }
}
