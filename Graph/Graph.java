import java.util.*;
class Graph {
	List<Edge> allEdges ;
	Map<Long,Vertex> allVertices;
	boolean isDirected=false;
	Graph(boolean isDirected) {
		allEdges = new ArrayList<Edge>();
		allVertices = new HashMap<Long,Vertex>();
		this.isDirected=isDirected;
	}
	public void addVertex(Vertex v1) {
		if(allVertices.containsKey(v1.getId())) return;
		allVertices.put(v1.getId(), v1);
		for(Edge e: v1.getAdjEdge()) {
			allEdges.add(e);
		}
	}
	 public void addEdge(long id1, long id2){
        addEdge(id1,id2,0);
    }
    public void addEdge(long id1,long id2, int weight){
        Vertex vertex1 = null;
        if(allVertices.containsKey(id1)){
            vertex1 = allVertices.get(id1);
        }else{
            vertex1 = new Vertex(id1);
            allVertices.put(id1, vertex1);
        }
        Vertex vertex2 = null;
        if(allVertices.containsKey(id2)){
            vertex2 = allVertices.get(id2);
        }else{
            vertex2 = new Vertex(id2);
            allVertices.put(id2, vertex2);
        }

        Edge edge = new Edge(vertex1,vertex2,isDirected,weight);
        allEdges.add(edge);
        vertex1.addVertex(edge, vertex2);
        if(!isDirected){
            vertex2.addVertex(edge, vertex1);
        }

    }
    public Collection<Vertex> getAllVertices() {
    	return allVertices.values();
    }

}
class Vertex {
	long id;
	int data;
	List<Vertex> adjVertex;
	List<Edge> adjEdge;
	Vertex(long id) {
		this.id =id;
		adjVertex= new ArrayList<Vertex>();
		adjEdge= new ArrayList<Edge>();
	}
	public List<Vertex> getAdjVertex() {
		return adjVertex;
	}
	public List<Edge> getAdjEdge() {
		return adjEdge;
	}
	public void addVertex(Edge e, Vertex v) {
		adjEdge.add(e);
		adjVertex.add(v);
	}
	public long getId() {
		return id;
	}
	
}
class Edge {
	Vertex v1;
	Vertex v2;
	int weight;
	boolean isDirected= false;
	Edge(Vertex v1, Vertex v2, boolean isDirected, int weight) {
		this.v1=v1;
		this.v2=v2;
		this.isDirected=isDirected;
		this.weight=weight;
	}
	Edge(Vertex v1, Vertex v2, int weight) {
		this.v1=v1;
		this.v2=v2;
		this.weight=weight;
	}
	public Vertex getVertex1() {
		return v1;
	}
	public Vertex getVertex2() {
		return v2;
	}
	public boolean isDirected() {
		return  isDirected;
	}
	public int getWeight() {
		return weight;
	}

}