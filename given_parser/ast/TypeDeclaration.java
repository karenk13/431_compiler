package ast;

import java.util.List;

public class TypeDeclaration
{
   private final int lineNum;
   private final String name;
   private final List<Declaration> fields;

   public TypeDeclaration(int lineNum, String name, List<Declaration> fields)
   {
      this.lineNum = lineNum;
      this.name = name;
      this.fields = fields;
   }

   public String getName() {
      return name;
   }
 
   public int getLineNum() {
      return lineNum;
   }

   public List<Declaration> getFields() {
      return fields;
   }
}
