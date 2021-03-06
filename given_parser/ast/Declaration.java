package ast;

public class Declaration
{
   private final int lineNum;
   private final Type type;
   private final String name;

   public Declaration(int lineNum, Type type, String name)
   {
      this.lineNum = lineNum;
      this.type = type;
     this.name = name;
   }

   public String getName() {
      return name;
   }

   public Type getType() {
      return type;
   }

   public int getLineNum() {
      return lineNum;
   }
}
