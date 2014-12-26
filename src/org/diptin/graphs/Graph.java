package org.diptin.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;

public class Graph { 

	/**
	 * This class implements simple non-directed and non-weighted graph.
	 * Details of operations are logged into file using log4j.
	 * @author Dipti Nirmale
	 */
	
	static Logger log = Logger.getLogger(Graph.class.getName());

	private HashMap<String, Vertex> graph;

	private enum purpose {addEdge, removeEdge};
	
	public Graph() {
		graph = new HashMap<>();
	}
	
	public int size() {
		return graph.size();
	}
	
	public void addVertex(String label) {
		if (graph.containsKey(label)) {
			log.error("Duplicate entry: The vertex named " + label + " is already present in the graph.");
			return;
		}
		graph.put(label, new Vertex(label));
		log.debug("Added vertex '" + label + "'.");
	}
	
	public void removeVertex (String label) {
		if (!graph.containsKey(label)) {
			log.error("Can not remove vertex '" + label + "'. This vertex not present in graph.");
		}
		Vertex remVertex = graph.get(label);
		Iterator<Vertex> i = remVertex.adjacencyList.iterator();
		Vertex temp;
		while(i.hasNext()) {
			temp = i.next();
			temp.adjacencyList.remove(remVertex);
		}
		remVertex.adjacencyList = null;
		graph.remove(label);
		log.debug("Removed vertex '" + label + "' successfully from the graph.");
	}
	
	public void addEdge (String fromVertex, String toVertex) {
		if (!graph.containsKey(fromVertex))
			log.error("Can not add edge between '" + fromVertex + "' and '" + toVertex + "'. The vertex " + fromVertex + " does not exist on graph");
		else if (!graph.containsKey(toVertex))
			log.error("Can not add edge between '" + fromVertex + "' and '" + toVertex + "'. The vertex " + toVertex + " does not exist on graph");
		else 
			addToAdjacencyList(fromVertex, toVertex);
	}
	
	private void addToAdjacencyList(String vertexLabel1, String vertexLabel2) {
		Vertex vertex1 = graph.get(vertexLabel1);
		Vertex vertex2 = graph.get(vertexLabel2);
		
		makeEdgeConsistent(vertex1, vertex2, purpose.addEdge);
		if (isEdgePresent(vertex1, vertex2)) {
			log.error("Can not add the edge. Edge from vertex '" + vertexLabel1 + "' to '" + vertexLabel2 + "' is already present");
			return;
		}
		vertex1.adjacencyList.add(vertex2);
		vertex2.adjacencyList.add(vertex1);
		log.debug("Edge between '" + vertexLabel1 + "' and '" + vertexLabel2 + "' added successfully");
	}
	
	public void removeEdge (String vertex1, String vertex2) {
		if (!graph.containsKey(vertex1))
			log.error("Can not remove edge between '" + vertex1 + "' and '" + vertex2 + "'. The vertex " + vertex1 + " does not exist on graph");
		else if (!graph.containsKey(vertex2))
			log.error("Can not remove edge between '" + vertex1 + "' and '" + vertex2 + "'. The vertex " + vertex2 + " does not exist on graph");
		else {
			Vertex v1 = graph.get(vertex1);
			Vertex v2 = graph.get(vertex2);
			
			makeEdgeConsistent(v1, v2, purpose.removeEdge);
			if (!isEdgePresent(v1, v2)) {
				log.error("Can not remove. The edge between '" + vertex1 + "' and '" + vertex2 + "' does not exist.");
			}
			else {
				v1.adjacencyList.remove(v2);
				v2.adjacencyList.remove(v1);
				log.debug("The edge between '" + vertex1 + "' and '" + vertex2 + "' removed successfully");
			}
		}			
	}
	
	void printAllVertices() {
		Set<Entry<String, Vertex>> set = graph.entrySet();
		Iterator<Entry<String, Vertex>> i = set.iterator();
		System.out.println("\n/*.....................The vertices and their adjacency lists...........................*/\n");
		while (i.hasNext()) {
			Entry<String, Vertex> row = i.next();
			row.getValue().printVertex(log);
		}
	}
	
    private boolean isEdgePresent(Vertex v1, Vertex v2) {
		if (v1.adjacencyList.contains(v2) && v2.adjacencyList.contains(v1))
			return true;
		return false;
	}

