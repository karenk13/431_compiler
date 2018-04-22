package ast;

import java.util.List;
import llvm.*;
import java.util.ArrayList;
import cfg.*;

public class ReadExpression
   extends AbstractExpression
{
   public ReadExpression(int lineNum)
   {
      super(lineNum);
   }

   public Type getType(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc){
      return new VoidType();
   }

   public void typeOpCheck(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
   }

   public void cfg(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
   	System.out.println("read expression");
   }

   public String typeToLLVM(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
       return "i32";
   }

   public List<LLVM> toLLVM(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc, CFGNode startNode, CFGNode exitNode) {
       List<String> args = new ArrayList<String>();
       args.add("i8* getelementptr inbounds ([4xi8]*@.scanf,i32 0, i32 0)");
       args.add("i32 %_scanned");
       LLVM call = new InvocationLLVM("%u"+ exitNode.regNum,"i32 (i8*, ... )* ", "@scanf", args);
       exitNode.incrementReg();

       LLVM move = new LoadLLVM("%u" + exitNode.regNum, "i32", "%_scanned" );
       exitNode.incrementReg();

       List<LLVM> list = new ArrayList<LLVM>();
       list.add(call);
       list.add(move);

       return list;
   }
}
