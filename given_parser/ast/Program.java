package ast;

import java.util.List;
import java.util.ArrayList;
import cfg.*;

public class Program
{
   private final List<TypeDeclaration> types;
   private final List<Declaration> decls;
   private final List<Function> funcs;
   private final List<CFGNode> cfgNodes;


   public Program(List<TypeDeclaration> types, List<Declaration> decls,
      List<Function> funcs)
   {
      this.types = types;
      this.decls = decls;
      this.funcs = funcs;
      this.cfgNodes = new ArrayList<CFGNode>();
      if (! this.checkMain()) {
          System.out.println("ERROR: NO VALID MAIN");
      } 

      this.checkTypes();
      this.checkReturn();
      this.checkReturnTypes();
  

      // M2
      this.cfg();
   }


   public void checkTypes() {
      for (int i = 0; i < funcs.size(); i++) {
	 funcs.get(i).typeOpCheck(types, decls, funcs, funcs.get(i));
      }
   }

   public void checkReturnTypes() {
      for (int i = 0; i < funcs.size(); i++) {
         System.out.println(funcs.get(i).getName());

	 funcs.get(i).typeCheck(types, decls, funcs, funcs.get(i));
      }
   }

   public boolean checkMain() {
      for (int i = 0; i < funcs.size(); i++) {
          if (funcs.get(i).getName().equals("main")) {
	      return true;
          }
      }
      return false;
   }

   public boolean checkReturn() {
      for (int i = 0; i < funcs.size(); i++) {
	 if (! funcs.get(i).checkReturn()) {
	    System.out.println("ERROR: NOT ALL PATHS HAVE RETURN");
	    return false;
         }
      }
      return true;
   }

   public void cfg() {
      for (int i = 0; i < funcs.size(); i++) {
	 //System.out.println(funcs.get(i).getName());
         CFGNode startNode = new CFGNode(funcs.get(i).getName(), 0);
         cfgNodes.add(startNode);
         CFGNode exitNode = new CFGNode(funcs.get(i).getName(), -1);
         // we will keep track of the Block number and Register number for LLVM reference in the exit node (since it is always passed around)
         funcs.get(i).cfg(types, decls, funcs, funcs.get(i), startNode, exitNode);
      }
      for (int i = 0; i < cfgNodes.size(); i++) {
         cfgNodes.get(i).printOut();
      }
   }

}
