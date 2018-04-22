package ast;

import java.util.List;
import java.util.ArrayList;
import cfg.*;
import llvm.*;

public class NewExpression
   extends AbstractExpression
{
   private final String id;

   public NewExpression(int lineNum, String id)
   {
      super(lineNum);
      this.id = id;
   }

   public Type getType(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc){
      try {
      	 for (int i = 0; i < types.size(); i++ ) {
            if (types.get(i).getName().equals(this.id)) {
	       return new StructType(types.get(i).getLineNum(), this.id);
	    } 
         }
         throw new Exception("Struct: " + this.id + " not found");
      } catch (Exception e) {
      	   System.out.println("Caught exception");
	}
	return new NullType();
   }

   public void typeOpCheck(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
   }
   
   public void cfg(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
   	System.out.println("new expression: " + id);
   }
   
   public String typeToLLVM(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
      	 for (int i = 0; i < types.size(); i++ ) {
            if (types.get(i).getName().equals(this.id)) {
	       return new StructType(types.get(i).getLineNum(), this.id).toLLVMType();
	    } 
         }
       return "i32";
   }

   public List<LLVM> toLLVM(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc, CFGNode startNode, CFGNode exitNode) {
        String type = "";
      	 for (int i = 0; i < types.size(); i++ ) {
            if (types.get(i).getName().equals(this.id)) {
               type = new StructType(types.get(i).getLineNum(), this.id).toLLVMType();
	    } 
         }
 
       LLVM inst = new AllocationLLVM("%u" + exitNode.regNum, type);
       exitNode.incrementReg();
       List<LLVM> list = new ArrayList<LLVM> ();
       list.add(inst);
       return list;     
   }
}
