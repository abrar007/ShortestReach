package shortestReach;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	
	static Scanner scan;
	public static ArrayList<Vertex> graph;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
			graph=new ArrayList<Vertex>();
			scan=new Scanner(System.in);
			int q=scan.nextInt();
			for(int i=0;i<q;i++) {
				int n=scan.nextInt();
				int m=scan.nextInt();
				graphRepresentation(n,m);
				int starting_node=scan.nextInt();
				printGraph();
				System.out.println("-------------- ");
				BFS(starting_node);
				graph.clear();
			}
			
		
		
		
	}
	public static void graphRepresentation(int n,int m) {
		for(int i=0;i<n;i++) {
			Vertex v= new Vertex();
			v.name=i+1;
			graph.add(v);
		}
		for(int i=0;i<m;i++) {
			int u=scan.nextInt();
			int v=scan.nextInt();
			graph.get(u-1).neighbourList.add(graph.get(v-1));
			graph.get(v-1).neighbourList.add(graph.get(u-1));
		}
	}
	public static void printGraph() {
		for(int i=0;i<graph.size();i++) {
			System.out.print(graph.get(i).name+"->");
			for(int j=0;j<graph.get(i).neighbourList.size();j++) {
				System.out.print(graph.get(i).neighbourList.get(j).name+"->");
			}
			System.out.println();
		}
		
	}
	
	public static void BFS(int starting_node) {
		Queue<Vertex> queue= new LinkedList<Vertex>();
		graph.get(starting_node-1).visited=true;
		queue.add(graph.get(starting_node-1));
		int counter=0;
		while(!queue.isEmpty()) {
				
	            // Dequeue a vertex from queue and print it 
	            Vertex s = queue.poll(); 
	            // Get all adjacent vertices of the dequeued vertex s 
	            // If a adjacent has not been visited, then mark it 
	            // visited and enqueue it 
	            System.out.print(s.getName()+" ");
	            counter++;
	            System.out.println(counter);
	            for(int i=0;i<s.neighbourList.size();i++) {
	        	   if(!s.neighbourList.get(i).visited) {
	        		   s.neighbourList.get(i).visited=true;
	        		   queue.add(s.neighbourList.get(i));
	        	   }
	           
	           }
	         

		}
		
		
	}

}

class Vertex{
	
	int name=0;
	ArrayList<Vertex> neighbourList;
	boolean visited=false;
	int distance=0;
	
	public Vertex() {
		neighbourList=new ArrayList<Vertex>();
		
	}
	public int getName() {
		return name;
	}
}
