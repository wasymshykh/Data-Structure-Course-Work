import java.util.ArrayList;

public class Graph {

	private ArrayList<Vertex> vertices;
	private ArrayList<Edge> edges;
	
	public void createGraph() {
		vertices = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
	}
	
	public Vertex createVertex(int value) {
		
		Vertex vertex = new Vertex();
		vertex.setValue(value);
		return vertex;
	}
	
	public Edge createEdge(Vertex start, Vertex end) {
		// creating edge by getting start and end vertex
		if(start == end) {
			System.out.println("Not allowed to add self edge");
			return null;
		}
		Edge edge = new Edge();
		edge.setEdge(start, end);
		return edge;
	}
	
	public void addVertex(Vertex vertex) {
		// adding vertex to arraylist
		vertices.add(vertex);
	}
		
	public void addEdge(Edge edge) {
		if(edge == null) {
			System.out.println("Edge is null");
			return ;
		}
		
		// Checking for valid vertices
			// Is valid start and end vertex
		boolean valid_start = false;
		boolean valid_end = false;
		for(int i = 0; i < vertices.size(); i++) {
			if(!valid_start && vertices.get(i) == edge.getStart()) {
				valid_start = true;
			}
			if(!valid_end && vertices.get(i) == edge.getEnd()) {
				valid_end = true;
			}
		}
		if(!valid_start && !valid_end) {
			System.out.println("Vertices are not added to graph. Add them first.");
			return ;
		}
		
		// Checking if edge already exists
		if(existingEdge(edge)) {
			System.out.println("Edge between vertices already exists.");
			return ;
		}
		
		edges.add(edge);
	}
	
	public boolean existingEdge(Edge edge) {
		for(int i = 0; i < edges.size(); i++) {
			if(edges.get(i).getStart() == edge.getStart() && edges.get(i).getEnd() == edge.getEnd()) {
				return true;
			}
		}
		return false;
	}

	public void deleteVertex(Vertex vertex) {
		// removing edge(s) of the vertex from arraylist
		for(int i = 0; i < edges.size(); i++) {
			if(edges.get(i).getStart() == vertex || edges.get(i).getEnd() == vertex) {
				edges.remove(i);
				i--;
			}
		}
		
		// removing vertex from arraylist
		for(int i = 0; i < vertices.size(); i++) {
			if(vertices.get(i) == vertex) {
				vertices.remove(i);
				break;
			}
		}
	}
	
	public void deleteEdge(Edge edge) {
		// removing edge from arraylist
		for(int i = 0; i < edges.size(); i++) {
			if(edges.get(i) == edge) {
				edges.remove(i);
				break;
			}
		}
	}
	
	public Vertex omega(Edge edge) {
		// returning end vertex of the edge
		return edge.getEnd();
	}
	
	public void printEdges() {
		String str = "Edges: ";
		for(int i = 0; i < edges.size(); i++) {
			str += edges.get(i) + "... ";
		}
		System.out.println(str);
	}
	
	public void printVertices() {
		String str = "Vertices: ";
		for(int i = 0; i < vertices.size(); i++) {
			str += vertices.get(i) + "... ";
		}
		System.out.println(str);
	}
}
