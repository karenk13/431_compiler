package ast;

public class VoidType
   implements Type
{

   public boolean equals (Type left) {
      return (left instanceof VoidType);
   }
}
