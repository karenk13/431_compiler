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

   public int mallocSize(List<TypeDeclaration> types) {
      	 String type;
	 int counter = 0;
         for (int i = 0; i < types.size(); i++ ) {
            if (types.get(i).getName().equals(this.id)) {
               type = new StructType(types.get(i).getLineNum(), this.id).toLLVMType();
               if(type.equals("i1")) {
		  counter += 1;
               }
               else if(type.equals("i8")) {
		  counter += 2;

               }
               else if(type.equals("i32") || type.contains("*")) {
		  counter += 6;

               }
	    } 
         }
	return counter;
   }

   public List<LLVM> toLLVM(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc, CFGNode startNode, CFGNode exitNode) {
        String type = "";
      	 for (int i = 0; i < types.size(); i++ ) {
            if (types.get(i).getName().equals(this.id)) {
               type = new StructType(types.get(i).getLineNum(), this.id).toLLVMType();
	    } 
         }
 
      // LLVM inst = new AllocationLLVM("%u" + exitNode.regNum, type);
       //exitNode.incremeVntReg();
       List<LLVM> list = new ArrayList<LLVM> ();
       //list.add(inst);

       List<String> arg = new ArrayList<String>();
       arg.add(Integer.toString(mallocSize(types)));
       LLVM inst = new InvocationLLVM("%u" + exitNode.regNum, "i8*", "malloc", arg);
       exitNode.incrementReg();

       LLVM inst1 = new MiscLLVM("%u" + exitNode.regNum, "i8*", inst.getResultReg(), type, "BITCAST");
       exitNode.incrementReg();

       list.add(inst);
       list.add(inst1);

       return list;     
   }
}
