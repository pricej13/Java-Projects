//james price
//csc 364
//12/15/17


package csc364final;

public class BST<E extends Comparable<E>> {
	private TreeNode<E> root;
	private int size = 0;
	
	//... various additional methods ...
	
	private TreeNode<E> findNode(E e, TreeNode<E> root) {
		if(null == e) {
			return null;
		}
		//found the value
		if(e == root.element) {
			return root;
		}
		//search left sub tree
		else if(findNode(e,root.left)!=null) {
			return findNode(e,root.left); 
		}
		else { 
		//search right sub tree 
		return findNode(e,root.right);
		}

		}

	
	public boolean contains(E e) {
		//use find node to find node with element looking for
		if (e==findNode(e,root)) {
			return true;
		}
		return false;
	}
	
	private boolean inSubtree(E e1, E e2) {
		//checks to see if node with elememt e2, then uses it as a root to find e1
		if(e2==findNode(e2,root)) {
			if(e1==findNode(e1,findNode(e2,root))) {
				return true;
			}
		}
			return false;
	}
	
	public int numGreater(E lowerBound) {
		//searches the left and right paths of the lowerbound node. counting each node that is not null. note that the nodes on the left of the subtrees counted are after going one node to the right first.
		int count = 0;
		if(contains(lowerBound)) {
			TreeNode<E> a = findNode(lowerBound,root);
			TreeNode<E> b = findNode(lowerBound,root);
			a = a.right;
			while ( a != null) {
				a = a.left;
				count++;
			}
			while ( b != null) {
				b = b.right;
				count++;
			}
		}
		return count;
	}
	

	//tree node class
	private static class TreeNode<E extends Comparable<E>> {
		E element;
		TreeNode<E> left;
		TreeNode<E> right;
		
		TreeNode(E e) {
			element = e;
		}
	}
}