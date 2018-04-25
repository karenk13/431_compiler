package ast;

import java.util.List;
import java.util.ArrayList;
import cfg.*;
import llvm.*;

public class DotExpression
   extends AbstractExpression
{
   private final Expression left;
   private final String id;

   public DotExpression(int lineNum, Expression left, String id)
   {
      super(lineNum);
      this.left = left;
      this.id = id;
   }

   public void typeOpCheck(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
   
   }
   
   public Type getType(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc){
      Type leftType = left.getType(types, decls, func, curFunc);
      if(leftType instanceof StructType) {
      //if (leftType.equals(new StructType(this.getLineNum(), id))) {
        // System.out.println("leftType stuff: id: " + id + " linenum: " + this.getLineNum());
      	for (int i = 0; i < types.size(); i++) {
          if (((StructType) leftType).getName().equals(types.get(i).getName())) {
	     for(int j = 0; j < types.get(i).getFields().size(); j++ ) {
		if (types.get(i).getFields().get(j).getName().equals(this.id)) {
		    return types.get(i).getFields().get(j).getType();
		}
	     }
          } 
      	}
      }
      System.out.println("ERROR: FIELD NOT FOUND: " + id);
      return new NullType();
   }
   
   public void cfg(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {

	System.out.println("dot expression: " + id);
        left.cfg(types, decls, func, curFunc);
   }
   
   public String typeToLLVM(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
      Type leftType = left.getType(types, decls, func, curFunc);
      if(leftType instanceof StructType) {
      	for (int i = 0; i < types.size(); i++) {
          if (((StructType) leftType).getName().equals(types.get(i).getName())) {
	     for(int j = 0; j < types.get(i).getFields().size(); j++ ) {
		if (types.get(i).getFields().get(j).getName().equals(this.id)) {
		    return types.get(i).getFields().get(j).getType().toLLVMType();
		}
	     }
          } 
      	}
      }
      System.out.println("ERROR: FIELD NOT FOUND: " + id);
      return "i32";
   }

   public List<LLVM> toLLVM(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc, CFGNode startNode, CFGNode exitNode) {
       List<LLVM> leftI = left.toLLVM(types, decls, func, curFunc, startNode, exitNode);
       String leftReg = leftI.get(leftI.size() - 1).getResultReg();

       String structName = "";
       int fieldIndex = -1;
       Type leftType = left.getType(types, decls, func, curFunc);

      	for (int i = 0; i < types.size(); i++) {
          if (((StructType) leftType).getName().equals(types.get(i).getName())) {
             // struct type name
             structName = types.get(i).getName();
	     for(int j = 0; j < types.get(i).getFields().size(); j++ ) {
		if (types.get(i).getFields().get(j).getName().equals(this.id)) {
                    // field name and index
                    fieldIndex = j;
		}
	     }
          } 
      	}
       LLVM inst = new GetElementPtrLLVM("%u" + exitNode.regNum, "%struct." + structName, leftReg, Integer.toString(fieldIndex) );
       exitNode.incrementReg();

      // LLVM last = new LoadLLVM("%u"+ exitNode.regNum, inst.getResultType(), inst.getResultReg());
      // exitNode.incrementReg();


       List<LLVM> finalInst = new ArrayList<LLVM>(leftI);
       finalInst.add(inst);
      // finalInst.add(last);

       return finalInst;     
   }
}
