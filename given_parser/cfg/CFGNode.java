package cfg;

import ast.*;
import java.util.List;
import java.util.ArrayList;

import llvm.*;

public class CFGNode
{  
   public String name;
   public List<CFGNode> parents;
   public List<CFGNode> children;
   public List<Statement> statements;
   public Expression guard;
   public int count;
   public int blockNum;
   public int regNum;

   public List<LLVM> llvm;

   public CFGNode(String name, int count) {
      this.name = name;
      this.count = count;
      this.parents = new ArrayList<CFGNode>();
      this.children = new ArrayList<CFGNode>();
      this.statements = new ArrayList<Statement>();
      this.guard = null;
      this.blockNum = 0;
      this.regNum = 0;
      this.llvm = new ArrayList<LLVM>();
   }

   public CFGNode(String name, List<CFGNode> parents, List<CFGNode> children, List<Statement> statements, int count) {
      this.name = name;
      this.parents = parents;
      this.children = children;
      this.statements = statements;
      this.count = count;
      this.guard = null;
      this.blockNum = 0;
      this.regNum = 0;
      this.llvm = new ArrayList<LLVM>();
   }

   public void addLLVM( LLVM l ) {
       llvm.add(l);
   }

   public void addLLVMList(List<LLVM> l) {
       llvm.addAll(l);
   }

   public void incrementBlock(){
      this.blockNum+=1;
   }

   public void incrementReg() {
      this.regNum+=1;
   }

   public void addParent(CFGNode parent) {
      parents.add(parent);
   }

   public void addChild(CFGNode child) {
      children.add(child);
   }
   
   public void addStatement(Statement s) {
      statements.add(s);
   }

   public void addGuard(Expression guard) {
       this.guard = guard;
   }  

   public void printOut() {
 //      System.out.println(name + " " + count + ": " + llvm.size());
       for (int i = 0; i < llvm.size(); i++) {
           llvm.get(i).printOut();
       }
       for (int i = 0; i < children.size(); i++) {
           if (children.get(i).count >= this.count)
 //         System.out.println("Parent: " + this.count + " Child: " + children.get(i).count); 
           	{children.get(i).printOut();} 
          else {
	//	System.out.println("No");
           }
       }
   }
}