	private boolean makeEdgeConsistent(Vertex v1, Vertex v2, purpose p) {
		switch (p) {
		 	case addEdge: 
		 		if (!v1.adjacencyList.contains(v2) && v2.adjacencyList.contains(v1)) {
		 			log.debug("To make the edge registry consistent, adding vertex " + v2.label + " into adjacency list of " + v1.label);
		 			v1.adjacencyList.add(v2);
		 		}
		 		if (v1.adjacencyList.contains(v2) && !v2.adjacencyList.contains(v1)) {
		 			log.debug("To make the edge registry consistent, adding vertex " + v1.label + " into adjacency list of " + v2.label);
		 			v2.adjacencyList.add(v1);
		 		}
		 		return true;
		 		
		 	case removeEdge:
		 		 if (!v1.adjacencyList.contains(v2) && v2.adjacencyList.contains(v1)) {
		 			 log.debug("To make the edge registry consistent, removing vertex " + v2.label + " from adjacency list of " + v1.label);
					v1.adjacencyList.remove(v2);
		 		 }
		 		 if (v1.adjacencyList.contains(v2) && !v2.adjacencyList.contains(v1)) {
		 			log.debug("To make the edge registry consistent, removing vertex " + v1.label + " from adjacency list of " + v2.label);
					v2.adjacencyList.remove(v1);
		 		 }
		 		 return true;
		 		 
		 	default:
		 		log.error("wrong choice");
		}	
		return false;
	}
	
	//Breadth First Search Traversal
	public void traverseBfs(String label) {
			
		if (!graph.containsKey(label)) {
			System.out.println("No such vertex named '" + label + "' exitsts");
			return;
		}
		HashMap<String, Boolean> visited = new HashMap<>(graph.size());
		
		initializeVisited(visited);
		visited.put(label, true);
		
		LinkedList<String> queue = new LinkedList<>();
		queue.push(label);
		Vertex v;
		
		while (!queue.isEmpty()) {
			
			label = queue.pollLast();
			System.out.print("\t" + label);
			v = graph.get(label);
	
			Iterator<Vertex> itr = v.adjacencyList.iterator();
			while (itr.hasNext()) {
				v = itr.next();
				if (!visited.get(v.label)) {
					visited.put(v.label, true);
					queue.push(v.label);
				}
			}
		}	
		printNonVisitedVertices(visited);			
	}

	private void printNonVisitedVertices(HashMap<String, Boolean> visited) {
		Set<Entry<String, Boolean>> setV = visited.entrySet();
		Iterator<Entry<String, Boolean>> iV = setV.iterator(); 
		
		while (iV.hasNext()) {
			Entry<String, Boolean> entry = iV.next();
			if (!entry.getValue())
				System.out.print("\t" + entry.getKey());
		}
	}

	private void initializeVisited(HashMap<String, Boolean> visited) {
		Set<Entry<String, Vertex>> set = graph.entrySet();
		Iterator<Entry<String, Vertex>> i = set.iterator(); 
		while (i.hasNext()) {
			Entry<String, Vertex> entry = i.next();
			visited.put(entry.getKey(), false);
		}
	}
	
	// Depth First Search Traversal
	public void traverseDfs(String label) {
		
		if (!graph.containsKey(label)) {
			System.out.println("No such vertex named '" + label + "' exitsts");
			return;
		}
		HashMap<String, Boolean> visited = new HashMap<>(graph.size());
		initializeVisited(visited);
		
		Set<Entry<String, Vertex>> set = graph.entrySet();
		Iterator<Entry<String, Vertex>> i = set.iterator(); 
		while (i.hasNext()) {
			Entry<String, Vertex> entry = i.next();
			if (!visited.get(entry.getKey())) 
				recDFS(entry.getValue(), visited);
		}
	}

	private void recDFS(Vertex v, HashMap<String, Boolean> visited) {
		
		visited.put(v.label, true);
		System.out.print("\t" + v.label);
		
		Iterator<Vertex> itr = v.adjacencyList.iterator();
		while (itr.hasNext()) {
			if (!visited.get(itr.next()))
				recDFS(itr.next(), visited);
		}
	}

	public static void main(String[] args) {

		log.info("Initializing Graph ");
		Graph gph = new Graph();
		gph.addVertex("one");
		gph.addVertex("two");
		gph.addVertex("three");
		gph.addVertex("four");
		
		gph.addEdge("one", "three");
		gph.addEdge("one", "two");
		gph.addEdge("three", "four");
		gph.addEdge("four", "three");
		gph.addEdge("two", "four");
		
//		gph.removeVertex("one");
		
//		gph.removeEdge("one", "two");
		gph.removeEdge("two", "five");
		
//		gph.printAllVertices();
		System.out.println("\nBFS Traversal");
		gph.addVertex("ten");
		gph.traverseBfs("two");
		
		System.out.println("\nDFS Traversal");
		gph.traverseBfs("two");

	}
}

class Vertex {
	String label;
	ArrayList<Vertex> adjacencyList;
	
	public Vertex (String name) {
		label = name;
		adjacencyList = new ArrayList<>();
	}
	
	void printVertex(Logger log) {
		System.out.print(label + "--->");
		if (adjacencyList.isEmpty()) {
			System.out.println(" Degree of this vertex is zero.. Remote Vertex");
		}
		else 
		{
			Iterator<Vertex> i =adjacencyList.iterator();
			while (i.hasNext()) {
				System.out.print("\t" + i.next().label);
			}
			System.out.println();
		}
	}
}
