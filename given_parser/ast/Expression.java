package ast;

import java.util.List;

public interface Expression
{
   public Type getType(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc);
   public void typeOpCheck(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc);
   public int getLineNum();

   public void cfg(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc);
}
