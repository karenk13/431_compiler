package ast;

import java.util.List;
import llvm.*;
import cfg.*;

public interface Lvalue
{
     public Type getType( List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc);
   public List<LLVM> toLLVM(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc, CFGNode startNode, CFGNode exitNode);

}
