package ast;

import java.util.List;

public class LvalueId
   implements Lvalue
{
   private final int lineNum;
   private final String id;

   public LvalueId(int lineNum, String id)
   {
      this.lineNum = lineNum;
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
