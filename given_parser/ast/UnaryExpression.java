package ast;

import java.util.List;

public class UnaryExpression
   extends AbstractExpression
{
   private final Operator operator;
   private final Expression operand;

   private UnaryExpression(int lineNum, Operator operator, Expression operand)
   {
      super(lineNum);
      this.operator = operator;
      this.operand = operand;
   }

   public static UnaryExpression create(int lineNum, String opStr,
      Expression operand)
   {
      if (opStr.equals(NOT_OPERATOR))
      {
         return new UnaryExpression(lineNum, Operator.NOT, operand);
      }
      else if (opStr.equals(MINUS_OPERATOR))
      {
         return new UnaryExpression(lineNum, Operator.MINUS, operand);
      }
      else
      {
         throw new IllegalArgumentException();
      }
   }

   private static final String NOT_OPERATOR = "!";
   private static final String MINUS_OPERATOR = "-";

   public static enum Operator
   {
      NOT, MINUS
   }

   public Type getType(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc){
      return operand.getType(types, decls, func, curFunc);
   }

   public void typeOpCheck(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc){
      if (operator == Operator.NOT && operand.getType(types, decls, func, curFunc).equals(new BoolType())) {
	operand.typeOpCheck(types, decls, func, curFunc);
      } else if (operator == Operator.MINUS && operand.getType(types, decls, func, curFunc).equals(new IntType())) {
        operand.typeOpCheck(types, decls, func, curFunc);
      } else {
        System.out.println("ERROR ON UNARY EXPRESSION");
      }
   }
   
   public void cfg(List<TypeDeclaration> types, List<Declaration> decls, List<Function> func, Function curFunc) {
   	System.out.println("unary expression: " + operator);
	operand.cfg(types, decls, func, curFunc);
   }
}
