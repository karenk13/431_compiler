package ast;

public class StructType
   implements Type
{
   private final int lineNum;
   private final String name;

   public StructType(int lineNum, String name)
   {
      this.lineNum = lineNum;
      this.name = name;
   }

   public boolean equals (Type left) {
      return ((left instanceof StructType) && (((StructType)left).name.equals(this.name))) ;
   }

   public String getName() {
      return name;
   }

   public String toLLVMType() {
      return "%struct." + name;
   }

}
