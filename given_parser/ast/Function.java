package ast;

import java.util.List;
import cfg.*;

public class Function
{
   private final int lineNum;
   private final String name;
   private final Type retType;
   private final List<Declaration> params;
   private final List<Declaration> locals;
   private final Statement body;

   public Function(int lineNum, String name, List<Declaration> params,
      Type retType, List<Declaration> locals, Statement body)
   {
      this.lineNum = lineNum;
      this.name = name;
      this.params = params;
      this.retType = retType;
      this.locals = locals;
      this.body = body;
   }

   public String getName() {
       return name;
   }

   public Type getReturnType() {
       return retType;
   } 

   public void typeCheck(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
       body.typeCheck(types, decls, func, curFunc);
   }
   
   public void typeOpCheck(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
       body.typeOpCheck(types, decls, func, curFunc);
   }

   public boolean checkReturn() {
	return body.checkReturn();
   }

   public List<Declaration> getParams() {
        return params;
   }
   public List<Declaration> getDecls() {
        return locals;
   }
   public CFGNode cfg(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc, CFGNode startNode, CFGNode exitNode) {
       return body.cfg(types, decls, func, curFunc, startNode, exitNode);
   }
}
