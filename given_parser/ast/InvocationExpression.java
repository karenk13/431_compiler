package ast;

import java.util.List;

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
}
