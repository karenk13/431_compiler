package ast;

import java.util.List;

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

   public void cfg(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
       source.cfg(types, decls, func, curFunc);
   }
   
}
