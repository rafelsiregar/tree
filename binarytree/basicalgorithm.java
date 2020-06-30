import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
  //BFS using Queue
  public static void levelOrder(Node root) {
        Queue q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            Node show = (Node) q.poll();
            System.out.print(show.data+" ");
            if(show.left!=null) q.add(show.left);
            if(show.right!=null) q.add(show.right);
        }
    }
  //DFS using Recursion
    public static void preOrder(Node root) {
        if(root!=null){
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    
    public static void inOrder(Node root) {
        if(root!=null){
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }
    
    public static void postOrder(Node root){
      if(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }
    }
	
 //DFS using Stack
public static void preorder_using_stack(Node root)
	{
		// return if tree is empty
		if (root == null) {
			return;
		}

		// create an empty stack and push root node
		Stack<Node> stack = new Stack();
		stack.push(root);

		// run till stack is not empty
		while (!stack.empty())
		{
			// pop a node from the stack and print it
			Node curr = stack.pop();

			System.out.print(curr.data + " ");

			// push right child of popped node to the stack
			if (curr.right != null) {
				stack.push(curr.right);
			}

			// push left child of popped node to the stack
			if (curr.left != null) {
				stack.push(curr.left);
			}

			// important note - right child is pushed first so that left child
			// is processed first (FIFO order)
		}
	}
	

public static void inorder_using_stack(Node root) { 
       // create an empty stack
	Stack<Node> stack = new Stack();
	// start from root node (set current node to root node)
	Node curr = root;
	// if current node is null and stack is also empty, we're done
	while (!stack.empty() || curr != null){
	// if current node is not null, push it to the stack (defer it)
	// and move to its left child
	if (curr != null){
		stack.push(curr);
		curr = curr.left;
	}else{
	/* else if current node is null, we pop an element from the stack,
	 print it and finally set current node to its right child*/
		curr = stack.pop();
		System.out.print(curr.data + " ");
		curr = curr.right;
		}
	}
    } 
	
public static void postorder_using_stack(Node root){
	// create an empty stack and push root node
	Stack<Node> stack = new Stack();
	stack.push(root);

	// create another stack to store post-order traversal
	Stack<Integer> out = new Stack();

	// run till stack is not empty
	while (!stack.empty()){
	// we pop a node from the stack and push the data to output stack
	Node curr = stack.pop();
	out.push(curr.data);

	// push left and right child of popped node to the stack
	if (curr.left != null) {
		stack.push(curr.left);
	}

	if (curr.right != null) {
		stack.push(curr.right);
	}
	}

	// print post-order traversal
	while (!out.empty()) {
		System.out.print(out.pop() + " ");
	}
}
    
    //Height of Binary Tree using Recursion
    public static int height(Node root) {
      	// Write your code here.
          if(root==null) return -1;
          else return 1+Math.max(height(root.left), height(root.right));
    }

	public static Node insert(Node root, int data) {
        if(root==null){
            root = new Node(data);
            return root;
        }
        if(data<=root.data) root.left= insert(root.left, data);
        else if(data>root.data) root.right= insert(root.right, data);
        return root;
    }
    
public static Node search(Node root, int data) 
{ 
    // Base Cases: root is null or key is present at root 
    if (root==null || root.data==data) 
        return root; 
  
    // val is greater than root's key 
    if (root.key > key) 
        return search(root.left, data); 
  
    // val is less than root's key 
    return search(root.right, data); 
} 

public static Node delete(Node root, int data) { 
        /* Base Case: If the tree is empty */
        if (root == null)  return root; 
  
        /* Otherwise, recur down the tree */
        if (data < root.data) 
            root.left = delete(root.left, data); 
        else if (data > root.data) 
            root.right = delete(root.right, data); 
  
        // if key is same as root's key, then This is the node 
        // to be deleted 
        else { 
            // node with only one child or no child 
            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left; 
  
            // node with two children: Get the inorder successor (smallest 
            // in the right subtree) 
            root.key = minValue(root.right); 
  
            // Delete the inorder successor 
            root.right = delete(root.right, root.data); 
        } 
        return root; 
    } 
    
    public static int minValue(Node root) { 
        int min_value = root.data; 
        while (root.left != null) 
        { 
            min_value = root.left.data; 
            root = root.left; 
        } 
        return min_value; 
    } 
    
    public static int maxValue(Node root) { 
        int max_value = root.data; 
        while (root.right != null) 
        { 
            max_value = root.right.data; 
            root = root.right; 
        } 
        return max_value; 
    } 
    

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        preOrder(root);
    }	
}
