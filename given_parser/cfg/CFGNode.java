package ast;

import java.util.List;

public class CFGNode
{  
   String name;
   List<CFGNode> parents;
   List<CFGNode> children;
   List<Expression> expressions;

   public CFGNode(String name, List<CFGNode> parents, List<CFGNode> children, List<Expression> expressions) {
      this.name = name;
      this.parents = parents;
      this.children = children;
      this.expressions = expressions;
   }

   public void addParent(CFGNode parent) {
      parents.add(parent);
   }

   public void addChild(CFGNode child) {
      children.add(child);
   }
   
   public void addExpression(Expression exp) {
      expressions.add(exp);
   }
}
