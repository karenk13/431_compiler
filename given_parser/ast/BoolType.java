package ast;

public class BoolType
   implements Type
{
   public boolean equals(Type left) {
      return (left instanceof BoolType);
   }

   public String toLLVMType() {
      return "i1";
   }

}
