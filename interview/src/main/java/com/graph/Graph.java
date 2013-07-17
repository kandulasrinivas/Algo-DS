package com.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph<E>{
	 
    //Because we will need random access to the Edges
    //We will use an ArrayList to hold them
    private ArrayList<Edge<E>> edges; 

    public Graph(){
         edges = new ArrayList<Edge<E>>();
    }

    //add Edge to the List
    public boolean addEdge(Edge<E> vertex){
         if(edges.contains(vertex)) return false;
         edges.add(vertex);
         return true;
    }

    public boolean contains(Edge<E> vertex){
        return edges.contains(vertex);
    }

    public Edge<E> get(int index){
       return edges.get(index);
    }

    //returns number of Edges in Graph
    public int count(){return edges.size();}

    public boolean equals(Graph<E> other){

        if(other.edges.size() != edges.size())
            return false;

        //store all of Edges of larger Graph 
        ArrayList<Edge<E>> temp = new ArrayList<Edge<E>>(other.edges);
                
        //if temp changed, then the Graphs are not equal
        return temp.retainAll(edges); 
    }
    
    public static void main(String args[]) {
    	//This graph is from "Algorithems in C Page 120"
    	Edge<Integer> e0 = new Edge<Integer>(0,0);
    	
    	Edge<Integer> e1 = new Edge<Integer>(1,0);
    	Edge<Integer> e2 = new Edge<Integer>(2,0);
    	Edge<Integer> e3 = new Edge<Integer>(3,0);
    	Edge<Integer> e4 = new Edge<Integer>(4,0);
    	Edge<Integer> e5 = new Edge<Integer>(5,0);
    	Edge<Integer> e6 = new Edge<Integer>(6,0);
    	Edge<Integer> e7 = new Edge<Integer>(7,0);
    	e0.connectTo(e1);
    	e0.connectTo(e2);
    	e0.connectTo(e7);
    	e0.connectTo(e5);
    	e0.connectTo(e6);
    	
    	e7.connectTo(e4);
    	e5.connectTo(e3);
    	e3.connectTo(e4);
    	e5.connectTo(e4);
    	e4.connectTo(e6);

    	Graph<Integer> g = new Graph<Integer>();
    	g.addEdge(e0);
    	g.addEdge(e1);
    	g.addEdge(e2);
    	g.addEdge(e3);
    	g.addEdge(e4);
    	g.addEdge(e5);
    	g.addEdge(e6);
    	g.addEdge(e7);
    	//g.DFS_normal(e0);
    	
    	//This graph is from http://www.programmerinterview.com/index.php/data-structures/dfs-vs-bfs/
    	
    	Edge<Integer> e11 = new Edge<Integer>(1,0);
    	Edge<Integer> e12 = new Edge<Integer>(2,0);
    	Edge<Integer> e13 = new Edge<Integer>(3,0);
    	Edge<Integer> e14 = new Edge<Integer>(4,0);
    	Edge<Integer> e15 = new Edge<Integer>(5,0);
    	Edge<Integer> e16 = new Edge<Integer>(6,0);
    	Edge<Integer> e17 = new Edge<Integer>(7,0);
    	Edge<Integer> e18 = new Edge<Integer>(8,0);
    	Edge<Integer> e19 = new Edge<Integer>(9,0);
    	Edge<Integer> e20 = new Edge<Integer>(10,0);
    	Edge<Integer> e21 = new Edge<Integer>(11,0);
    	Edge<Integer> e22 = new Edge<Integer>(12,0);
    	Edge<Integer> e23 = new Edge<Integer>(13,0);
    	
    	e11.connectTo(e12);
    	e11.connectTo(e13);
    	e11.connectTo(e14);
    	
    	e12.connectTo(e15);
    	e12.connectTo(e16);
    	
    	e15.connectTo(e19);
    	e15.connectTo(e20);
    	
    	e14.connectTo(e17);
    	e14.connectTo(e18);
    	
    	e17.connectTo(e21);
    	e17.connectTo(e22);
    	
    	//g.DFS_normal(e11);
    	//g.BFS_normal(e11);
    	//g.DFS_recursive(e11);
    	
    	
    	
    }
    
    /*
     * Differences between DFS and BFS
		Comparing BFS and DFS, the big advantage of DFS is that 
		it has much lower memory requirements than BFS, 
		because it’s not necessary to store all of the child pointers at each level. 
		Depending on the data and what you are looking for, 
		either DFS or BFS could be advantageous.

		For example, given a family tree if one were looking for 
		someone on the tree who’s still alive, then it would be 
		safe to assume that person would be on the bottom of the tree. 
		This means that a BFS would take a very long time to reach that last level. 
		A DFS, however, would find the goal faster. But, if one were 
		looking for a family member who died a very long time ago, 
		then that person would be closer to the top of the tree. 
		Then, a BFS would usually be faster than a DFS. So, the advantages of 
		either vary depending on the data and what you’re looking for.
     */
    
    public void DFS_normal(Edge<E> start) {
    	Stack<Edge<E>> st = new Stack<Edge<E>>();
    	st.push(start);
    	start.visited = true;
    	System.out.println("The valud is " + start.toString());
    	while(!st.isEmpty()) {
    			Edge<E> currentNode = st.peek();
    			Edge<E> child = getUnVisitedNodes(currentNode);
    			if (child!=null) {
    				child.visited =true;
    				st.push(child);
    				System.out.println("The valud is " + child.toString());
    			}else {
    				st.pop();
    			}
    	}
    }
    
    public void DFS_recursive(Edge<E> start) {
    	Stack<Edge<E>> st = new Stack<Edge<E>>();
    	st.push(start);
    	start.visited = true;
    	System.out.println("The valud is " + start.toString());
    	while(!st.isEmpty()) {
    			Edge<E> currentNode = st.peek();
    			Edge<E> child = getUnVisitedNodes(currentNode);
    			if (child!=null) {
    				DFS_recursive(child);
    			}else {
    				st.pop();
    			}
    	}
    }
    
    public void BFS_normal(Edge<E> start) {
    	Queue<Edge<E>> queue = new LinkedList<Edge<E>>();
    	start.visited = true;
    	queue.add(start);
    	System.out.println(start.toString());
    	while(!queue.isEmpty()) {
    		Edge<E> currentNode = queue.remove();
    		Edge<E> child = null;
    		while((child=getUnVisitedNodes(currentNode)) != null) {
    			child.visited = true;
    			queue.add(child);
    			System.out.println(child.toString());
    		}
    	}
    	
    }
    
    public Edge<E> getUnVisitedNodes(Edge<E> start) {
    	LinkedList<Connector<E>> pointers = start.getConnections();
    	//find the first unvisited node and return it
    	Iterator <Connector<E>> itr = pointers.iterator();
    	while (itr.hasNext()) {
    		Connector<E> connection = itr.next();
    		Edge<E> child = connection.getTwo();
    		if (!child.visited) return child;
    	}
    	return null;
    }
    
    public void preOrderTraversal(Edge<E> start) {
    	start.visited = true;
    	System.out.println(start.toString());
    	Iterator<Connector<E>> itr = start.iterator();
    	while(itr.hasNext()) {
    		Connector<E> child = itr.next();
    		if (!child.getTwo().visited) 
    			preOrderTraversal(start);
    		
    	}
    	
    }
    
}

