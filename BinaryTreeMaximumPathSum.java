package com.sample.interview.problem;

class BinaryTreeMaximumPathSum 
{ 
    // Root of Binary Tree 
    Node root; 
  
    BinaryTreeMaximumPathSum() 
    { 
        root = null; 
    } 
    int max_path_sum = Integer.MIN_VALUE;
    public int pathSum(Node node)
    {
    	if (node == null) return 0;
    	
    	int left =   Math.max(0,pathSum(node.left));
    	System.out.println("left = "+left);
    	int right =   Math.max(0,pathSum(node.right));
    	System.out.println("right = "+right);
    	max_path_sum = Math.max(max_path_sum, left + right + node.data);
    	System.out.println("max_path_sum = "+max_path_sum);
    	return Math.max(left,right)+node.data;
    }
    
    public int pathSum1(Node node)
    {
    	if (node == null) return 0;
    	
    	int left =   Math.max(0,pathSum(node.left));
    	System.out.println("left = "+left);
    	int right =   Math.max(0,pathSum(node.right));
    	System.out.println("right = "+right);
    	int max_staight = Math.max(Math.max(left,right)+root.data, node.data); //Case - 1
    	System.out.println("max_caseVal = "+max_staight);
    	int max_caseVal = Math.max(max_staight, left+right+node.data); //Case 2 - 1 compared
    	System.out.println("max_caseVal = "+max_caseVal);
    	max_path_sum = Math.max(max_caseVal,max_path_sum); //Case -  3
    	System.out.println("max_path_sum = "+max_path_sum);
    	return Math.max(left,right)+node.data;
    }
    /* Given a binary tree, print its nodes according to the 
      "bottom-up" postorder traversal. */
    void printPostorder(Node node) 
    { 
        if (node == null) 
            return; 
  
        // first recur on left subtree 
        printPostorder(node.left); 
  
        // then recur on right subtree 
        printPostorder(node.right); 
  
        // now deal with the node 
        System.out.print(node.data + " "); 
    } 
  
    /* Given a binary tree, print its nodes in inorder*/
    void printInorder(Node node) 
    { 
        if (node == null) 
            return; 
  
        /* first recur on left child */
        printInorder(node.left); 
  
        /* then print the data of node */
        System.out.print(node.data + " "); 
  
        /* now recur on right child */
        printInorder(node.right); 
    } 
  
    /* Given a binary tree, print its nodes in preorder*/
    void printPreorder(Node node) 
    { 
        if (node == null) 
            return; 
  
        /* first print data of node */
        System.out.print(node.data + " "); 
  
        /* then recur on left sutree */
        printPreorder(node.left); 
  
        /* now recur on right subtree */
        printPreorder(node.right); 
        
        
       
    } 
  
    // Wrappers over above recursive functions 
    void printPostorder()  {     printPostorder(root);  } 
    void printInorder()    {     printInorder(root);   } 
    void printPreorder()   {     printPreorder(root);  } 
    void  pathSum()
    {
    	 pathSum(root);
    	 System.out.println(max_path_sum);
    }
  
    // Driver method 
    public static void main(String[] args) 
    { 
        BinaryTreeMaximumPathSum tree = new BinaryTreeMaximumPathSum(); 
        tree.createTree2(tree);	
        
        System.out.println("Preorder traversal of binary tree is "); 
        tree.printPreorder(); 
  
        System.out.println("\nInorder traversal of binary tree is "); 
        tree.printInorder(); 
  
        System.out.println("\nPostorder traversal of binary tree is "); 
        tree.printPostorder(); 
        
        System.out.println("\nPath Sum....."); 
        tree.pathSum();
         
    } 
    public static void createTree1(BinaryTreeMaximumPathSum tree)
    {
        tree.root = new Node(-10); 
        tree.root.right = new Node(9); 
        tree.root.right.right = new Node(20); 
        tree.root.right.right.left = new Node(15); 
        tree.root.left = new Node(7); 
    }
    
    public static void createTree2(BinaryTreeMaximumPathSum tree)
    {
        tree.root = new Node(-1); 
        tree.root.right = new Node(2); 
        tree.root.left = new Node(1); 
        
        tree.root.left.right = new Node(5);
        tree.root.left.right.right = new Node(-10);
        
        tree.root.left.left = new Node(4); 
        
        tree.root.left.left.left = new Node(8); 
        tree.root.left.left.right= new Node(4); 
        
    }
    
} 


