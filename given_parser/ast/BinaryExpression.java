package ast;

import java.util.List;

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
}
