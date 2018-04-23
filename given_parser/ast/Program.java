package ast;

import java.util.List;
import java.util.ArrayList;
import cfg.*;
import llvm.*;

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
         CFGNode globalNode = new CFGNode("globals", 0);
         cfgNodes.add(globalNode);

	List<LLVM> globalDec = new ArrayList<LLVM>();

	//declarations
	List<String> args = new ArrayList<String>();
         args.add("i8*");
         args.add("...");
         List<String> blanks = new ArrayList<String>();
         blanks.add(" ");
         blanks.add(" ");
         LLVM s = new DeclareFuncLLVM("scanf", "i32", args, blanks);
         LLVM p  = new DeclareFuncLLVM("printf", "i32", args, blanks);
	
         List<String> args1 = new ArrayList<String>();
         args1.add("i32");
         LLVM m = new DeclareFuncLLVM("malloc", "i8*", args1, blanks );

	globalDec.add(s);
        globalDec.add(p);
        globalDec.add(m);

        //List<String> props = new ArrayList<String>();
        LLVM struct = null;
	for( int i = 0; i < types.size(); i++) {
             List<String> props = new ArrayList<String>();
             for(int j = 0; j < types.get(i).getFields().size(); j++) {
                  props.add(types.get(i).getFields().get(j).getType().toLLVMType() );
             }

             struct = new DeclareStructLLVM(types.get(i).getName(), props);
             globalDec.add(struct);
	   //  props.clear();
        }
	globalNode.addLLVMList(globalDec);


      for (int i = 0; i < funcs.size(); i++) {
	 //System.out.println(funcs.get(i).getName());
         CFGNode initNode = new CFGNode(funcs.get(i).getName(), 0);
 //        cfgNodes.add(initNode);


	 // and func definition, local declaration
	 List<String> funcArgs = new ArrayList<String>();
         List<String> props = new ArrayList<String>();

         for(int j = 0; j < funcs.get(i).getParams().size(); j++) {
             props.add(funcs.get(i).getParams().get(j).getType().toLLVMType() );
             funcArgs.add(funcs.get(i).getParams().get(j).getName());
         }

         struct = new DeclareFuncLLVM(funcs.get(i).getName(), funcs.get(i).getReturnType().toLLVMType(), props, funcArgs);

         initNode.addLLVM(struct);


         List<LLVM> localVars = new ArrayList<LLVM>();
	 for (int j = 0; j < funcs.get(i).getDecls().size(); j++) {
              localVars.add(new AllocationLLVM(funcs.get(i).getDecls().get(j).getName(), funcs.get(i).getDecls().get(j).getType().toLLVMType()));
         }
         initNode.addLLVMList(localVars);


         CFGNode startNode = new CFGNode(funcs.get(i).getName(), 1);
         startNode.addParent(initNode);
         initNode.addChild(startNode);
         cfgNodes.add(initNode);
         CFGNode exitNode = new CFGNode(funcs.get(i).getName(), -1);
         exitNode.incrementBlock();
         // we will keep track of the Block number and Register number for LLVM reference in the exit node (since it is always passed around)
         funcs.get(i).cfg(types, decls, funcs, funcs.get(i), startNode, exitNode);
      }
   }
   public void printLLVM() {
      for (int i = 0; i < cfgNodes.size(); i++) {
         cfgNodes.get(i).printOut();
      }

   }
}
