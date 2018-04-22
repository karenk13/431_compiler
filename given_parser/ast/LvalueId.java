package ast;

import java.util.List;
import llvm.*;
import cfg.*;
import java.util.ArrayList;

public class LvalueId
   implements Lvalue
{
   private final int lineNum;
   private final String id;

   public LvalueId(int lineNum, String id)
   {
      this.lineNum = lineNum;
      this.id = id;
   }

   public Type getType( List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc){
      for (int i = 0; i < decls.size(); i++ ) {
         if (decls.get(i).getName().equals(this.id)) {
             return decls.get(i).getType();
         }
      }
      return new NullType();
   }
   public List<LLVM> toLLVM(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc, CFGNode startNode, CFGNode exitNode) {
      String type = "";
      for (int i = 0; i < decls.size(); i++ ) {
         if (decls.get(i).getName().equals(this.id)) {
             // get id and type
             type = decls.get(i).getType().toLLVMType();
         }
      }
       LLVM inst = new LoadLLVM("%u" + exitNode.regNum, type, "%" + id);
       exitNode.incrementReg();
       List<LLVM> list = new ArrayList<LLVM>();
       list.add(inst);

       return list;
   }

   
}
