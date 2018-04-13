package ast;

import java.util.List;

public interface Lvalue
{
     public Type getType( List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc);

}
