package ast;

import java.util.List;
import java.util.ArrayList;
import cfg.*;
import llvm.*;

public class InvocationExpression
   extends AbstractExpression
{
   private final String name;
   private final List<Expression> arguments;

   public InvocationExpression(int lineNum, String name,
      List<Expression> arguments)
   {
      super(lineNum);
      this.name = name;
      this.arguments = arguments;
   }

   public void typeOpCheck(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
      for (int i = 0; i < arguments.size(); i++) {
         arguments.get(i).typeOpCheck(types, decls, func, curFunc);
      }
      for (int i = 0; i < func.size(); i++) {
           if ( func.get(i).getName().equals(name) ) {
                if (func.get(i).getParams().size() != arguments.size()) {
                     System.out.println("FUNCTION CALL HAS TOO MANY ARGS: " + this.getLineNum());
                     return;
                }

                for (int j = 0; j < func.get(i).getParams().size(); j++) {
                     if ( !arguments.get(j).getType(types, decls, func, curFunc).equals(func.get(i).getParams().get(j))){
                           System.out.println("FUNCTION CALL HAS A MISMATCH IN PASSED IN PARAMETERS: "+ this.getLineNum() );
                           return;
                     }
                }
           }
       }     
      
   }

   public Type getType(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {

      // TODO MATCH MORE STUFF

      try {
      	 for (int i = 0; i < func.size(); i++ ) {
            if (func.get(i).getName().equals(name)) {
               //ystem.out.println("checking type of function : " + func.get(i).getName());
               return func.get(i).getReturnType();
	    } 
         }
         throw new Exception("Identifier: " + this.name + " not found");
      } catch (Exception e) {
      	   System.out.println("Caught exception");
	}
	return new NullType();
   }
   
   public void cfg(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
   	System.out.println("invocation expression: " + name);
        for (int i = 0; i < arguments.size(); i++) {
	   arguments.get(i).cfg(types, decls, func, curFunc);
        }
   }
   
   public String typeToLLVM(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
      	 for (int i = 0; i < func.size(); i++ ) {
            if (func.get(i).getName().equals(name)) {
               //ystem.out.println("checking type of function : " + func.get(i).getName());
               return func.get(i).getReturnType().toLLVMType();
	    } 
         }
       return "i32";
   }

   public List<LLVM> toLLVM(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc, CFGNode startNode, CFGNode exitNode) {
         String type = "";
      	 for (int i = 0; i < func.size(); i++ ) {
            if (func.get(i).getName().equals(name)) {
               type = func.get(i).getReturnType().toLLVMType(); 
	    } 
         }
         List<LLVM> argumentInst = new ArrayList<LLVM> ();
         List<String> argReg = new ArrayList<String> ();
         List<LLVM> insts = null;
         for (int i = 0; i < arguments.size(); i++) {
            insts = arguments.get(i).toLLVM(types, decls, func, curFunc, startNode, exitNode);
            argReg.add(insts.get(insts.size() - 1).getResultReg());
            argumentInst.addAll(insts);
         }
         
         LLVM calling = new InvocationLLVM("%u" + exitNode.regNum, type, "%" + name, argReg);
         exitNode.incrementReg();
       List<LLVM> list = new ArrayList<LLVM>(argumentInst);
       list.add(calling);
       return list;    
   }
}
