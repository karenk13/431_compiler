package ast;

import java.util.List;
import java.util.ArrayList;
import cfg.*;
import llvm.*;

public class BinaryExpression
   extends AbstractExpression
{
   private final Operator operator;
   private final Expression left;
   private final Expression right;

   private BinaryExpression(int lineNum, Operator operator,
      Expression left, Expression right)
   {
      super(lineNum);
      this.operator = operator;
      this.left = left;
      this.right = right;
   }

   public static BinaryExpression create(int lineNum, String opStr,
      Expression left, Expression right)
   {
      switch (opStr)
      {
         case TIMES_OPERATOR:
            return new BinaryExpression(lineNum, Operator.TIMES, left, right);
         case DIVIDE_OPERATOR:
            return new BinaryExpression(lineNum, Operator.DIVIDE, left, right);
         case PLUS_OPERATOR:
            return new BinaryExpression(lineNum, Operator.PLUS, left, right);
         case MINUS_OPERATOR:
            return new BinaryExpression(lineNum, Operator.MINUS, left, right);
         case LT_OPERATOR:
            return new BinaryExpression(lineNum, Operator.LT, left, right);
         case LE_OPERATOR:
            return new BinaryExpression(lineNum, Operator.LE, left, right);
         case GT_OPERATOR:
            return new BinaryExpression(lineNum, Operator.GT, left, right);
         case GE_OPERATOR:
            return new BinaryExpression(lineNum, Operator.GE, left, right);
         case EQ_OPERATOR:
            return new BinaryExpression(lineNum, Operator.EQ, left, right);
         case NE_OPERATOR:
            return new BinaryExpression(lineNum, Operator.NE, left, right);
         case AND_OPERATOR:
            return new BinaryExpression(lineNum, Operator.AND, left, right);
         case OR_OPERATOR:
            return new BinaryExpression(lineNum, Operator.OR, left, right);
         default:
            throw new IllegalArgumentException();
      }
   }

   private static final String TIMES_OPERATOR = "*";
   private static final String DIVIDE_OPERATOR = "/";
   private static final String PLUS_OPERATOR = "+";
   private static final String MINUS_OPERATOR = "-";
   private static final String LT_OPERATOR = "<";
   private static final String LE_OPERATOR = "<=";
   private static final String GT_OPERATOR = ">";
   private static final String GE_OPERATOR = ">=";
   private static final String EQ_OPERATOR = "==";
   private static final String NE_OPERATOR = "!=";
   private static final String AND_OPERATOR = "&&";
   private static final String OR_OPERATOR = "||";

   public static enum Operator
   {
      TIMES, DIVIDE, PLUS, MINUS, LT, GT, LE, GE, EQ, NE, AND, OR
   }

   public Type getType(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
     
      switch (operator){
	case TIMES:
	    return new IntType();
        case DIVIDE:
	    return new IntType();
        case PLUS:
	    return new IntType();
	case MINUS:
	    return new IntType();
	default:
            return new BoolType();
      }
   }

   public String getOp() {
	return operator.toString();
   }


   public void typeOpCheck(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
     //left.typeOpCheck(types, decls, func, curFunc);
     //right.typeOpCheck(types, decls, func, curFunc);
     
     boolean l = false;
     boolean r = false; 
     switch (operator){
	case TIMES:
	    l = left.getType(types, decls, func, curFunc).equals(new IntType());
            r = right.getType(types, decls, func, curFunc).equals(new IntType());
            break;
        case DIVIDE:
	    l = left.getType(types, decls, func, curFunc).equals(new IntType());
            r = right.getType(types, decls, func, curFunc).equals(new IntType());
            break;
        case PLUS:
	    l = left.getType(types, decls, func, curFunc).equals(new IntType());
            r = right.getType(types, decls, func, curFunc).equals(new IntType());
            break;
	case MINUS:
	    l = left.getType(types, decls, func, curFunc).equals(new IntType());
            r = right.getType(types, decls, func, curFunc).equals(new IntType());
            break;
	case LT:
	    l = left.getType(types, decls, func, curFunc).equals(new IntType());
            r = right.getType(types, decls, func, curFunc).equals(new IntType());
            break;
        case GT:
	    l = left.getType(types, decls, func, curFunc).equals(new IntType());
            r = right.getType(types, decls, func, curFunc).equals(new IntType());
            break;
        case LE:
	    l = left.getType(types, decls, func, curFunc).equals(new IntType());
            r = right.getType(types, decls, func, curFunc).equals(new IntType());
            break;
	case GE:
	    l = left.getType(types, decls, func, curFunc).equals(new IntType());
            r = right.getType(types, decls, func, curFunc).equals(new IntType());
            break;
        case EQ:
	    l = left.getType(types, decls, func, curFunc).equals(new IntType());
            r = right.getType(types, decls, func, curFunc).equals(new IntType());
            break;
	case NE:
	    l = left.getType(types, decls, func, curFunc).equals(new IntType());
            r = right.getType(types, decls, func, curFunc).equals(new IntType());
            break;
        default:
	    l = left.getType(types, decls, func, curFunc).equals(new BoolType());
            r = right.getType(types, decls, func, curFunc).equals(new BoolType());
      }

      if (!l || !r) {
          System.out.println("ERROR BINARY OPERATION AND OPERAND MISMATCH: " + left.getLineNum() );
      }

   }

   public void cfg(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
   	System.out.println("binary expression: " + operator);
	left.cfg(types, decls, func, curFunc);
	right.cfg(types, decls, func, curFunc);
   }

   public String typeToLLVM(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
      switch (operator){
	case TIMES:
	    return "i32";
        case DIVIDE:
	    return "i32";
        case PLUS:
	    return "i32";
	case MINUS:
	    return "i32";
	default:
            return "i1";
      }
   }

   public List<LLVM> toLLVM(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc, CFGNode startNode, CFGNode exitNode) {

       List<LLVM> leftI = left.toLLVM(types, decls, func, curFunc, startNode, exitNode);
       List<LLVM> rightI = right.toLLVM(types, decls, func, curFunc, startNode, exitNode);

       String leftResult = leftI.get(leftI.size() - 1).getResultReg();
       String rightResult = rightI.get(rightI.size() - 1).getResultReg();
      
       String leftType = leftI.get(leftI.size() - 1).getResultType();

       LLVM finalInst = null;
       switch (operator){
	 case TIMES:
            finalInst = new BinaryLLVM("%u" + exitNode.regNum, "MUL", leftType, leftResult, rightResult);
            exitNode.incrementReg();
            break;
         case DIVIDE:
            finalInst = new BinaryLLVM("%u" + exitNode.regNum, "SDIV", leftType, leftResult, rightResult);
            exitNode.incrementReg();
            break;
         case PLUS:
            finalInst = new BinaryLLVM("%u" + exitNode.regNum, "ADD", leftType, leftResult, rightResult);
            exitNode.incrementReg();
            break;
	 case MINUS:
            finalInst = new BinaryLLVM("%u" + exitNode.regNum, "SUB", leftType, leftResult, rightResult);
            exitNode.incrementReg();
            break;
	 case LT:
            finalInst = new ComparisonLLVM("%u" + exitNode.regNum, "SLT", leftType, leftResult, rightResult);
            exitNode.incrementReg();
            break;
         case GT:
            finalInst = new ComparisonLLVM("%u" + exitNode.regNum, "SGT", leftType, leftResult, rightResult);
            exitNode.incrementReg();
            break;
         case LE:
            finalInst = new ComparisonLLVM("%u" + exitNode.regNum, "SLE", leftType, leftResult, rightResult);
            exitNode.incrementReg();
            break;
	 case GE:
            finalInst = new ComparisonLLVM("%u" + exitNode.regNum, "SGE", leftType, leftResult, rightResult);
            exitNode.incrementReg();
            break;
         case EQ:
            finalInst = new ComparisonLLVM("%u" + exitNode.regNum, "EQ", leftType, leftResult, rightResult);
            exitNode.incrementReg();
            break;
	 case NE:
            finalInst = new ComparisonLLVM("%u" + exitNode.regNum, "NE", leftType, leftResult, rightResult);
            exitNode.incrementReg();
            break;

	 case AND:
            finalInst = new BinaryLLVM("%u" + exitNode.regNum, "AND", leftType, leftResult, rightResult);
            exitNode.incrementReg();
            break;
	 case OR:
            finalInst = new BinaryLLVM("%u" + exitNode.regNum, "OR", leftType, leftResult, rightResult);
            exitNode.incrementReg();
            break;

         default:
            System.out.println("In Binary Something happened");
       }

       List<LLVM> listLLVM = new ArrayList<LLVM>(leftI);
       listLLVM.addAll(rightI);
       listLLVM.add(finalInst);
       
       return listLLVM;     
   }
}
