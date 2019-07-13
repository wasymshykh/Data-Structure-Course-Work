
public class Edge {

	private Vertex start;
	private Vertex end;
	
	public void setEdge(Vertex start, Vertex end) {
		this.start = start;
		this.end = end;
	}
	
	public Vertex getStart() {
		return this.start;
	}
	
	public Vertex getEnd() {
		return this.end;
	}
	
	public String toString() {
		return this.start.getValue() + "->" + this.end.getValue();
	}
	
}
