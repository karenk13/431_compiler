package ast;

public class IntType
   implements Type
{

   public boolean equals (Type left) {
      return (left instanceof IntType);
   }
}
