package com.sample.interview.problem;

import java.util.Stack;

class BinaryTreePreOrder 
{ 
	public static class TreeNode
    {
		
		TreeNode left;
        int data;
        TreeNode right;
        
        TreeNode(int data)
        {
            this.data=data;
        }
        
    }
 
    // Recursive Solution
public void preorder(TreeNode root) 
{
        if(root !=  null) 
        {
            //Visit the node-Printing the node data  
            System.out.printf("%d ",root.data);
            preorder(root.left);
            preorder(root.right);
        }
}
 
    // Iterative solution
public void preorderIter(TreeNode root) 
{
 
        if(root == null)
        {
            return;
        }
 
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
 
        while(!stack.empty())
        {
            TreeNode n = stack.pop();
            System.out.printf("%d ",n.data);
 
            if(n.right != null)
            {
                stack.push(n.right);
            }
            if(n.left != null)
            {
                stack.push(n.left);
            }
        }
}
 

public static void main(String[] args)
{
        BinaryTreePreOrder bi=new BinaryTreePreOrder();
        // Creating a binary tree
        TreeNode rootNode=callBinaryTree();
        System.out.println("Using Recursive solution:");
 
        bi.preorder(rootNode);
 
        System.out.println();
        System.out.println("-------------------------");
        System.out.println("Using Iterative solution:");
 
        bi.preorderIter(rootNode);
}

static public void creationOfBinaryTree(TreeNode root,TreeNode newNode) 
{
	
	     if(root == null)
	     {
	    	 return;
	     }
	     TreeNode  currentNode = root;
	     TreeNode temp = null;
	     while (currentNode != null)
	     {
	    	 //System.out.println(currentNode.data);
	    	 temp = currentNode;
	    	 currentNode =  (currentNode.data <= newNode.data) ? currentNode.right : currentNode.left;
	     }
	     
	     if(temp.data <= newNode.data)
	     {
	    	 temp.right = newNode;
	     }
	     else
	     {
	    	 temp.left = newNode;
	     }
}
 
public static TreeNode callBinaryTree()
{
 
	    //Initializing the node
        TreeNode rootNode=new TreeNode(40);
        //creationOfBinaryTree(rootNode,rootNode.data);
        TreeNode node20=new TreeNode(20);
        creationOfBinaryTree(rootNode,node20);
        TreeNode node10=new TreeNode(10);
        creationOfBinaryTree(rootNode,node10);
        TreeNode node30=new TreeNode(30);
        creationOfBinaryTree(rootNode,node30);
        TreeNode node60=new TreeNode(60);
        creationOfBinaryTree(rootNode,node60);
        TreeNode node50=new TreeNode(50);
        creationOfBinaryTree(rootNode,node50);
        TreeNode node70=new TreeNode(70);
        creationOfBinaryTree(rootNode,node70);
        
      //Arranging the node
		/*
		 * rootNode.left=node20; 
		 * rootNode.right=node60;
		 * 
		 * node20.left=node10; 
		 * node20.right=node30;
		 * 
		 * node60.left=node50; 
		 * node60.right=node70;
		 */
 
        return rootNode;
}
} 


