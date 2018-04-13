package ast;

import java.util.List;

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

}
