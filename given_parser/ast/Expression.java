package ast;

import java.util.List;
import cfg.*;
import llvm.*;

public interface Expression
{
   public Type getType(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc);
   public void typeOpCheck(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc);
   public int getLineNum();

   public void cfg(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc);

   //public String typeToLLVM(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc);
   public List<LLVM> toLLVM(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc, CFGNode startNode, CFGNode exitNode);
}
