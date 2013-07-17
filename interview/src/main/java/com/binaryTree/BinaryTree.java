package com.binaryTree;

import java.util.Stack;

public class BinaryTree<E> {
	
	public static void main(String args[]) {
		Node<Integer> root = new Node<Integer>(2);
		Node<Integer> child7 = new Node<Integer>(7);
		Node<Integer> child5 = new Node<Integer>(5);
		Node<Integer> child1 = new Node<Integer>(1);
		Node<Integer> child6 = new Node<Integer>(6);
		Node<Integer> child9 = new Node<Integer>(9);
		Node<Integer> child10 = new Node<Integer>(10);
		Node<Integer> child11 = new Node<Integer>(11);
		Node<Integer> child4 = new Node<Integer>(4);
		
		root.left = child7;
		root.right = child5;
		
		child7.left = child1;
		child7.right = child6;
		
		child6.left = child10;
		child6.right = child11;
		
		child5.right = child9;
		child9.left = child4;
		
		BinaryTree<Integer> it = new BinaryTree<Integer>();
		it.inOrder_recursive(root);
		System.out.println("Non recursive");
		it.inOrder(root);
	
	}
	
	public void preOrder_recursive(Node<E> root) {
		if (root == null) return;
		System.out.println(root.getNodeValue());
		preOrder_recursive(root.left);
		preOrder_recursive(root.right);
	}
	
	public void postOrder_recursive(Node<E> root) {
		if(root == null) return;
		postOrder_recursive(root.left);
		postOrder_recursive(root.right);
		System.out.println(root.getNodeValue());
	}
	
	public void inOrder_recursive(Node<E> root) {
		if(root == null) return;
		inOrder_recursive(root.left);
		System.out.println(root.getNodeValue());
		inOrder_recursive(root.right);
	}
	
	public void preOrder(Node<E> root) {
		Stack<Node<E>> st = new Stack<Node<E>>();
		st.push(root);
		while (!st.isEmpty()) {
			Node<E> n = st.pop();
			System.out.println(n.getNodeValue());
			if(n.right != null) st.push(n.right);
			if(n.left != null) st.push(n.left);
		}
		
	}
	
	public void postOrder(Node<E> root) {
		Stack<Node<E>> st = new Stack<Node<E>>();
		st.push(root);
		while(!st.isEmpty()) {
			Node<E> n = st.pop();
			if(n.right != null) st.push(n.right);
			if(n.left != null) st.push(n.left);
			System.out.println(n.getNodeValue());
		}
	}
	
	public void inOrder(Node<E> root) {
		Stack<Node<E>> st = new Stack<Node<E>>();
		st.push(root);
		while (!st.empty()) {
			Node<E> n = st.peek();
			if (n.left != null && !n.left.visited) {
				st.push(n.left);
				continue;
			}else if (!n.visited) {
				n.visited =true;
				System.out.println(n.getNodeValue());
			}
			if (n.right != null && !n.right.visited) {
				st.push(n.right);
			} else {
				st.pop();
			}
		}
	}
	
	
	/*public void inOrder(Node<E> root) {
		Stack<Node<E>> st = new Stack<Node<E>>();
		boolean done = false;
		Node<E> current = root;
		while (!done) {
			if (current != null) {
				st.push(current);
				current = current.left;
			} else {
				if (!st.isEmpty()) {
					current = st.pop();
					System.out.println(current.getNodeValue());
					current = current.right;
				} else {
					done =true;
				}
			}
		}
	}*/
	
	
	
}
class Node<E> {
	E element;
	Node<E> right;
	Node<E> left;
	boolean visited = false;
	Node(E element) {
		this.element = element;
	}
	 Node<E> getLeft() {return left;}
	 Node<E> getRight() {return right;}
	 String getNodeValue() {return element.toString();}
}

