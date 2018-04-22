package ast;

import java.util.List;
import llvm.*;
import cfg.*;
import java.util.ArrayList;

public class LvalueDot
   implements Lvalue
{
   private final int lineNum;
   private final Expression left;
   private final String id;

   public LvalueDot(int lineNum, Expression left, String id)
   {
      this.lineNum = lineNum;
      this.left = left;
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

       LLVM last = new LoadLLVM("%u"+ exitNode.regNum, inst.getResultType(), inst.getResultReg());
       exitNode.incrementReg();

       List<LLVM> finalInst = new ArrayList<LLVM>(leftI);
       finalInst.add(inst);
       finalInst.add(last);

       return finalInst;
   }

}
