import java.util.ArrayList;

public class Runner {

	public static void main(String[] args) {
		
		/*
		 * 
		 *  Program Explanation:
		 *  
		 *  -> Vertex class stores data (here, we are storing only a single int value)
		 *  -> Edge class stores connection between two vertices (start: a vertex, end: a vertex)
		 *  -> Graph class contains arraylist to maintain data about the added vertices and their connection (edges)
		 */
		
		
		
		Graph graph = new Graph();
		
		// Creating new graph
		graph.createGraph();

		// Creating vertices
		Vertex v1 = graph.createVertex(10);
		Vertex v2 = graph.createVertex(15);
		Vertex v3 = graph.createVertex(25);

		// Creating edges
		Edge e1 = graph.createEdge(v1, v2);
		Edge e1a = graph.createEdge(v2, v1);
		Edge e2 = graph.createEdge(v1, v3);
		Edge e3 = graph.createEdge(v2, v3);
		
		// Adding vertices to graph
		graph.addVertex(v1);
		graph.addVertex(v2);
		graph.addVertex(v3);
		
		// Adding edges to graph
		graph.addEdge(e1);
		graph.addEdge(e1a);
		graph.addEdge(e2);
		graph.addEdge(e3);
		
		// deleting vertex (and edges) from graph
		graph.deleteVertex(v3);
		
		// printing available vertices
		graph.printVertices();
		
		// printing available edges
		graph.printEdges();

	}

}
