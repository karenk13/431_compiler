package ast;

public class NullType
   implements Type 
{

   public boolean equals (Type left) {
      return (left instanceof NullType);
   }
}
